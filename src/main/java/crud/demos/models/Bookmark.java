package crud.demos.models;

import act.db.DB;
import crud.models.ModelMorphiaX;
import org.mongodb.morphia.annotations.Entity;

import javax.validation.constraints.NotNull;

@DB("db2")
@Entity("bookmark")
public class Bookmark extends ModelMorphiaX {

    @NotNull
    public String title;

    public String url;

    public Integer viewTimes;

    public Bookmark() {
    }
}