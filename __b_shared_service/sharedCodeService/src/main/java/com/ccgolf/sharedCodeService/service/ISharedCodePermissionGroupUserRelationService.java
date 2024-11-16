package com.ccgolf.sharedCodeService.service;

import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroupUserRelation;

import java.util.List;

/**
 * SharedCodePermissionGroupUserRelation 서비스를 위한 인터페이스입니다.
 * CRUD 작업을 수행하기 위한 메서드를 정의합니다.
 */
public interface ISharedCodePermissionGroupUserRelationService {

    /**
     * 모든 SharedCodePermissionGroupUserRelation 엔티티를 조회합니다.
     *
     * @return SharedCodePermissionGroupUserRelation 엔티티의 리스트
     */
    List<SharedCodePermissionGroupUserRelation> getAllUserRelations();

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroupUserRelation 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodePermissionGroupUserRelation 엔티티
     */
    SharedCodePermissionGroupUserRelation getUserRelationById(Long id);

    /**
     * 새로운 SharedCodePermissionGroupUserRelation 엔티티를 생성합니다.
     *
     * @param userRelation 생성할 SharedCodePermissionGroupUserRelation 엔티티
     * @return 생성된 SharedCodePermissionGroupUserRelation 엔티티
     */
    SharedCodePermissionGroupUserRelation createUserRelation(SharedCodePermissionGroupUserRelation userRelation);

    /**
     * 기존 SharedCodePermissionGroupUserRelation 엔티티를 업데이트합니다.
     *
     * @param id          업데이트할 엔티티의 ID
     * @param userRelation 업데이트할 데이터가 담긴 SharedCodePermissionGroupUserRelation 엔티티
     * @return 업데이트된 SharedCodePermissionGroupUserRelation 엔티티
     */
    SharedCodePermissionGroupUserRelation updateUserRelation(Long id, SharedCodePermissionGroupUserRelation userRelation);

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroupUserRelation 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     */
    void deleteUserRelation(Long id);
}
