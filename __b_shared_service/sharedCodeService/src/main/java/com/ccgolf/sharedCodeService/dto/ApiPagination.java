package com.ccgolf.sharedCodeService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiPagination {
    private int pageIndex;
    private int pageSize;
    private long totalRecords;
}
