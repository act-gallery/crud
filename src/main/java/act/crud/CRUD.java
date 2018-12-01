package act.crud;

import act.app.App;
import act.app.conf.AutoConfig;
import act.controller.Controller;
import act.db.Dao;
import org.osgl.$;
import org.osgl.mvc.result.Result;
import org.osgl.util.Const;
import org.osgl.util.Generics;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Port from Play 1.4 CRUD module
 */
@AutoConfig("crud")
public abstract class CRUD<MODEL> {

    /**
     * Configuration `crud.page.size`
     *
     * Default value: `30`
     */
    public static final Const<Integer> PAGE_SIZE = $.constant(30);

    private Class<MODEL> modelType;
    private Dao<?, MODEL, ?> dao;

    public CRUD() {
        List<Type> typeParams = Generics.typeParamImplementations(getClass(), CRUD.class);
        modelType = (Class) typeParams.get(0);
        dao = App.instance().dbServiceManager().dao(modelType);
    }

    public CRUD(Class<MODEL> modelType) {
        this.modelType = $.requireNotNull(modelType);
        dao = App.instance().dbServiceManager().dao(modelType);
    }

    public Result index() {
        return Controller.Util.renderTemplate("CRUD/index.html");
    }

    /*public Result list(int page, String search, String searchFields, String orderBy, String order) {

    }*/

}
