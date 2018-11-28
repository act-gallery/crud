package crud.demos.models;

import crud.models.ModelX;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends ModelX {

    @NotNull
    @Size(min = 3, max = 20)
    public String name;

    @Min(18)
    @Max(60)
    public Integer age;

    public User() {
    }
}
