package com.we.fc.common;

import java.util.List;

/**
 * @author zdc
 * @since 2018-04-06 17:18
 */

public class DataTable<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public DataTable(List<T> data) {
        this.data = data;
    }
}
