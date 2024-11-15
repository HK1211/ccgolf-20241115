```Perl
workspace/
├── api-gateway/                            # API Gateway (Spring Cloud Gateway)
├── shared-services/                        # 공통 서비스
│   ├── shared-code-service/                # 공통 코드와 시스템에서 참조할 수 있는 다양한 코드 데이터를 관리하는 서비스
│   ├── shared-auth-service/                # 인증 및 권한 관리 서비스
│   └── shared-logging-service/             # 공통 로깅 서비스
│
├── admin-system/                           # 관리자 시스템
│   ├── admin-api/                          # Admin Frontend API Gateway
│   ├── admin-user-management-service/      # 관리자 사용자 계정 및 권한 관리
│   └── admin-audit-service/                # 시스템 활동 로그 및 감사 기록 관리
│
├── supplier-system/                        # 랜드사 관리 시스템
│   ├── supplier-api/                       # 랜드사 관련 API
│   ├── supplier-products-service/          # 상품 관리
│   └── supplier-pricing-service/           # 가격 관리
│
├── agency-system/                          # 여행사 관리 시스템
│   ├── agency-api/                         # 여행사 관련 API
│   ├── agency-booking-service/             # 예약 관리
│   └── agency-payment-service/             # 결제 처리
│
├── customer-system/                        # 고객 시스템
│   ├── customer-api/                       # 고객 관련 API
│   ├── customer-profile-service/           # 고객 프로필 관리
│   └── customer-notification-service/      # 알림 관리
│
└── guide-system/                           # 가이드 시스템
    ├── guide-api/                          # 가이드 관련 API
    └── guide-schedule-service/             # 일정 관리
```

