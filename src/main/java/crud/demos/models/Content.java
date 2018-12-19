package crud.demos.models;

import act.db.DB;
import crud.models.MorphiaModelX;
import org.mongodb.morphia.annotations.Entity;

@DB("db2")
@Entity("bookmark")
public class Content extends MorphiaModelX { //extends MorphiaModel<Content> {
    public String title;

    public String url;
}
