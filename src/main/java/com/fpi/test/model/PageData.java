package com.fpi.test.model;

import com.google.common.collect.Lists;

import java.util.List;

public class PageData<T> {

    private List<T> entries = Lists.newArrayList();

    private Integer total = 0;

    public PageData(List<T> entries, Integer total) {
        this.entries = entries;
        this.total = total;
    }

    public List<T> getEntries() {
        return entries;
    }

    public void setEntries(List<T> entries) {
        this.entries = entries;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageData{" +
                "entries=" + entries +
                ", total=" + total +
                '}';
    }
}
