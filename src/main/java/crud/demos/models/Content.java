package crud.demos.models;

import act.db.DB;
import act.db.morphia.MorphiaModel;
import org.mongodb.morphia.annotations.Entity;

@DB("db2")
@Entity("bookmark")
public class Content extends MorphiaModel<Content> {
    public String title;

    public String url;
}
