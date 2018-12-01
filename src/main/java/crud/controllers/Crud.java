package crud.controllers;

import act.app.ActionContext;
import act.db.jpa.JPADao;
import crud.models.ModelX;
import org.osgl.$;
import org.osgl.mvc.annotation.*;

import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;

public abstract class Crud<ID, T extends ModelX> extends ControllerX {

    /**
     * 依赖注入：DAO
     */
    @Inject
    protected JPADao<ID, T> dao;

    /**
     * 依赖注入：上下文环境
     */
    @Inject
    private ActionContext context;

    /**
     * 列表：根据条件查找
     * @param idList
     * @return 查找到的对象列表
     */
    @GetAction()
    public Iterable<T> list(List<ID> idList) {
        return idList.isEmpty() ? dao.findAll() : dao.findByIdList(idList);
    }

    /**
     * 查看：根据ID查找
     * @param id
     * @return 查找到的对象
     */
    @GetAction("{id}")
    public T show(ID id) {
        return dao.findById(id);
    }

    /**
     * 创建
     * @param obj
     * @return 创建后的对象
     */
    @PostAction()
    public T create(@Valid T obj) {
        if(context.hasViolation()) {
            renderJson(context.violations());
            //renderText("Error(s): \n%s", context.violationMessage());
        }
        return dao.save(obj);
    }

    /**
     * 更新
     * @param id
     * @param obj
     * @return 更新后的对象
     */
    @PutAction("{id}")
    public T update(ID id, @Valid T obj) {
        T oobj = dao.findById(id);
        //$.copy(obj).to(oobj);
        $.merge(obj).to(oobj);
        return dao.save(oobj);
    }

    /**
     * 批量更新
     * @return 批量更新成功的数量
     */
    @PostAction("updateBatch")
    public Long updateBatch() {
        return 0L;
    }

    /**
     * 删除
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

    /**
     * 批量删除
     * @return 批量删除成功的数量
     */
    @DeleteAction("deleteBatch")
    public Long deleteBatch() {
        return 0L;
    }

}