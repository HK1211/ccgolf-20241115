package com.ccgolf.sharedCodeService.dto;

import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import lombok.Data;

/**
 * API 응답의 기본 구조를 정의하는 추상 클래스입니다.
 * 모든 API 응답은 이 클래스를 상속받아 사용됩니다.
 *
 * @param <T> 응답 데이터의 타입
 */
@Data
public abstract class BaseApiResponse<T> {

    private T data;

    /**
     * HTTP 상태 코드를 나타냅니다.
     * 예: 200 (성공), 404 (찾을 수 없음), 500 (서버 오류) 등.
     */
    private int statusCode;

    /**
     * 상태 메시지를 나타냅니다.
     * 성공 시 "성공적으로 조회되었습니다."와 같은 메시지, 실패 시 에러 메시지를 포함합니다.
     */
    private String statusMsg;

    /**
     * 상태 제목을 나타냅니다.
     * 주로 에러의 경우 "에러", "경고" 등과 같은 제목을 포함합니다.
     */
    private String statusTitle;

    /**
     * 기본적으로 성공 응답을 설정하는 메서드입니다.
     *
     * @param statusCode HTTP 상태 코드
     * @param statusMsg  상태 메시지
     */
    protected void setCommonFields(int statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.statusTitle = "";
    }

    /**
     * 상태 제목을 설정하는 메서드입니다.
     *
     * @param statusTitle 상태 제목
     */
    protected void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }
}
