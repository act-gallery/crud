package crud.demos.models;

import act.util.SimpleBean;

import javax.persistence.*;

@Entity(name = "bookmark")
public class Bookmark implements SimpleBean { //extends ModelX {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String url;

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

}