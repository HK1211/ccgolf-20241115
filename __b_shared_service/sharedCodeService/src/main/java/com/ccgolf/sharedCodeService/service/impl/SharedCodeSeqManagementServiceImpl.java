package com.ccgolf.sharedCodeService.service.impl;

import com.ccgolf.sharedCodeService.entity.SharedCodeSeqManagement;
import com.ccgolf.sharedCodeService.exception.EntityNotFoundException;
import com.ccgolf.sharedCodeService.repository.SharedCodeSeqManagementRepository;
import com.ccgolf.sharedCodeService.service.ISharedCodeSeqManagementService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SharedCodeSeqManagement 서비스를 구현한 클래스입니다.
 * ISharedCodeSeqManagementService 인터페이스를 구현하며,
 * SharedCodeSeqManagement 엔티티에 대한 CRUD 작업을 수행합니다.
 */
@Service
public class SharedCodeSeqManagementServiceImpl implements ISharedCodeSeqManagementService {

    private final SharedCodeSeqManagementRepository repository;

    /**
     * 생성자 주입을 통한 레포지토리 의존성 주입.
     *
     * @param repository SharedCodeSeqManagementRepository 인스턴스
     */
    @Autowired
    public SharedCodeSeqManagementServiceImpl(SharedCodeSeqManagementRepository repository) {
        this.repository = repository;
    }

    /**
     * 모든 SharedCodeSeqManagement 엔티티를 조회합니다.
     *
     * @return SharedCodeSeqManagement 엔티티의 리스트
     */
    @Override
    public List<SharedCodeSeqManagement> getAllSequences() {
        return repository.findAll();
    }

    /**
     * 주어진 ID에 해당하는 SharedCodeSeqManagement 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodeSeqManagement 엔티티
     */
    @Override
    public SharedCodeSeqManagement getSequenceById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageUtil.formatErrMsg("SharedCodeSeqManagement", "ID", id)));
    }

    /**
     * 새로운 SharedCodeSeqManagement 엔티티를 생성합니다.
     *
     * @param sequence 생성할 SharedCodeSeqManagement 엔티티
     * @return 생성된 SharedCodeSeqManagement 엔티티
     */
    @Override
    public SharedCodeSeqManagement createSequence(SharedCodeSeqManagement sequence) {
        return repository.save(sequence);
    }

    /**
     * 기존 SharedCodeSeqManagement 엔티티를 업데이트합니다.
     *
     * @param id       업데이트할 엔티티의 ID
     * @param sequence 업데이트할 데이터가 담긴 SharedCodeSeqManagement 엔티티
     * @return 업데이트된 SharedCodeSeqManagement 엔티티
     */
    @Override
    public SharedCodeSeqManagement updateSequence(Long id, SharedCodeSeqManagement sequence) {
        SharedCodeSeqManagement existingSequence = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageUtil.formatErrMsg("SharedCodeSeqManagement", "ID", id)));

        if (sequence.getTableName() != null) {
            existingSequence.setTableName(sequence.getTableName());
        }
        if (sequence.getColumnName() != null) {
            existingSequence.setColumnName(sequence.getColumnName());
        }
        if (sequence.getSequenceNumber() != null) {
            existingSequence.setSequenceNumber(sequence.getSequenceNumber());
        }

        return repository.save(existingSequence);
    }

    /**
     * 주어진 ID에 해당하는 SharedCodeSeqManagement 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     */
    @Override
    public void deleteSequence(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    MessageUtil.formatErrMsg("SharedCodeSeqManagement", "ID", id));
        }
        repository.deleteById(id);
    }
}
