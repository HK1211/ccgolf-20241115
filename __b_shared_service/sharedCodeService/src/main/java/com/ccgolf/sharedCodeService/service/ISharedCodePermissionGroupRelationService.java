package com.ccgolf.sharedCodeService.service;

import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroupRelation;

import java.util.List;

/**
 * SharedCodePermissionGroupRelation 서비스를 위한 인터페이스입니다.
 * CRUD 작업을 수행하기 위한 메서드를 정의합니다.
 */
public interface ISharedCodePermissionGroupRelationService {

    /**
     * 모든 SharedCodePermissionGroupRelation 엔티티를 조회합니다.
     *
     * @return SharedCodePermissionGroupRelation 엔티티의 리스트
     */
    List<SharedCodePermissionGroupRelation> getAllRelations();

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroupRelation 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodePermissionGroupRelation 엔티티
     * @throws com.ccgolf.sharedCodeService.exception.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    SharedCodePermissionGroupRelation getRelationById(Long id);

    /**
     * 새로운 SharedCodePermissionGroupRelation 엔티티를 생성합니다.
     *
     * @param relation 생성할 SharedCodePermissionGroupRelation 엔티티
     * @return 생성된 SharedCodePermissionGroupRelation 엔티티
     */
    SharedCodePermissionGroupRelation createRelation(SharedCodePermissionGroupRelation relation);

    /**
     * 기존 SharedCodePermissionGroupRelation 엔티티를 업데이트합니다.
     *
     * @param id        업데이트할 엔티티의 ID
     * @param relation  업데이트할 데이터가 담긴 SharedCodePermissionGroupRelation 엔티티
     * @return 업데이트된 SharedCodePermissionGroupRelation 엔티티
     * @throws com.ccgolf.sharedCodeService.exception.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    SharedCodePermissionGroupRelation updateRelation(Long id, SharedCodePermissionGroupRelation relation);

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroupRelation 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @throws com.ccgolf.sharedCodeService.exception.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    void deleteRelation(Long id);
}
