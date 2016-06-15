package cn.jmo.hello.helper;

import java.util.List;

/**
 * Created by qiangzi on 16/6/10.
 */
public class PageResult<T> {

    private int page = 1;
    private int pageSize = 10;
    private int offset;
    private int total;
    private int pages;

    private List<T> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return (page-1) * pageSize;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return (int)Math.ceil(1.0 * total / pageSize);
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                ", total=" + total +
                ", pages=" + pages +
                ", data=" + data +
                '}';
    }
}
