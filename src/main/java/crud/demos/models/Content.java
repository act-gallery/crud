package crud.demos.models;

import act.db.DB;
import crud.models.ModelX;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "content")
public class Content extends ModelX {

    @NotNull
    public String title;

    public String summary;

    //@NotNull
    public String content;

    public String picture;

    public String ip;

    public String url;

    @Transient
    public User author;
}
