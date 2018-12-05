package crud.demos.models;

import crud.models.ModelX;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends ModelX {

    @NotNull
    @Size(min = 3, max = 20)
    public String name;

    @Min(18)
    @Max(60)
    public Integer age = 0;

    @Transient
    public Group group;

    @Transient
    public List<Address> addressList;

    public User() {
    }

    public Group getGroup() {
        Group g = new Group("group1", "group 1 desc");
        return g;
    }

    public List<Address> getAddressList() {
        List<Address> addresses = new ArrayList<>();
        Address a1 = new Address("addr1", "x road num y");
        addresses.add(a1);
        Address a2 = new Address("addr2", "a road num b");
        addresses.add(a2);

        return addresses;
    }
}
