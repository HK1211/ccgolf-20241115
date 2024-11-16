package com.ccgolf.sharedCodeService.exception;

import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 전역 예외 핸들러 클래스입니다.
 * 애플리케이션 전반에서 발생하는 예외를 일관된 형식으로 처리합니다.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * EntityNotFoundException 발생 시 처리합니다.
     *
     * @param ex 발생한 EntityNotFoundException
     * @return ApiResponse 형식의 응답 엔티티
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleEntityNotFoundException(EntityNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse<Void> response = ApiResponse.errorBasic(message);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * IllegalArgumentException 발생 시 처리합니다.
     *
     * @param ex 발생한 IllegalArgumentException
     * @return ApiResponse 형식의 응답 엔티티
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleIllegalArgumentException(IllegalArgumentException ex) {
        String message = ex.getMessage();
        ApiResponse<Void> response = ApiResponse.errorBasicWithCode(message, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 일반적인 예외 발생 시 처리합니다.
     *
     * @param ex 발생한 예외
     * @return ApiResponse 형식의 응답 엔티티
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneralException(Exception ex) {
        String message = DefaultConsts.MESSAGE_ERR;
        ApiResponse<Void> response = ApiResponse.errorBasic(message);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
