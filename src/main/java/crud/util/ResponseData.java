package crud.util;

public class ResponseData {
    public Object result;

    public Long totalCount;

    public Long totalPage;

    public ResponseData() {
    }

    public ResponseData(Object result) {
        this.result = result;
    }

    public ResponseData(Object result, Long totalCount, Long totalPage) {
        this.result = result;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }
}
