package crud.controllers;

import act.Act;
import act.db.DaoBase;
import act.db.DaoLoader;
import act.inject.param.NoBind;
import org.osgl.$;
import org.osgl.inject.BeanSpec;
import org.osgl.util.Generics;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public abstract class CrudBase<ID, T, D extends DaoBase<ID, T, ?>> {
    @NoBind
    protected D dao;

    public CrudBase() {
        this.exploreTypes();
    }

    public CrudBase(D dao) {
        this.dao = $.requireNotNull(dao);
    }

    private void exploreTypes() {
        Map<String, Class> typeParamLookup = Generics.buildTypeParamImplLookup(getClass());
        List<Type> types = Generics.typeParamImplementations(getClass(), CrudBase.class);
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
