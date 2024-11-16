-- H2 용 스키마 생성 및 설정
CREATE SCHEMA IF NOT EXISTS SHARED_CODE;
SET SCHEMA SHARED_CODE;

-- 테이블 메타데이터
CREATE TABLE IF NOT EXISTS SHARED_CODE_TABLE_METADATA (
    SHARED_CODE_TABLE_METADATA_SEQ BIGINT PRIMARY KEY AUTO_INCREMENT,
    TABLE_NAME VARCHAR(50) NOT NULL,
    PRIORITY INT NOT NULL,
    COMMENT VARCHAR(50) NOT NULL,
    DESCRIPTION TEXT,

    IS_ACTIVE BOOLEAN NOT NULL,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CREATE_USER_ID VARCHAR(50),
    CREATE_USER_NAME VARCHAR(50),
    CREATE_IP VARCHAR(15),
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATE_USER_ID VARCHAR(50),
    UPDATE_USER_NAME VARCHAR(50),
    UPDATE_IP VARCHAR(15),
    VERSION BIGINT DEFAULT 0 NOT NULL
);

-- 통합 시퀀스(채번) 관리 테이블 생성
CREATE TABLE IF NOT EXISTS SHARED_CODE_SEQ_MANAGEMENT (
    SHARED_CODE_SEQ_MANAGEMENT_SEQ BIGINT PRIMARY KEY AUTO_INCREMENT,

    TABLE_NAME VARCHAR(50) NOT NULL,
    COLUMN_NAME VARCHAR(50) NOT NULL,
    SEQUENCE_NUMBER BIGINT NOT NULL,

    IS_USE BOOLEAN NOT NULL,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CREATE_USER_ID VARCHAR(50),
    CREATE_USER_NAME VARCHAR(50),
    CREATE_IP VARCHAR(15),
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATE_USER_ID VARCHAR(50),
    UPDATE_USER_NAME VARCHAR(50),
    UPDATE_IP VARCHAR(15),
    VERSION BIGINT DEFAULT 0 NOT NULL,

    UNIQUE (TABLE_NAME, COLUMN_NAME, SEQUENCE_NUMBER)
);

-- 통합 코드 관리 테이블 생성
-- 시스템코드, 업무구분코드(계층형), 프로그램코드, 메뉴코드, 권한그룹코드, 권한코드, 공통코드그룹, 공통코드
CREATE TABLE IF NOT EXISTS SHARED_CODE_MANAGEMENT (
    SHARED_CODE_MANAGEMENT_SEQ BIGINT PRIMARY KEY AUTO_INCREMENT,   -- 고유 식별자 (자동 증가)

    SYSTEM_CODE VARCHAR(30) NOT NULL,                               -- 시스템 식별자 (예: 'IMS', 'TRAVEL')
    CODE_TYPE VARCHAR(30) NOT NULL,                                 -- 코드 유형 (예: 'SYSTEM_CODE', 'BUSINESS_DIVISION', 'DETAIL_DIVISION')
    PARENT_CODE VARCHAR(30),                                        -- 상위 코드 (계층 구조 표현, 예: 'ADMIN', 'SALES')
    CODE VARCHAR(30) NOT NULL,                                      -- 코드 값 (업무 구분 코드 또는 상세 코드, 예: 'BASE_CODE')
    NAME VARCHAR(30) NOT NULL,                                      -- 코드 이름 (예: '기본코드관리', '거래처관리')
    DESCRIPTION VARCHAR(255),                                       -- 코드 설명 (코드의 의미나 용도 설명)

    SORT_ORDER INT,                                                 -- 정렬 순서 (코드 목록 표시 시 정렬 기준)
    START_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                 -- 유효 시작일 (코드의 유효 기간 시작일)
    END_DATE TIMESTAMP,                                             -- 유효 종료일 (코드의 유효 기간 종료일)

    IS_ACTIVE BOOLEAN NOT NULL,                                     -- 활성화 여부 (TRUE: 활성, FALSE: 비활성)
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                 -- 생성 일시
    CREATE_USER_ID VARCHAR(50),                                     -- 생성자 ID
    CREATE_USER_NAME VARCHAR(50),                                   -- 생성자 이름
    CREATE_IP VARCHAR(15),                                          -- 생성자 IP 주소

    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                 -- 수정 일시
    UPDATE_USER_ID VARCHAR(50),                                     -- 수정자 ID
    UPDATE_USER_NAME VARCHAR(50),                                   -- 수정자 이름
    UPDATE_IP VARCHAR(15),                                          -- 수정자 IP 주소

    VERSION BIGINT DEFAULT 0 NOT NULL,                              -- 버전 (데이터 변경 시 버전 관리 용도)

    UNIQUE (CODE_TYPE, CODE)                                        -- 코드 유형과 코드 값의 유일성 보장                                    -- 이름 인덱스
);

