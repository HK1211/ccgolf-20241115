package com.ccgolf.sharedCodeService.repository;

import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * SharedCodePermissionGroup 엔티티를 위한 레포지토리 인터페이스입니다.
 * JpaRepository를 확장하여 기본적인 CRUD 메서드를 제공합니다.
 */
@Repository
public interface SharedCodePermissionGroupRepository extends JpaRepository<SharedCodePermissionGroup, Long> {

    /**
     * CODE_TYPE, CODE, PERMISSION_GROUP_ID의 조합으로 엔티티를 조회합니다.
     *
     * @param codeType          코드 타입
     * @param code              코드
     * @param permissionGroupId 권한 그룹 ID
     * @return 조회된 SharedCodePermissionGroup 엔티티(Optional)
     */
    Optional<SharedCodePermissionGroup> findByCodeTypeAndCodeAndPermissionGroupId(String codeType, String code, String permissionGroupId);
}
