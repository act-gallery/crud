package crud.util;

public class Sort {
    public String field;

    public Boolean iaDesc;

    public Sort() {
    }

    public Sort(String field, Boolean iaDesc) {
        this.field = field;
        this.iaDesc = iaDesc;
    }
}
