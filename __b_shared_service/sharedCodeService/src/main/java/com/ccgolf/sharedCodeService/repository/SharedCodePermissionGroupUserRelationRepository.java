package com.ccgolf.sharedCodeService.repository;

import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroupUserRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * SharedCodePermissionGroupUserRelation 엔티티를 위한 레포지토리 인터페이스입니다.
 * JpaRepository를 확장하여 기본적인 CRUD 메서드를 제공합니다.
 */
@Repository
public interface SharedCodePermissionGroupUserRelationRepository extends JpaRepository<SharedCodePermissionGroupUserRelation, Long> {

    /**
     * PERMISSION_GROUP_SEQ와 LOGIN_ID의 조합으로 엔티티를 조회합니다.
     *
     * @param permissionGroupSeq 권한 그룹 시퀀스
     * @param loginId            로그인 ID
     * @return 조회된 SharedCodePermissionGroupUserRelation 엔티티(Optional)
     */
    Optional<SharedCodePermissionGroupUserRelation> findByPermissionGroupSeqAndLoginId(Long permissionGroupSeq, String loginId);
}
