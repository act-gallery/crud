package crud.util;

public class ResponseData {
    public Object result;

    public Page page;

    public Sort[] sorts;

    public Boolean _rd = true;

    public ResponseData() {
    }

    public ResponseData(Object result) {
        this.result = result;
    }

    public ResponseData(Object result, Page page) {
        this.result = result;
        this.page = page;
    }

    public ResponseData(Object result, Page page, Sort[] sorts) {
        this.result = result;
        this.page = page;
        this.sorts = sorts;
    }
}
