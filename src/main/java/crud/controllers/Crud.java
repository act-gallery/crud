package crud.controllers;

import act.Act;
import act.app.ActionContext;
import act.app.App;
import act.db.DaoBase;
import act.db.DaoLoader;
import act.inject.param.NoBind;
import act.job.OnAppStart;
import act.util.Global;
import act.util.PropertySpec;
import crud.util.*;
import net.oschina.j2cache.*;
import org.nustaq.serialization.FSTConfiguration;
import org.osgl.$;
import org.osgl.inject.BeanSpec;
import org.osgl.mvc.annotation.*;
import org.osgl.util.Generics;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.validation.Valid;

import static act.controller.Controller.Util.notFoundIfNull;

public abstract class Crud<ID, T, D extends DaoBase<ID, T, ?>> {

    @Global
    @NoBind
    protected D dao;

    @Global
    @NoBind
    protected CacheChannel cache;

    /**
     * 依赖注入：上下文环境
     */
    @Inject
    private ActionContext context;

    public Crud() {
        this.exploreTypes();
    }

    public Crud(D dao) {
        this.dao = $.requireNotNull(dao);
    }

    @Before
    //@OnAppStart
    public void init() {
        context.login("crud");
        cache = J2Cache.getChannel();
        FSTConfiguration conf = FSTConfiguration.getDefaultConfiguration();
        conf.setClassLoader(App.instance().classLoader());
    }

    /**
     * 列表：根据条件查找
     *
     * @param idList
     * @return 查找到的对象列表
     */
    @PostAction
    public ResponseData list(List<ID> idList, RequestData d) {
        setPropertySpec(d);
        Iterable<T> objList = idList.isEmpty() ? dao.findAll() : dao.findByIdList(idList);
        Sort s1 = new Sort("name", true);
        return new ResponseData(objList, new Page(1, 10, 20L, 2), new Sort[]{s1});
    }

    /**
     * 查看：根据ID查找
     *
     * @param id
     * @return 查找到的对象
     */
    @PostAction("show/{id}")
    @ResponseStatus(200)
    public T show(ID id, RequestData d) {
        T obj = null;
        CacheObject co = cache.get("default", id.toString());
        if(null != co && null != co.getValue()) {
            obj = (T) co.getValue();
        }
        if(null == obj) {
            obj = dao.findById(id);
            notFoundIfNull(obj);
            if(null != obj) {
                cache.set("default", id.toString(), obj);
            }
        }
        obj = showHook(obj);
        setPropertySpec(d);
        return obj;
    }

    protected T showHook(T obj) {
        return obj;
    }

    /**
     * 创建
     *
     * @param obj
     * @return 创建后的对象
     */
    @PostAction("create")
    public T create(@Valid T obj, RequestData d) {
        setPropertySpec(d);
        T t = dao.save(obj);
        return t;
    }

    /**
     * 更新
     *
     * @param id
     * @param obj
     * @return 更新后的对象
     */
    @PutAction("{id}")
    public T update(ID id, @Valid T obj, RequestData d) {
        T oobj = dao.findById(id);
        $.merge(obj).filter("-id,-v").to(oobj);
        setPropertySpec(d);
        return dao.save(oobj);
    }

    /**
     * 删除
     *
     * @param id
     */
    @DeleteAction("{id}")
    public void delete(ID id) {
        //方法一：直接使用dao根据ID删除
        dao.deleteById(id);

        //方法二：先根据id查找对象，然后通过dao删除对象
        //T obj = dao.findById(id);
        //dao.delete(obj);
    }

    public void setPropertySpec(RequestData d) {
        if (null != d && null != d.fields) {
            PropertySpec.current.set(d.fields);
        }
    }

    private void exploreTypes() {
        Map<String, Class> typeParamLookup = Generics.buildTypeParamImplLookup(getClass());
        List<Type> types = Generics.typeParamImplementations(getClass(), Crud.class);
        int sz = types.size();
        if (sz < 3) {
            throw new IllegalArgumentException("Cannot determine DAO type");
        }
        Type daoType = types.get(2);
        BeanSpec spec = BeanSpec.of(daoType, Act.injector(), typeParamLookup);
        DaoLoader loader = Act.getInstance(DaoLoader.class);
        dao = $.cast(loader.load(spec));
    }
}