-- 통합 코드 속성 관리 테이블 생성
CREATE TABLE IF NOT EXISTS SHARED_CODE_DETAIL_ATTRIBUTE_MANAGEMENT (
    SHARED_CODE_DETAIL_ATTRIBUTE_MANAGEMENT_SEQ BIGINT PRIMARY KEY AUTO_INCREMENT,
    SYSTEM_CODE VARCHAR(30) NOT NULL,                        -- 시스템 코드 (예: 'IMS', 'TRAVEL')
    CODE_TYPE VARCHAR(30) NOT NULL,                          -- 코드 유형 (예: 'BUSINESS_DIVISION', 'DETAIL_DIVISION')
    CODE VARCHAR(30) NOT NULL,                               -- 코드 값 (예: 'BASE_CODE', 'ACCOUNT')

    ATTRIBUTE_CODE VARCHAR(30) NOT NULL,                     -- 속성 코드 (예: 'COLOR', 'DISPLAY_ORDER')
    ATTRIBUTE_NAME VARCHAR(30) NOT NULL,                     -- 속성 이름 (예: '색상', '정렬 순서')
    ATTRIBUTE_DESCRIPTION VARCHAR(255),                      -- 속성 설명 (속성의 의미나 용도)
    START_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,          -- 유효 시작일 (기본값: 현재 시점)
    END_DATE TIMESTAMP,                                      -- 유효 종료일

    IS_ACTIVE BOOLEAN NOT NULL,                              -- 활성화 여부 (TRUE: 활성, FALSE: 비활성)
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,          -- 생성 일시
    CREATE_USER_ID VARCHAR(50),                              -- 생성자 ID
    CREATE_USER_NAME VARCHAR(50),                            -- 생성자 이름
    CREATE_IP VARCHAR(15),                                   -- 생성자 IP 주소

    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,          -- 수정 일시
    UPDATE_USER_ID VARCHAR(50),                              -- 수정자 ID
    UPDATE_USER_NAME VARCHAR(50),                            -- 수정자 이름
    UPDATE_IP VARCHAR(15),                                   -- 수정자 IP 주소

    VERSION BIGINT DEFAULT 0 NOT NULL,                       -- 버전 관리

    UNIQUE (SYSTEM_CODE, CODE_TYPE, CODE, ATTRIBUTE_CODE)    -- 시스템별, 코드 유형별, 코드별 속성의 유일성 보장
);

-- 프로그램 상세 정보 테이블 생성
CREATE TABLE IF NOT EXISTS SHARED_CODE_PROGRAM_DETAILS (
    PROGRAM_DETAILS_SEQ BIGINT PRIMARY KEY AUTO_INCREMENT,                -- 고유 식별자 (자동 증가)

    SYSTEM_CODE VARCHAR(30) NOT NULL,                                     -- 시스템 코드 (예: 'IMS', 'TRAVEL')
    PROGRAM_CODE VARCHAR(30) NOT NULL,                                    -- 프로그램 코드 (SHARED_CODE_MANAGEMENT의 CODE와 연결)

    PROGRAM_TYPE_CODE VARCHAR(30),                                        -- 프로그램 유형 코드 (예: 'WEB', 'BATCH', 'API')
    PROGRAM_PATH VARCHAR(255) NOT NULL,                                   -- 프로그램 경로 (예: '/user/manage')
    PROGRAM_PARAMETER VARCHAR(255),                                       -- 프로그램 실행 시 필요한 파라미터 (예: 'param1=value1')
    PROGRAM_DESCRIPTION VARCHAR(255),                                     -- 프로그램 상세 설명
    PROGRAM_SORT_ORDER INT,                                               -- 프로그램 정렬 순서 (목록 표시 시 우선순위)
    PROGRAM_USE_START_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,           -- 프로그램 사용 시작일 (기본값: 현재 시점)
    PROGRAM_USE_END_DATE TIMESTAMP,                                       -- 프로그램 사용 종료일

    IS_ACTIVE BOOLEAN DEFAULT TRUE NOT NULL,                              -- 활성화 여부 (TRUE: 활성, FALSE: 비활성)
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                       -- 생성 일시
    CREATE_USER_ID VARCHAR(50),                                           -- 생성자 ID
    CREATE_USER_NAME VARCHAR(50),                                         -- 생성자 이름
    CREATE_IP VARCHAR(15),                                                -- 생성자 IP 주소

    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정 일시 (자동 갱신)
    UPDATE_USER_ID VARCHAR(50),                                           -- 수정자 ID
    UPDATE_USER_NAME VARCHAR(50),                                         -- 수정자 이름
    UPDATE_IP VARCHAR(15),                                                -- 수정자 IP 주소

    VERSION BIGINT DEFAULT 0 NOT NULL,                                    -- 버전 관리 (데이터 변경 시 버전 증가)

    -- 제약 조건 및 인덱스 정의
    UNIQUE (SYSTEM_CODE, PROGRAM_CODE)                                    -- 시스템별 프로그램 코드의 유일성 보장
);

