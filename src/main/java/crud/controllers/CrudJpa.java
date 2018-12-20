package crud.controllers;

import act.db.jpa.JPADao;
import crud.models.ModelX;
import org.osgl.mvc.annotation.*;

public abstract class CrudJpa<ID, T extends ModelX> extends Crud<ID, T, JPADao<ID, T>> {

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