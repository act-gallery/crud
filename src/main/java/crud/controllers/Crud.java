package crud.controllers;

import act.app.ActionContext;
import act.app.util.SimpleRestfulServiceBase;
import act.db.jpa.JPADao;
import act.util.PropertySpec;
import crud.models.ModelX;
import crud.util.Page;
import crud.util.RequestData;
import crud.util.ResponseData;
import crud.util.Sort;
import org.osgl.$;
import org.osgl.mvc.annotation.*;

import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;

public abstract class Crud<ID, T extends ModelX> extends CrudBase<ID, T, JPADao<ID, T>> {

    /**
     * 依赖注入：DAO
     */
    //@Inject
    //protected JPADao<ID, T> dao;

    /**
     * 批量更新
     * @return 批量更新成功的数量
     */
    @PostAction("updateBatch")
    public Long updateBatch() {
        return 0L;
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