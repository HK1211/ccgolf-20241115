package com.ccgolf.sharedCodeService.service;

import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroup;

import java.util.List;

/**
 * SharedCodePermissionGroup 서비스를 위한 인터페이스입니다.
 * CRUD 작업을 수행하기 위한 메서드를 정의합니다.
 */
public interface ISharedCodePermissionGroupService {

    /**
     * 모든 SharedCodePermissionGroup 엔티티를 조회합니다.
     *
     * @return SharedCodePermissionGroup 엔티티의 리스트
     */
    List<SharedCodePermissionGroup> getAllPermissionGroups();

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroup 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodePermissionGroup 엔티티
     * @throws com.ccgolf.sharedCodeService.exception.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    SharedCodePermissionGroup getPermissionGroupById(Long id);

    /**
     * 새로운 SharedCodePermissionGroup 엔티티를 생성합니다.
     *
     * @param group 생성할 SharedCodePermissionGroup 엔티티
     * @return 생성된 SharedCodePermissionGroup 엔티티
     */
    SharedCodePermissionGroup createPermissionGroup(SharedCodePermissionGroup group);

    /**
     * 기존 SharedCodePermissionGroup 엔티티를 업데이트합니다.
     *
     * @param id    업데이트할 엔티티의 ID
     * @param group 업데이트할 데이터가 담긴 SharedCodePermissionGroup 엔티티
     * @return 업데이트된 SharedCodePermissionGroup 엔티티
     * @throws com.ccgolf.sharedCodeService.exception.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    SharedCodePermissionGroup updatePermissionGroup(Long id, SharedCodePermissionGroup group);

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroup 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @throws com.ccgolf.sharedCodeService.exception.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    void deletePermissionGroup(Long id);
}
