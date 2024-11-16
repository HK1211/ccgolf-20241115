package com.ccgolf.sharedCodeService.service.impl;

import com.ccgolf.sharedCodeService.entity.SharedCodeProgramManagement;
import com.ccgolf.sharedCodeService.exception.EntityNotFoundException;
import com.ccgolf.sharedCodeService.repository.SharedCodeProgramManagementRepository;
import com.ccgolf.sharedCodeService.service.ISharedCodeProgramManagementService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SharedCodeProgramManagement 서비스를 구현한 클래스입니다.
 * ISharedCodeProgramManagementService 인터페이스를 구현하며,
 * SharedCodeProgramManagement 엔티티에 대한 CRUD 작업을 수행합니다.
 */
@Service
public class SharedCodeProgramManagementServiceImpl implements ISharedCodeProgramManagementService {

    private final SharedCodeProgramManagementRepository repository;

    /**
     * 생성자 주입을 통한 레포지토리 의존성 주입.
     *
     * @param repository SharedCodeProgramManagementRepository 인스턴스
     */
    @Autowired
    public SharedCodeProgramManagementServiceImpl(SharedCodeProgramManagementRepository repository) {
        this.repository = repository;
    }

    /**
     * 모든 SharedCodeProgramManagement 엔티티를 조회합니다.
     *
     * @return SharedCodeProgramManagement 엔티티의 리스트
     */
    @Override
    public List<SharedCodeProgramManagement> getAllPrograms() {
        return repository.findAll();
    }

    /**
     * 주어진 ID에 해당하는 SharedCodeProgramManagement 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodeProgramManagement 엔티티
     */
    @Override
    public SharedCodeProgramManagement getProgramById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageUtil.formatErrMsg("SharedCodeProgramManagement", "ID", id)));
    }

    /**
     * 새로운 SharedCodeProgramManagement 엔티티를 생성합니다.
     *
     * @param program 생성할 SharedCodeProgramManagement 엔티티
     * @return 생성된 SharedCodeProgramManagement 엔티티
     */
    @Override
    public SharedCodeProgramManagement createProgram(SharedCodeProgramManagement program) {
        return repository.save(program);
    }

    /**
     * 기존 SharedCodeProgramManagement 엔티티를 업데이트합니다.
     *
     * @param id      업데이트할 엔티티의 ID
     * @param program 업데이트할 데이터가 담긴 SharedCodeProgramManagement 엔티티
     * @return 업데이트된 SharedCodeProgramManagement 엔티티
     */
    @Override
    public SharedCodeProgramManagement updateProgram(Long id, SharedCodeProgramManagement program) {
        SharedCodeProgramManagement existingProgram = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageUtil.formatErrMsg("SharedCodeProgramManagement", "ID", id)));

        if (program.getCodeType() != null) {
            existingProgram.setCodeType(program.getCodeType());
        }
        if (program.getCode() != null) {
            existingProgram.setCode(program.getCode());
        }
        if (program.getProgramId() != null) {
            existingProgram.setProgramId(program.getProgramId());
        }
        if (program.getProgramTypeCode() != null) {
            existingProgram.setProgramTypeCode(program.getProgramTypeCode());
        }
        if (program.getProgramName() != null) {
            existingProgram.setProgramName(program.getProgramName());
        }
        if (program.getProgramDescription() != null) {
            existingProgram.setProgramDescription(program.getProgramDescription());
        }
        if (program.getProgramPath() != null) {
            existingProgram.setProgramPath(program.getProgramPath());
        }
        if (program.getProgramParameter() != null) {
            existingProgram.setProgramParameter(program.getProgramParameter());
        }
        if (program.getProgramUseStartDate() != null) {
            existingProgram.setProgramUseStartDate(program.getProgramUseStartDate());
        }
        if (program.getProgramUseEndDate() != null) {
            existingProgram.setProgramUseEndDate(program.getProgramUseEndDate());
        }
        if (program.getProgramSortOrder() != null) {
            existingProgram.setProgramSortOrder(program.getProgramSortOrder());
        }

        return repository.save(existingProgram);
    }

    /**
     * 주어진 ID에 해당하는 SharedCodeProgramManagement 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     */
    @Override
    public void deleteProgram(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    MessageUtil.formatErrMsg("SharedCodeProgramManagement", "ID", id));
        }
        repository.deleteById(id);
    }
}
