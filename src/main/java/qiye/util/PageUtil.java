package qiye.util;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by THINKPAD on 2017/9/17.
 */
public class PageUtil<T> {
    private Long total;
    private List<T> rows;


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageUtil(PageInfo pageInfo) {
        this.total=pageInfo.getTotal();
        this.rows = pageInfo.getList();
    }

    public PageUtil(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageUtil() {
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
