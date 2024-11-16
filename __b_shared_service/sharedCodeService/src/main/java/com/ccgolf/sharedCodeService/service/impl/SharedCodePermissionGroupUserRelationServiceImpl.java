package com.ccgolf.sharedCodeService.service.impl;

import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroupUserRelation;
import com.ccgolf.sharedCodeService.repository.SharedCodePermissionGroupUserRelationRepository;
import com.ccgolf.sharedCodeService.service.ISharedCodePermissionGroupUserRelationService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SharedCodePermissionGroupUserRelation 서비스를 구현한 클래스입니다.
 * ISharedCodePermissionGroupUserRelationService 인터페이스를 구현하며,
 * SharedCodePermissionGroupUserRelation 엔티티에 대한 CRUD 작업을 수행합니다.
 */
@Service
public class SharedCodePermissionGroupUserRelationServiceImpl implements ISharedCodePermissionGroupUserRelationService {

    private final SharedCodePermissionGroupUserRelationRepository repository;

    /**
     * 생성자 주입을 통한 레포지토리 의존성 주입.
     *
     * @param repository SharedCodePermissionGroupUserRelationRepository 인스턴스
     */
    @Autowired
    public SharedCodePermissionGroupUserRelationServiceImpl(SharedCodePermissionGroupUserRelationRepository repository) {
        this.repository = repository;
    }

    /**
     * 모든 SharedCodePermissionGroupUserRelation 엔티티를 조회합니다.
     *
     * @return SharedCodePermissionGroupUserRelation 엔티티의 리스트
     */
    @Override
    public List<SharedCodePermissionGroupUserRelation> getAllUserRelations() {
        return repository.findAll();
    }

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroupUserRelation 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodePermissionGroupUserRelation 엔티티
     */
    @Override
    public SharedCodePermissionGroupUserRelation getUserRelationById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new com.ccgolf.sharedCodeService.exception.EntityNotFoundException(
                        MessageUtil.formatErrMsg("SharedCodePermissionGroupUserRelation", "ID", id)));
    }

    /**
     * 새로운 SharedCodePermissionGroupUserRelation 엔티티를 생성합니다.
     *
     * @param userRelation 생성할 SharedCodePermissionGroupUserRelation 엔티티
     * @return 생성된 SharedCodePermissionGroupUserRelation 엔티티
     */
    @Override
    public SharedCodePermissionGroupUserRelation createUserRelation(SharedCodePermissionGroupUserRelation userRelation) {
        return repository.save(userRelation);
    }

    /**
     * 기존 SharedCodePermissionGroupUserRelation 엔티티를 업데이트합니다.
     *
     * @param id          업데이트할 엔티티의 ID
     * @param userRelation 업데이트할 데이터가 담긴 SharedCodePermissionGroupUserRelation 엔티티
     * @return 업데이트된 SharedCodePermissionGroupUserRelation 엔티티
     */
    @Override
    public SharedCodePermissionGroupUserRelation updateUserRelation(Long id, SharedCodePermissionGroupUserRelation userRelation) {
        SharedCodePermissionGroupUserRelation existingRelation = repository.findById(id)
                .orElseThrow(() -> new com.ccgolf.sharedCodeService.exception.EntityNotFoundException(
                        MessageUtil.formatErrMsg("SharedCodePermissionGroupUserRelation", "ID", id)));

        if (userRelation.getPermissionGroupSeq() != null) {
            existingRelation.setPermissionGroupSeq(userRelation.getPermissionGroupSeq());
        }
        if (userRelation.getLoginId() != null) {
            existingRelation.setLoginId(userRelation.getLoginId());
        }

        return repository.save(existingRelation);
    }

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroupUserRelation 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     */
    @Override
    public void deleteUserRelation(Long id) {
        if (!repository.existsById(id)) {
            throw new com.ccgolf.sharedCodeService.exception.EntityNotFoundException(
                    MessageUtil.formatErrMsg("SharedCodePermissionGroupUserRelation", "ID", id));
        }
        repository.deleteById(id);
    }
}
