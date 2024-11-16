package com.ccgolf.sharedCodeService.service;

import com.ccgolf.sharedCodeService.entity.SharedCodeProgramManagement;

import java.util.List;

/**
 * SharedCodeProgramManagement 서비스를 위한 인터페이스입니다.
 * CRUD 작업을 수행하기 위한 메서드를 정의합니다.
 */
public interface ISharedCodeProgramManagementService {

    /**
     * 모든 SharedCodeProgramManagement 엔티티를 조회합니다.
     *
     * @return SharedCodeProgramManagement 엔티티의 리스트
     */
    List<SharedCodeProgramManagement> getAllPrograms();

    /**
     * 주어진 ID에 해당하는 SharedCodeProgramManagement 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodeProgramManagement 엔티티
     */
    SharedCodeProgramManagement getProgramById(Long id);

    /**
     * 새로운 SharedCodeProgramManagement 엔티티를 생성합니다.
     *
     * @param program 생성할 SharedCodeProgramManagement 엔티티
     * @return 생성된 SharedCodeProgramManagement 엔티티
     */
    SharedCodeProgramManagement createProgram(SharedCodeProgramManagement program);

    /**
     * 기존 SharedCodeProgramManagement 엔티티를 업데이트합니다.
     *
     * @param id      업데이트할 엔티티의 ID
     * @param program 업데이트할 데이터가 담긴 SharedCodeProgramManagement 엔티티
     * @return 업데이트된 SharedCodeProgramManagement 엔티티
     */
    SharedCodeProgramManagement updateProgram(Long id, SharedCodeProgramManagement program);

    /**
     * 주어진 ID에 해당하는 SharedCodeProgramManagement 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     */
    void deleteProgram(Long id);
}
