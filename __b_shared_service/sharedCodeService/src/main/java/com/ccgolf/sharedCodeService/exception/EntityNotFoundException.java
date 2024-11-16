package com.ccgolf.sharedCodeService.exception;

/**
 * 엔티티를 찾을 수 없을 때 발생시키는 사용자 정의 예외 클래스입니다.
 */
public class EntityNotFoundException extends RuntimeException {
    /**
     * 예외 메시지를 지정하여 인스턴스를 생성합니다.
     *
     * @param message 예외 메시지
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}
