package com.aiquizgenerator.backend.common.pagination.factories;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.aiquizgenerator.backend.common.pagination.PaginationResponseDto;

@Component
public class PaginationFactory {
    

    public <T> PaginationResponseDto<T> createPaginationResponse(Page<T> page) {
        return new PaginationResponseDto<>(
            page.getNumber(),
            page.getTotalPages(),
            page.getSize(),
            page.getContent(),
            page.isLast()
        );
    }
}