-- 메뉴 상세 정보 테이블 생성
CREATE TABLE IF NOT EXISTS SHARED_CODE_MENU_DETAILS (
    MENU_DETAILS_SEQ BIGINT PRIMARY KEY AUTO_INCREMENT,               -- 고유 식별자 (자동 증가)

    SYSTEM_CODE VARCHAR(30) NOT NULL,                                 -- 시스템 코드 (예: 'IMS', 'TRAVEL')
    MENU_CODE VARCHAR(30) NOT NULL,                                   -- 메뉴 코드 (SHARED_CODE_MANAGEMENT의 CODE와 연결)
    UPPER_MENU_CODE VARCHAR(30),                                      -- 상위 메뉴 코드 (계층 구조 표현)
    MENU_LEVEL INT DEFAULT 0,                                         -- 메뉴 레벨 (0: 최상위 메뉴)
    PROGRAM_SEQ BIGINT,                                               -- 프로그램 SEQ (SHARED_CODE_PROGRAM_DETAILS의 PRIMARY KEY 논리적 참조)

    MENU_TYPE_CODE VARCHAR(30),                                       -- 메뉴 유형 코드 (예: 'LINK', 'BUTTON')
    MENU_TYPE_NAME VARCHAR(30),                                       -- 메뉴 유형 이름
    MENU_PATH VARCHAR(255),                                           -- 메뉴 경로 (예: '/user/menu')
    MENU_PARAMETER VARCHAR(255),                                      -- 메뉴 파라미터 (예: 'userId=123')
    MULTI_OPEN_STATUS BOOLEAN DEFAULT FALSE,                          -- 다중 열림 허용 여부 (TRUE: 허용)
    HELP_PAGE_LINK VARCHAR(255),                                      -- 도움말 페이지 링크
    MENU_DESCRIPTION VARCHAR(255),                                    -- 메뉴 상세 설명
    MENU_SORT_ORDER INT,                                              -- 메뉴 정렬 순서
    MENU_USE_START_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,          -- 메뉴 사용 시작일
    MENU_USE_END_DATE TIMESTAMP,                                      -- 메뉴 사용 종료일

    IS_ACTIVE BOOLEAN DEFAULT TRUE NOT NULL,                          -- 활성화 여부
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                   -- 생성 일시
    CREATE_USER_ID VARCHAR(50),                                       -- 생성자 ID
    CREATE_USER_NAME VARCHAR(50),                                     -- 생성자 이름
    CREATE_IP VARCHAR(15),                                            -- 생성자 IP 주소

    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정 일시
    UPDATE_USER_ID VARCHAR(50),                                       -- 수정자 ID
    UPDATE_USER_NAME VARCHAR(50),                                     -- 수정자 이름
    UPDATE_IP VARCHAR(15),                                            -- 수정자 IP 주소

    VERSION BIGINT DEFAULT 0 NOT NULL,                                -- 버전 관리

    -- 제약 조건 및 인덱스 정의
    UNIQUE (SYSTEM_CODE, MENU_CODE)                                   -- 시스템별 메뉴 코드의 유일성 보장
);

-- 권한 그룹과 권한의 관계 테이블
CREATE TABLE IF NOT EXISTS SHARED_CODE_PERMISSION_GROUP_RELATION (
    PERMISSION_GROUP_RELATION_SEQ BIGINT PRIMARY KEY AUTO_INCREMENT,
    SYSTEM_CODE VARCHAR(30) NOT NULL,                 -- 시스템 코드 (예: 'IMS')
    PERMISSION_GROUP_CODE VARCHAR(30) NOT NULL,       -- 권한 그룹 코드 (논리적 참조)
    PERMISSION_CODE VARCHAR(30) NOT NULL,             -- 권한 코드 (논리적 참조)

    IS_ACTIVE BOOLEAN DEFAULT TRUE NOT NULL,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CREATE_USER_ID VARCHAR(50),
    CREATE_USER_NAME VARCHAR(50),
    CREATE_IP VARCHAR(15),

    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATE_USER_ID VARCHAR(50),
    UPDATE_USER_NAME VARCHAR(50),
    UPDATE_IP VARCHAR(15),

    VERSION BIGINT DEFAULT 0 NOT NULL,
    UNIQUE (SYSTEM_CODE, PERMISSION_GROUP_CODE, PERMISSION_CODE)
);

