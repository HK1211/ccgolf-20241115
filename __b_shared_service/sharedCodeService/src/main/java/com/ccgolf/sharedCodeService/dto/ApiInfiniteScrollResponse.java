package com.ccgolf.sharedCodeService.dto;

import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import com.ccgolf.sharedCodeService.dto.metadata.InfiniteScrollInfo;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 무한 스크롤을 위한 API 응답을 표준화하기 위한 데이터 전송 객체(DTO) 클래스입니다.
 * 이 클래스는 데이터 목록과 함께 무한 스크롤 관련 정보를 포함합니다.
 *
 * @param <T> 응답 데이터의 타입
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiInfiniteScrollResponse<T> extends BaseApiResponse<List<T>> {

    /**
     * 무한 스크롤 관련 정보를 포함하는 객체입니다.
     * 추가 데이터를 로드할 수 있는지 여부와 다음 데이터를 요청하기 위한 커서 또는 토큰을 제공합니다.
     */
    private InfiniteScrollInfo scrollInfo;

    /**
     * 성공 응답을 생성하는 메서드입니다.
     * 데이터 목록과 무한 스크롤 정보를 포함합니다.
     *
     * @param data       응답 데이터 목록
     * @param hasMore    추가 데이터가 있는지 여부
     * @param nextCursor 다음 데이터를 요청하기 위한 커서 또는 토큰
     * @param <T>        응답 데이터의 타입
     * @return ApiInfiniteScrollResponse 객체
     */
    public static <T> ApiInfiniteScrollResponse<T> ok(List<T> data, boolean hasMore, String nextCursor) {
        ApiInfiniteScrollResponse<T> response = new ApiInfiniteScrollResponse<>();
        response.setCommonFields(DefaultConsts.STATUS_200, MessageUtil.formatSuccessMessage("조회"));
        response.setData(data);
        response.setScrollInfo(new InfiniteScrollInfo(hasMore, nextCursor));
        return response;
    }

    /**
     * 실패 응답을 생성하는 메서드입니다.
     *
     * @param statusTitle 상태 제목 (예: "에러", "경고")
     * @param statusMsg    실패 메시지
     * @param statusCode   커스텀 상태 코드
     * @param <T>          응답 데이터의 타입
     * @return ApiInfiniteScrollResponse 객체
     */
    public static <T> ApiInfiniteScrollResponse<T> error(String statusTitle, String statusMsg, int statusCode) {
        ApiInfiniteScrollResponse<T> response = new ApiInfiniteScrollResponse<>();
        response.setCommonFields(statusCode, statusMsg);
        response.setData(null);
        response.setStatusTitle(statusTitle);
        response.setScrollInfo(new InfiniteScrollInfo(false, null));
        return response;
    }
}
