package com.ccgolf.sharedCodeService.repository;

import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroupRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * SharedCodePermissionGroupRelation 엔티티를 위한 레포지토리 인터페이스입니다.
 * JpaRepository를 확장하여 기본적인 CRUD 메서드를 제공합니다.
 */
@Repository
public interface SharedCodePermissionGroupRelationRepository extends JpaRepository<SharedCodePermissionGroupRelation, Long> {

    /**
     * PERMISSION_GROUP_SEQ와 PERMISSION_SEQ의 조합으로 엔티티를 조회합니다.
     *
     * @param permissionGroupSeq 권한 그룹 시퀀스
     * @param permissionSeq      권한 시퀀스
     * @return 조회된 SharedCodePermissionGroupRelation 엔티티(Optional)
     */
    Optional<SharedCodePermissionGroupRelation> findByPermissionGroupSeqAndPermissionSeq(Long permissionGroupSeq, Long permissionSeq);
}