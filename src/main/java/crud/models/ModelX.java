package crud.models;

import act.db.CreatedAt;
import act.db.LastModifiedAt;
import act.util.SimpleBean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class ModelX implements SimpleBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @CreatedAt
    public Date createdAt;

    @LastModifiedAt
    public Date modifiedAt;

    public Integer status;
}