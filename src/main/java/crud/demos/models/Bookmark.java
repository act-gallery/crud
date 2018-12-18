package crud.demos.models;

import act.util.SimpleBean;
import crud.models.ModelX;

import javax.persistence.*;

@Entity(name = "bookmark")
public class Bookmark extends ModelX { // implements SimpleBean

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;*/

    public String name;

    public String title;

    public String url;

    @Transient
    public User user;

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }*/

    public Bookmark() {
    }
}