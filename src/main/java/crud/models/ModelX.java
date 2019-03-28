package crud.models;

import act.db.CreatedAt;
import act.db.LastModifiedAt;
import act.util.SimpleBean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class ModelX implements SimpleBean, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Version
    public Long v = 1L;

    public Integer st = 1;

    @CreatedAt
    public Date ct;

    @LastModifiedAt
    public Date mt;
}