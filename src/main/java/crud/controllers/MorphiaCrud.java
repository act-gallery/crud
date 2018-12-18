package crud.controllers;

import act.db.morphia.MorphiaDaoBase;
import act.db.morphia.MorphiaModel;
import org.bson.types.ObjectId;
import org.osgl.mvc.annotation.Before;
import org.osgl.mvc.annotation.PostAction;
import org.osgl.mvc.annotation.ResponseStatus;

import java.util.List;

public class MorphiaCrud<ID, T extends MorphiaModel> extends CrudBase<ID, T, MorphiaDaoBase<ID, T>> {
    @Before
    public void initCrudMorphia() {
    }

}
