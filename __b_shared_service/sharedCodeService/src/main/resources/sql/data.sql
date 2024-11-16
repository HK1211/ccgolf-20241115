
-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
-- SHARED_CODE_TABLE_METADATA에 테이블 목록 삽입 (Bulk Insert)
-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★

INSERT INTO SHARED_CODE_TABLE_METADATA (
    TABLE_NAME, PRIORITY, COMMENT, DESCRIPTION, IS_ACTIVE, CREATED_AT,
    CREATE_USER_ID, CREATE_USER_NAME, CREATE_IP, UPDATED_AT,
    UPDATE_USER_ID, UPDATE_USER_NAME, UPDATE_IP, VERSION
) VALUES
      -- 통합 시퀀스 관리 테이블
      ('SHARED_CODE_SEQ_MANAGEMENT', 1, '통합 시퀀스 관리 테이블',
       '각 테이블의 고유한 시퀀스 번호를 관리하고, 자동 채번을 통해 일관된 순서를 보장합니다.\n이 테이블의 값을 사용하면 데이터 조회 시 순서와 무결성을 유지할 수 있습니다.',
       TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', CURRENT_TIMESTAMP, NULL, NULL, NULL, 1),

      -- 통합 코드 관리 테이블
      ('SHARED_CODE_MANAGEMENT', 2, '통합 코드 관리 테이블',
       '코드 유형과 코드 값을 관리하며, 다양한 시스템에서 참조할 수 있는 공통 코드 테이블입니다.',
       TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', CURRENT_TIMESTAMP, NULL, NULL, NULL, 1),

      -- 코드 상세 속성 관리 테이블
      ('SHARED_CODE_DETAIL_ATTRIBUTE_MANAGEMENT', 3, '코드 상세 속성 관리 테이블',
       '코드의 추가 속성 정보를 관리하여, 코드의 상세한 특성을 정의할 수 있습니다.',
       TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', CURRENT_TIMESTAMP, NULL, NULL, NULL, 1),

      -- 프로그램 상세 정보 테이블
      ('SHARED_CODE_PROGRAM_DETAILS', 4, '프로그램 상세 정보 테이블',
       '프로그램의 상세 정보를 관리하며, 시스템의 프로그램 목록을 정의합니다.',
       TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', CURRENT_TIMESTAMP, NULL, NULL, NULL, 1),

      -- 메뉴 상세 정보 테이블
      ('SHARED_CODE_MENU_DETAILS', 5, '메뉴 상세 정보 테이블',
       '메뉴의 상세 정보를 관리하며, 시스템 내의 메뉴 트리를 정의합니다.',
       TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', CURRENT_TIMESTAMP, NULL, NULL, NULL, 1),

      -- 권한 그룹 관계 테이블
      ('SHARED_CODE_PERMISSION_GROUP_RELATION', 6, '권한 그룹 관계 테이블',
       '권한 그룹과 권한의 매핑 관계를 정의하여, 그룹별 권한을 설정할 수 있습니다.',
       TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', CURRENT_TIMESTAMP, NULL, NULL, NULL, 1),

      -- 사용자 권한 관계 테이블
      ('SHARED_CODE_PERMISSION_GROUP_USER_RELATION', 7, '사용자 권한 관계 테이블',
       '사용자와 권한 그룹 간의 관계를 정의하여, 특정 사용자가 속한 권한 그룹을 관리합니다.',
       TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', CURRENT_TIMESTAMP, NULL, NULL, NULL, 1);


-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
-- SHARED_CODE_MANAGEMENT에 테이블 목록 삽입 (Bulk Insert)
-- CODE_TYPE: 시스템코드, 업무구분코드(계층형), 프로그램코드, 메뉴코드, 권한그룹코드, 권한코드, 공통코드그룹, 공통코드
-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★

-- ----------------------------------------------------
-- 시스템 코드 등록 (SYSTEM_CODE)
-- ----------------------------------------------------
-- 시스템 코드 등록
INSERT INTO SHARED_CODE_MANAGEMENT (SYSTEM_CODE, CODE_TYPE, PARENT_CODE, CODE, NAME, DESCRIPTION, IS_ACTIVE, CREATED_AT, CREATE_USER_ID, CREATE_USER_NAME, CREATE_IP, VERSION)
VALUES
    -- 시스템 코드 등록
    ('IMS', 'SYSTEM_CODE', NULL, 'IMS', '통합 관리 시스템', '통합 관리 시스템 (Integrated Management System)', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('LMS', 'SYSTEM_CODE', NULL, 'LMS', '랜드사 관리 시스템', '랜드사 관리 시스템 (Land Management System)', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('TMS', 'SYSTEM_CODE', NULL, 'TMS', '여행사 관리 시스템', '여행사 관리 시스템 (Travel Management System)', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('TPS', 'SYSTEM_CODE', NULL, 'TPS', '여행사 판매 시스템', '여행사 판매 시스템 (Travel Purchase System)', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('GDS', 'SYSTEM_CODE', NULL, 'GDS', '가이드 시스템', '가이드 시스템 (Guide System)', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1);

-- ----------------------------------------------------
-- 모듈 코드 등록 (MODULE_CODE)
-- ----------------------------------------------------
INSERT INTO SHARED_CODE_MANAGEMENT (SYSTEM_CODE, CODE_TYPE, PARENT_CODE, CODE, NAME, DESCRIPTION, IS_ACTIVE, CREATED_AT, CREATE_USER_ID, CREATE_USER_NAME, CREATE_IP, VERSION)
VALUES
    -- 통합 관리 시스템 (IMS)
    ('IMS', 'MODULE_CODE', 'IMS', 'IMS-API', 'IMS API', '통합 관리 시스템 API 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'MODULE_CODE', 'IMS', 'IMS-WEB', 'IMS WEB', '통합 관리 시스템 WEB 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),

    -- 랜드사 관리 시스템 (LMS)
    ('LMS', 'MODULE_CODE', 'LMS', 'LMS-API', 'LMS API', '랜드사 관리 시스템 API 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('LMS', 'MODULE_CODE', 'LMS', 'LMS-WEB', 'LMS WEB', '랜드사 관리 시스템 WEB 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),

    -- 여행사 관리 시스템 (TMS)
    ('TMS', 'MODULE_CODE', 'TMS', 'TMS-API', 'TMS API', '여행사 관리 시스템 API 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('TMS', 'MODULE_CODE', 'TMS', 'TMS-WEB', 'TMS WEB', '여행사 관리 시스템 WEB 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),

    -- 여행사 판매 시스템 (TPS)
    ('TPS', 'MODULE_CODE', 'TPS', 'TPS-API', 'TPS API', '여행사 판매 시스템 API 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('TPS', 'MODULE_CODE', 'TPS', 'TPS-WEB', 'TPS WEB', '여행사 판매 시스템 WEB 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('TPS', 'MODULE_CODE', 'TPS', 'TPS-WEBVIEW', 'TPS WEBVIEW', '여행사 판매 시스템 WEBVIEW 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('TPS', 'MODULE_CODE', 'TPS', 'TPS-AOS', 'TPS AOS', '여행사 판매 시스템 Android 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('TPS', 'MODULE_CODE', 'TPS', 'TPS-IOS', 'TPS IOS', '여행사 판매 시스템 iOS 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),

    -- 가이드 시스템 (GDS)
    ('GDS', 'MODULE_CODE', 'GDS', 'GDS-API', 'GDS API', '가이드 시스템 API 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('GDS', 'MODULE_CODE', 'GDS', 'GDS-WEB', 'GDS WEB', '가이드 시스템 WEB 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('GDS', 'MODULE_CODE', 'GDS', 'GDS-WEBVIEW', 'GDS WEBVIEW', '가이드 시스템 WEBVIEW 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('GDS', 'MODULE_CODE', 'GDS', 'GDS-AOS', 'GDS AOS', '가이드 시스템 Android 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('GDS', 'MODULE_CODE', 'GDS', 'GDS-IOS', 'GDS IOS', '가이드 시스템 iOS 모듈', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1);


-- ----------------------------------------------------
-- 업무구분코드업무구분코드(계층형) 등록
-- ----------------------------------------------------
-- IMS 시스템의 ADMIN 및 하위 상세 업무 코드 등록 (SHARED_CODE_MANAGEMENT)
INSERT INTO SHARED_CODE_MANAGEMENT (SYSTEM_CODE, CODE_TYPE, PARENT_CODE, CODE, NAME, DESCRIPTION, IS_ACTIVE, CREATED_AT, CREATE_USER_ID, CREATE_USER_NAME, CREATE_IP, VERSION)
VALUES
    -- 상위 업무 구분 코드 (ADMIN)
    ('IMS', 'BUSINESS_DIVISION', NULL, 'ADMIN', '관리자', 'IMS 시스템의 관리자 업무 구분', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),

    -- ADMIN 하위 상세 업무 코드
    ('IMS', 'DETAIL_DIVISION', 'ADMIN', 'BASE_CODE', '기본코드관리', 'IMS 시스템의 기본 코드 관리 업무', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'DETAIL_DIVISION', 'ADMIN', 'MENU_PROGRAM', '메뉴.프로그램관리', 'IMS 시스템의 메뉴 및 프로그램 관리 업무', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'DETAIL_DIVISION', 'ADMIN', 'PERMISSION', '권한관리', 'IMS 시스템의 권한 관리 업무', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),

    -- 기본코드관리 (BASE_CODE)의 하위 상세 코드
    ('IMS', 'DETAIL_DIVISION', 'BASE_CODE', 'GROUP_CODE', '코드그룹관리', 'IMS 시스템의 코드 그룹 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'DETAIL_DIVISION', 'BASE_CODE', 'CODE_MGMT', '코드관리', 'IMS 시스템의 개별 코드 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'DETAIL_DIVISION', 'BASE_CODE', 'SYSTEM_CODE_MGMT', '시스템코드관리', 'IMS 시스템의 시스템 코드 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'DETAIL_DIVISION', 'BASE_CODE', 'BUSINESS_CODE_MGMT', '업무구분코드관리', 'IMS 시스템의 업무 구분 코드 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'DETAIL_DIVISION', 'BASE_CODE', 'DETAIL_CODE_MGMT', '상세업무코드관리', 'IMS 시스템의 상세 업무 코드 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),

    -- 메뉴.프로그램관리 (MENU_PROGRAM)의 하위 상세 코드
    ('IMS', 'DETAIL_DIVISION', 'MENU_PROGRAM', 'PROGRAM_MGMT', '프로그램관리', 'IMS 시스템의 프로그램 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'DETAIL_DIVISION', 'MENU_PROGRAM', 'MENU_MGMT', '메뉴관리', 'IMS 시스템의 메뉴 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),

    -- 권한관리 (PERMISSION)의 하위 상세 코드
    ('IMS', 'DETAIL_DIVISION', 'PERMISSION', 'PERMISSION_GROUP_MGMT', '권한그룹관리', 'IMS 시스템의 권한 그룹 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'DETAIL_DIVISION', 'PERMISSION', 'PERMISSION_MGMT', '권한관리', 'IMS 시스템의 개별 권한 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'DETAIL_DIVISION', 'PERMISSION', 'PERMISSION_ADMIN_MGMT', '권한 관리자관리', 'IMS 시스템의 권한 관리자 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'DETAIL_DIVISION', 'PERMISSION', 'MENU_PERMISSION_MGMT', '메뉴별 권한관리', 'IMS 시스템의 메뉴별 권한 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'DETAIL_DIVISION', 'PERMISSION', 'USER_PERMISSION_MGMT', '권한별 사용자관리', 'IMS 시스템의 권한별 사용자 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1),
    ('IMS', 'DETAIL_DIVISION', 'PERMISSION', 'USER_ROLE_MGMT', '사용자별 권한관리', 'IMS 시스템의 사용자별 권한 관리 기능', TRUE, CURRENT_TIMESTAMP, 'system', 'System', '127.0.0.1', 1);









