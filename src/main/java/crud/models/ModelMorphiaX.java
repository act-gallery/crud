package crud.models;

import act.db.CreatedAt;
import act.db.CreatedBy;
import act.db.LastModifiedAt;
import act.db.LastModifiedBy;
import act.inject.param.NoBind;
import act.util.SimpleBean;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Version;

import java.util.Date;
import javax.persistence.MappedSuperclass;

@NoBind
@MappedSuperclass
public abstract class ModelMorphiaX implements SimpleBean {

    /**
     * 主键
     */
    @Id
    public ObjectId id;

    /**
     * 版本号
     */
    @Version
    public Long v;

    /**
     * 数据状态：
     * 0 - 禁用
     * 1 - 启用
     * 9 - 逻辑删除
     */
    public Integer st = 1;

    /**
     * 创建时间
     */
    @Indexed
    @CreatedAt
    public Date ct;

    @CreatedBy
    public String cu;

    /**
     * 最后修改时间
     */
    @Indexed
    @LastModifiedAt
    public Date mt;

    @LastModifiedBy
    public String mu;

}
