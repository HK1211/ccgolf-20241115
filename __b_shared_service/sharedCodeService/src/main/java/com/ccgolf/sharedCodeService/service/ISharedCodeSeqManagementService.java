package com.ccgolf.sharedCodeService.service;

import com.ccgolf.sharedCodeService.entity.SharedCodeSeqManagement;

import java.util.List;

/**
 * SharedCodeSeqManagement 서비스를 위한 인터페이스입니다.
 * CRUD 작업을 수행하기 위한 메서드를 정의합니다.
 */
public interface ISharedCodeSeqManagementService {

    /**
     * 모든 SharedCodeSeqManagement 엔티티를 조회합니다.
     *
     * @return SharedCodeSeqManagement 엔티티의 리스트
     */
    List<SharedCodeSeqManagement> getAllSequences();

    /**
     * 주어진 ID에 해당하는 SharedCodeSeqManagement 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodeSeqManagement 엔티티
     */
    SharedCodeSeqManagement getSequenceById(Long id);

    /**
     * 새로운 SharedCodeSeqManagement 엔티티를 생성합니다.
     *
     * @param sequence 생성할 SharedCodeSeqManagement 엔티티
     * @return 생성된 SharedCodeSeqManagement 엔티티
     */
    SharedCodeSeqManagement createSequence(SharedCodeSeqManagement sequence);

    /**
     * 기존 SharedCodeSeqManagement 엔티티를 업데이트합니다.
     *
     * @param id       업데이트할 엔티티의 ID
     * @param sequence 업데이트할 데이터가 담긴 SharedCodeSeqManagement 엔티티
     * @return 업데이트된 SharedCodeSeqManagement 엔티티
     */
    SharedCodeSeqManagement updateSequence(Long id, SharedCodeSeqManagement sequence);

    /**
     * 주어진 ID에 해당하는 SharedCodeSeqManagement 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     */
    void deleteSequence(Long id);
}
