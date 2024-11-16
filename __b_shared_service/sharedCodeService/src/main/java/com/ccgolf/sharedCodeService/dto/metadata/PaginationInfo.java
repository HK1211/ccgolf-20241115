package com.ccgolf.sharedCodeService.dto.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 페이징 정보를 담는 클래스입니다.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationInfo {
    /**
     * 현재 페이지 인덱스입니다.
     */
    private int pageIndex;

    /**
     * 페이지 당 데이터 수입니다.
     */
    private int pageSize;

    /**
     * 전체 데이터 수입니다.
     */
    private int totalCount;
}
