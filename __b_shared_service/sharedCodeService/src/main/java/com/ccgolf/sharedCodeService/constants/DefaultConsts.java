package com.ccgolf.sharedCodeService.constants;

import org.springframework.http.HttpStatus;

public class DefaultConsts {

    private DefaultConsts() {
        // restrict instantiation
    }

    public static final int STATUS_200 = HttpStatus.OK.value();
    public static final String MESSAGE_200 = "요청이 성공적으로 처리되었습니다.";

    public static final int STATUS_201 = HttpStatus.CREATED.value();
    public static final String MESSAGE_201 = "성공적으로 생성되었습니다\n";

    public static final int ERR_CODE = HttpStatus.INTERNAL_SERVER_ERROR.value();
    public static final String MESSAGE_ERR = "오류가 발생했습니다. 다시 시도하거나 개발팀에 문의하세요.";

    public static final int STATUS_500 = HttpStatus.INTERNAL_SERVER_ERROR.value();
    public static final String MESSAGE_500 = "오류가 발생했습니다. 다시 시도하거나 개발팀에 문의하세요.";
}
