package com.ccgolf.sharedCodeService.service;

import com.ccgolf.sharedCodeService.entity.SharedCodeMenuManagement;

import java.util.List;

public interface ISharedCodeMenuManagementService {

    /**
     * 모든 SharedCodeMenuManagement 엔티티를 조회합니다.
     *
     * @return SharedCodeMenuManagement 엔티티의 리스트
     */
    List<SharedCodeMenuManagement> getAllMenus();

    /**
     * 주어진 ID에 해당하는 SharedCodeMenuManagement 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodeMenuManagement 엔티티
     * @throws jakarta.persistence.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    SharedCodeMenuManagement getMenuById(Long id);

    /**
     * 새로운 SharedCodeMenuManagement 엔티티를 생성합니다.
     *
     * @param menu 생성할 SharedCodeMenuManagement 엔티티
     * @return 생성된 SharedCodeMenuManagement 엔티티
     */
    SharedCodeMenuManagement createMenu(SharedCodeMenuManagement menu);

    /**
     * 기존 SharedCodeMenuManagement 엔티티를 업데이트합니다.
     *
     * @param id    업데이트할 엔티티의 ID
     * @param menu  업데이트할 데이터가 담긴 SharedCodeMenuManagement 엔티티
     * @return 업데이트된 SharedCodeMenuManagement 엔티티
     * @throws jakarta.persistence.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    SharedCodeMenuManagement updateMenu(Long id, SharedCodeMenuManagement menu);

    /**
     * 주어진 ID에 해당하는 SharedCodeMenuManagement 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @throws jakarta.persistence.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    void deleteMenu(Long id);
}
