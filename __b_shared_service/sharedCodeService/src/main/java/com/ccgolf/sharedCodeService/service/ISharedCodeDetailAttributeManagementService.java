package com.ccgolf.sharedCodeService.service;

import com.ccgolf.sharedCodeService.entity.SharedCodeDetailAttributeManagement;

import java.util.List;

/**
 * SharedCodeDetailAttributeManagement 서비스를 위한 인터페이스입니다.
 * 이 인터페이스는 CRUD 작업을 수행하기 위한 메서드를 정의합니다.
 */
public interface ISharedCodeDetailAttributeManagementService {

    /**
     * 모든 SharedCodeDetailAttributeManagement 엔티티를 조회합니다.
     *
     * @return SharedCodeDetailAttributeManagement 엔티티의 리스트
     */
    List<SharedCodeDetailAttributeManagement> getAllAttributes();

    /**
     * 주어진 ID에 해당하는 SharedCodeDetailAttributeManagement 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodeDetailAttributeManagement 엔티티
     * @throws jakarta.persistence.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    SharedCodeDetailAttributeManagement getAttributeById(Long id);

    /**
     * 새로운 SharedCodeDetailAttributeManagement 엔티티를 생성합니다.
     *
     * @param attribute 생성할 SharedCodeDetailAttributeManagement 엔티티
     * @return 생성된 SharedCodeDetailAttributeManagement 엔티티
     */
    SharedCodeDetailAttributeManagement createAttribute(SharedCodeDetailAttributeManagement attribute);

    /**
     * 기존 SharedCodeDetailAttributeManagement 엔티티를 업데이트합니다.
     *
     * @param id        업데이트할 엔티티의 ID
     * @param attribute 업데이트할 데이터가 담긴 SharedCodeDetailAttributeManagement 엔티티
     * @return 업데이트된 SharedCodeDetailAttributeManagement 엔티티
     * @throws jakarta.persistence.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    SharedCodeDetailAttributeManagement updateAttribute(Long id, SharedCodeDetailAttributeManagement attribute);

    /**
     * 주어진 ID에 해당하는 SharedCodeDetailAttributeManagement 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @throws jakarta.persistence.EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    void deleteAttribute(Long id);
}
