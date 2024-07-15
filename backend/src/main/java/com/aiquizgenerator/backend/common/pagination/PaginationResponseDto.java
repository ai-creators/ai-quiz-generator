package com.aiquizgenerator.backend.common.pagination;

import java.util.List;

import lombok.Getter;

@Getter
public class PaginationResponseDto<T> {
    private int page;
    private int totalPages;
    private int size;
    private boolean isLast;
    private List<T> results;

    public PaginationResponseDto(int page, int totalPages, int size, List<T> results, boolean isLast) {
        this.page = page;
        this.totalPages = totalPages;
        this.size = size;
        this.results = results;
        this.isLast = isLast;
    }
}
