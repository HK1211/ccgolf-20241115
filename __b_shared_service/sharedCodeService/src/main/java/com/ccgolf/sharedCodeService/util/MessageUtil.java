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
    public static String formatErrMsg(String title, String field, Object value) {
        return String.format("%s: 필드 '%s'의 값이 유효하지 않습니다. 입력값: [%s]. ", title, field, value);
    }

    /**
     * 성공 메시지를 포맷팅합니다.
     * 예: "성공적으로 등록되었습니다.", "성공적으로 삭제되었습니다." 등.
     *
     * @param action 동작 설명 (등록, 삭제 등)
     * @return 포맷된 성공 메시지
     */
    public static String formatSuccessMessage(String action) {
        return String.format("성공적으로 %s되었습니다.", action);
    }

}
