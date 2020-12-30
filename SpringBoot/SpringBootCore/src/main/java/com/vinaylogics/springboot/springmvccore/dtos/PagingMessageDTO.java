package com.vinaylogics.springboot.springmvccore.dtos;

import java.io.Serializable;
import java.util.Objects;

public class PagingMessageDTO<T> implements Serializable {
    private Integer pageSize;
    private Integer pageNumber;
    private Long pagingCount;
    private T data;

    public PagingMessageDTO(Integer pageSize, Integer pageNumber, Long pagingCount, T data) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.pagingCount = pagingCount;
        this.data = data;
    }

    public PagingMessageDTO() {
    }

    public Long getPagingCount() {
        return pagingCount;
    }

    public void setPagingCount(Long pagingCount) {
        this.pagingCount = pagingCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagingMessageDTO<?> that = (PagingMessageDTO<?>) o;
        return Objects.equals(pagingCount, that.pagingCount) && Objects.equals(pageSize, that.pageSize) && Objects.equals(pageNumber, that.pageNumber) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagingCount, pageSize, pageNumber, data);
    }

    @Override
    public String toString() {
        return "PagingMessageDTO{" +
                "pagingCount=" + pagingCount +
                ", pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", data=" + data +
                '}';
    }
}
