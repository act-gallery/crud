package crud.models;

import act.db.CreatedAt;
import act.db.LastModifiedAt;
import act.inject.param.NoBind;
import act.util.SimpleBean;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Version;

@NoBind
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
    public DateTime ct;

    /**
     * 最后修改时间
     */
    @Indexed
    @LastModifiedAt
    public DateTime my;

}
