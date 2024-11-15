package com.ccgolf.sharedCodeService.exception;

import com.ccgolf.sharedCodeService.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

/**
 * 글로벌 예외 처리 클래스입니다.
 * 애플리케이션 전반에서 발생하는 예외를 중앙에서 처리하여 일관된 API 응답을 제공합니다.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * EntityNotFoundException을 처리하는 메서드입니다.
     *
     * @param ex 발생한 EntityNotFoundException
     * @return ApiResponse를 포함한 ResponseEntity
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleEntityNotFoundException(EntityNotFoundException ex) {
        ApiResponse<Void> response = ApiResponse.errorBasic(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 추가적인 예외 처리 메서드를 여기에 정의할 수 있습니다.
}
