package com.aiquizgenerator.backend.common.pagination;

import java.time.OffsetDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaginationDto {
    @NotNull
    @Min(value = 1)
    private int page;

    @NotNull
    @Max(value = 100)
    private int size;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime timestamp;
}
