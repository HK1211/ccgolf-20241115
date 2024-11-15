package com.ccgolf.sharedCodeService.util;

/**
 * 메시지 유틸리티 클래스.
 * 다양한 메시지 포맷팅 기능을 제공합니다.
 */
public class MessageUtil {

    /**
     * 에러 메시지를 포맷팅합니다.
     *
     * @param title   에러 제목
     * @param field   필드명
     * @param value   필드 값
     * @return 포맷된 에러 메시지
     */
    public static String formatErrorMessage(String title, String field, Object value) {
        return String.format("%s: 필드 '%s'의 값이 유효하지 않습니다. 입력값: [%s]. ", title, field, value);
    }
}
