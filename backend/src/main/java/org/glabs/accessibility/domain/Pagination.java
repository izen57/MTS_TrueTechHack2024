package org.glabs.accessibility.domain;

public class Pagination {
    private final int maxPageSize;
    private final int pageNumber;
    private int pageSize;

    public Pagination() {
        maxPageSize = 50;
        pageSize = 10;
        pageNumber = 1;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int size) {
        pageSize = size > maxPageSize ? maxPageSize : size;
    }
}
