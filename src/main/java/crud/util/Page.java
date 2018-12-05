package crud.util;

import crud.consts.ConstX;

public class Page {

    public Integer page = 1;

    public Integer pageSize = ConstX.DEFAULT_PAGE_SIZE;

    public Long totalCount = 0L;

    public Integer totalPage = 0;

    public Page() {
    }

    public Page(Integer page, Integer pageSize, Long totalCount, Integer totalPage) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }
}
