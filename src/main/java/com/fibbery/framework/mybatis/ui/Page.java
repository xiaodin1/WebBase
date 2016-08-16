package com.fibbery.framework.mybatis.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对分页的基本数据进行一个简单的封装
 */
public class Page<T> {

    private int page = 1;//页码，默认是第一页
    private int pageSize = 20;//每页显示的记录数，默认是15
    private int records;//总记录数
    private int total;//总页数
    private List<T> rows;//对应的当前页记录
    private Map<String, Object> params = new HashMap<String, Object>();//其他的参数我们把它分装成一个Map对象

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

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
        //在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
        int totalPage = records %pageSize==0 ? records /pageSize : records /pageSize + 1;
        this.setTotal(totalPage);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Page [page=").append(page).append(", pageSize=")
                .append(pageSize).append(", rows=").append(rows).append(
                ", total=").append(total).append(
                ", records=").append(records).append("]");
        return builder.toString();
    }

}