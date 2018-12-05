package crud.util;

public class ResponseData {
    public Object result;

    public Page page;

    public ResponseData() {
    }

    public ResponseData(Object result) {
        this.result = result;
    }

    public ResponseData(Object result, Page page) {
        this.result = result;
        this.page = page;
    }
}
