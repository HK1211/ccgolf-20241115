package com.ccgolf.sharedCodeService.dto;

import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data @AllArgsConstructor @NoArgsConstructor
public class ApiResponse<T> {
    private T data;

    private int statusCode;

    private String statusMsg;

    private String statusTitle;

    private ApiPagination pagination;

    // 성공 응답 생성 메서드
    public static <T> ApiResponse<T> ok(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.data = data;
        response.statusCode = DefaultConsts.OK_CODE;
        response.statusMsg = "";
        return response;
    }

    // 성공 응답 생성 메서드
    public static <T> ApiResponse<T> ok(T data, String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.data = data;
        response.statusCode = DefaultConsts.OK_CODE;
        response.statusMsg = message;
        return response;
    }

    // 성공 응답 생성 메서드
    public static <T> ApiResponse<T> ok(T data, int code, String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.data = data;
        response.statusCode = DefaultConsts.OK_CODE;
        response.statusMsg = message;
        return response;
    }

    // 실패 응답 생성 메서드
    public static <T> ApiResponse<T> errorBasic(String statusMsg) {
        ApiResponse<T> response = new ApiResponse<>();
        response.statusCode = DefaultConsts.ERR_CODE;
        response.statusMsg = statusMsg;
        return response;
    }

    // 실패 응답 생성 메서드
    public static <T> ApiResponse<T> errorBasicWithCode(String statusMsg, int code) {
        ApiResponse<T> response = new ApiResponse<>();
        response.statusCode = DefaultConsts.ERR_CODE;
        response.statusMsg = statusMsg;
        return response;
    }

    // 실패 응답 생성 메서드
    public static <T> ApiResponse<T> errorWithTitle(String statusTitle, String statusMsg) {
        ApiResponse<T> response = new ApiResponse<>();
        response.statusCode = DefaultConsts.ERR_CODE;
        response.statusMsg = statusMsg;
        response.statusTitle = statusTitle;
        return response;
    }

    // 실패 응답 생성 메서드
    public static <T> ApiResponse<T> errorWithTitleAndCustomCode(String statusTitle, String statusMsg, int statusCode) {
        ApiResponse<T> response = new ApiResponse<>();
        response.statusCode = statusCode;
        response.statusMsg = statusMsg;
        response.statusTitle = statusTitle;
        return response;
    }

    // 페이징 응답 생성 메서드
    public static <T> ApiResponse<T> pagedBasic(T data, String message, int pageIndex, int pageSize, int totalCount) {
        ApiResponse<T> response = new ApiResponse<>();
        ApiPagination pagination = new ApiPagination(pageIndex, pageSize, totalCount);
        response.data = data;
        response.statusCode = DefaultConsts.OK_CODE;
        response.statusMsg = message;
        response.pagination = pagination;
        return response;
    }
}
