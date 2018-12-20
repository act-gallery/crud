package crud.controllers;

import act.db.morphia.MorphiaDaoBase;
import crud.models.ModelMorphiaX;
import org.osgl.mvc.annotation.Before;

public class CrudMorphia<ID, T extends ModelMorphiaX> extends Crud<ID, T, MorphiaDaoBase<ID, T>> {
    @Before
    public void initCrudMorphia() {
    }

}
