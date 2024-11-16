package com.ccgolf.sharedCodeService.dto;

import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import com.ccgolf.sharedCodeService.dto.metadata.PaginationInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * API 응답을 표준화하기 위한 데이터 전송 객체(DTO) 클래스입니다.
 * 이 클래스는 페이징을 포함한 성공 및 실패 응답을 일관된 형식으로 제공하기 위해 사용됩니다.
 *
 * @param <T> 응답 데이터의 타입
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> extends BaseApiResponse<T> {

    /**
     * 페이징 정보를 포함하는 객체입니다.
     * 응답 데이터가 페이징된 경우 이 필드를 통해 페이지 인덱스, 페이지 크기, 전체 데이터 수 등을 제공합니다.
     */
    private PaginationInfo pagination;

    /**
     * 기본적으로 성공 응답을 생성하는 메서드입니다.
     * 데이터만을 포함하며, 상태 메시지는 비워둡니다.
     *
     * @param data 응답 데이터
     * @param <T>  응답 데이터의 타입
     * @return ApiResponse 객체
     */
    public static <T> ApiResponse<T> ok(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCommonFields(DefaultConsts.STATUS_200, "");
        response.setData(data);
        return response;
    }

    /**
     * 성공 응답을 생성하는 메서드입니다.
     * 데이터와 함께 커스텀 성공 메시지를 포함합니다.
     *
     * @param data    응답 데이터
     * @param message 성공 메시지
     * @param <T>     응답 데이터의 타입
     * @return ApiResponse 객체
     */
    public static <T> ApiResponse<T> ok(T data, String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCommonFields(DefaultConsts.STATUS_200, message);
        response.setData(data);
        return response;
    }

    /**
     * 성공 응답을 생성하는 메서드입니다.
     * 데이터와 상태 코드를 함께 설정할 수 있습니다.
     * 주로 커스텀 상태 코드가 필요한 경우 사용됩니다.
     *
     * @param data    응답 데이터
     * @param code    상태 코드
     * @param message 성공 메시지
     * @param <T>     응답 데이터의 타입
     * @return ApiResponse 객체
     */
    public static <T> ApiResponse<T> ok(T data, int code, String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCommonFields(code, message);
        response.setData(data);
        return response;
    }

    /**
     * 페이징 정보를 포함한 성공 응답을 생성하는 메서드입니다.
     *
     * @param data       응답 데이터
     * @param message    성공 메시지
     * @param pageIndex  현재 페이지 인덱스
     * @param pageSize   페이지 당 데이터 수
     * @param totalCount 전체 데이터 수
     * @param <T>        응답 데이터의 타입
     * @return 페이징 정보를 포함한 ApiResponse 객체
     */
    public static <T> ApiResponse<T> pagedBasic(T data, String message, int pageIndex, int pageSize, int totalCount) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCommonFields(DefaultConsts.STATUS_200, message);
        response.setData(data);
        response.setPagination(new PaginationInfo(pageIndex, pageSize, totalCount));
        return response;
    }

    /**
     * 기본적인 실패 응답을 생성하는 메서드입니다.
     * 상태 코드와 메시지를 설정하며, 데이터는 null로 설정됩니다.
     *
     * @param statusMsg 실패 메시지
     * @param <T>       응답 데이터의 타입
     * @return ApiResponse 객체
     */
    public static <T> ApiResponse<T> errorBasic(String statusMsg) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCommonFields(DefaultConsts.STATUS_500, statusMsg);
        response.setData(null);
        return response;
    }

    /**
     * 상태 코드와 메시지를 커스텀하여 실패 응답을 생성하는 메서드입니다.
     *
     * @param statusMsg 실패 메시지
     * @param code      상태 코드
     * @param <T>       응답 데이터의 타입
     * @return ApiResponse 객체
     */
    public static <T> ApiResponse<T> errorBasicWithCode(String statusMsg, int code) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCommonFields(code, statusMsg);
        response.setData(null);
        return response;
    }

    /**
     * 상태 제목과 메시지를 포함하여 실패 응답을 생성하는 메서드입니다.
     * 상태 제목은 주로 에러의 경우 "에러", "경고" 등과 같은 제목을 포함합니다.
     *
     * @param statusTitle 상태 제목 (예: "에러", "경고")
     * @param statusMsg    실패 메시지
     * @param <T>          응답 데이터의 타입
     * @return ApiResponse 객체
     */
    public static <T> ApiResponse<T> errorWithTitle(String statusTitle, String statusMsg) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCommonFields(DefaultConsts.STATUS_500, statusMsg);
        response.setData(null);
        response.setStatusTitle(statusTitle);
        return response;
    }

    /**
     * 상태 제목과 커스텀 상태 코드를 포함하여 실패 응답을 생성하는 메서드입니다.
     * 상태 제목은 주로 에러의 경우 "에러", "경고" 등과 같은 제목을 포함합니다.
     *
     * @param statusTitle 상태 제목 (예: "에러", "경고")
     * @param statusMsg    실패 메시지
     * @param statusCode   커스텀 상태 코드
     * @param <T>          응답 데이터의 타입
     * @return ApiResponse 객체
     */
    public static <T> ApiResponse<T> errorWithTitleAndCustomCode(String statusTitle, String statusMsg, int statusCode) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCommonFields(statusCode, statusMsg);
        response.setData(null);
        response.setStatusTitle(statusTitle);
        return response;
    }
}
