package com.ccgolf.sharedCodeService.service;

import com.ccgolf.sharedCodeService.entity.SharedCodePermission;

import java.util.List;

public interface ISharedCodePermissionService {

    /**
     * 모든 SharedCodePermission 엔티티를 조회합니다.
     *
     * @return SharedCodePermission 엔티티의 리스트
     */
    List<SharedCodePermission> getAllPermissions();

    /**
     * 주어진 ID에 해당하는 SharedCodePermission 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodePermission 엔티티
     * @throws com.ccgolf.sharedCodeService.exception.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    SharedCodePermission getPermissionById(Long id);

    /**
     * 새로운 SharedCodePermission 엔티티를 생성합니다.
     *
     * @param permission 생성할 SharedCodePermission 엔티티
     * @return 생성된 SharedCodePermission 엔티티
     */
    SharedCodePermission createPermission(SharedCodePermission permission);

    /**
     * 기존 SharedCodePermission 엔티티를 업데이트합니다.
     *
     * @param id         업데이트할 엔티티의 ID
     * @param permission 업데이트할 데이터가 담긴 SharedCodePermission 엔티티
     * @return 업데이트된 SharedCodePermission 엔티티
     * @throws com.ccgolf.sharedCodeService.exception.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    SharedCodePermission updatePermission(Long id, SharedCodePermission permission);

    /**
     * 주어진 ID에 해당하는 SharedCodePermission 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @throws com.ccgolf.sharedCodeService.exception.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    void deletePermission(Long id);
}