-- 권한 그룹과 사용자 관계 테이블
CREATE TABLE IF NOT EXISTS SHARED_CODE_PERMISSION_GROUP_USER_RELATION (
    PERMISSION_GROUP_USER_RELATION_SEQ BIGINT PRIMARY KEY AUTO_INCREMENT,
    SYSTEM_CODE VARCHAR(30) NOT NULL,                 -- 시스템 코드 (예: 'IMS')
    PERMISSION_GROUP_CODE VARCHAR(30) NOT NULL,       -- 권한 그룹 코드 (논리적 참조)
    LOGIN_ID VARCHAR(30) NOT NULL,                    -- 사용자 ID

    IS_ACTIVE BOOLEAN DEFAULT TRUE NOT NULL,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CREATE_USER_ID VARCHAR(50),
    CREATE_USER_NAME VARCHAR(50),
    CREATE_IP VARCHAR(15),

    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATE_USER_ID VARCHAR(50),
    UPDATE_USER_NAME VARCHAR(50),
    UPDATE_IP VARCHAR(15),

    VERSION BIGINT DEFAULT 0 NOT NULL,
    UNIQUE (SYSTEM_CODE, PERMISSION_GROUP_CODE, LOGIN_ID)
);

-- 별도의 인덱스 생성
-- SHARED_CODE_MANAGEMENT 테이블 인덱스
CREATE INDEX IF NOT EXISTS IDX_SYSTEM_CODE_TYPE ON SHARED_CODE_MANAGEMENT (SYSTEM_CODE, CODE_TYPE);
CREATE INDEX IF NOT EXISTS IDX_PARENT_CODE ON SHARED_CODE_MANAGEMENT (PARENT_CODE);
CREATE INDEX IF NOT EXISTS IDX_ACTIVE_PERIOD ON SHARED_CODE_MANAGEMENT (IS_ACTIVE, START_DATE, END_DATE);
CREATE INDEX IF NOT EXISTS IDX_NAME ON SHARED_CODE_MANAGEMENT (NAME);

-- 다른 테이블에 필요한 인덱스도 동일한 방식으로 별도 생성
-- 예: SHARED_CODE_DETAIL_ATTRIBUTE_MANAGEMENT 테이블 인덱스
CREATE INDEX IF NOT EXISTS IDX_SYSTEM_CODE_TYPE_DETAIL ON SHARED_CODE_DETAIL_ATTRIBUTE_MANAGEMENT (SYSTEM_CODE, CODE_TYPE);
CREATE INDEX IF NOT EXISTS IDX_CODE_ATTRIBUTE ON SHARED_CODE_DETAIL_ATTRIBUTE_MANAGEMENT (CODE, ATTRIBUTE_CODE);
CREATE INDEX IF NOT EXISTS IDX_ACTIVE_PERIOD_DETAIL ON SHARED_CODE_DETAIL_ATTRIBUTE_MANAGEMENT (IS_ACTIVE, START_DATE, END_DATE);

-- SHARED_CODE_PROGRAM_DETAILS 테이블 인덱스
CREATE INDEX IF NOT EXISTS IDX_PROGRAM_PATH ON SHARED_CODE_PROGRAM_DETAILS (PROGRAM_PATH);
CREATE INDEX IF NOT EXISTS IDX_PROGRAM_TYPE_CODE ON SHARED_CODE_PROGRAM_DETAILS (PROGRAM_TYPE_CODE);
CREATE INDEX IF NOT EXISTS IDX_PROGRAM_ACTIVE_PERIOD ON SHARED_CODE_PROGRAM_DETAILS (IS_ACTIVE, PROGRAM_USE_START_DATE, PROGRAM_USE_END_DATE);

-- SHARED_CODE_MENU_DETAILS 테이블 인덱스
CREATE INDEX IF NOT EXISTS IDX_MENU_PATH ON SHARED_CODE_MENU_DETAILS (MENU_PATH);
CREATE INDEX IF NOT EXISTS IDX_UPPER_MENU_CODE ON SHARED_CODE_MENU_DETAILS (UPPER_MENU_CODE);
CREATE INDEX IF NOT EXISTS IDX_PROGRAM_SEQ ON SHARED_CODE_MENU_DETAILS (PROGRAM_SEQ);
CREATE INDEX IF NOT EXISTS IDX_ACTIVE_PERIOD_MENU ON SHARED_CODE_MENU_DETAILS (IS_ACTIVE, MENU_USE_START_DATE, MENU_USE_END_DATE);

