package com.ccgolf.sharedCodeService.dto.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 무한 스크롤과 관련된 정보를 담는 클래스입니다.
 * 이 클래스는 추가 데이터를 로드할 수 있는지 여부와 다음 데이터를 요청하기 위한 커서 또는 토큰을 포함합니다.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfiniteScrollInfo {

    /**
     * 추가 데이터를 요청할 수 있는지를 나타내는 플래그입니다.
     * 더 많은 데이터가 있으면 true, 없으면 false를 설정합니다.
     */
    private boolean hasMore;

    /**
     * 다음 데이터를 요청하기 위한 커서 또는 토큰입니다.
     * 클라이언트는 이 값을 사용하여 다음 데이터 세트를 요청할 수 있습니다.
     */
    private String nextCursor;
}
