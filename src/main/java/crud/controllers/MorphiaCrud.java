package crud.controllers;

import act.db.morphia.MorphiaDaoBase;
import crud.models.MorphiaModelX;
import org.osgl.mvc.annotation.Before;

import java.util.List;

public class MorphiaCrud<ID, T extends MorphiaModelX> extends CrudBase<ID, T, MorphiaDaoBase<ID, T>> {
    @Before
    public void initCrudMorphia() {
    }

}
