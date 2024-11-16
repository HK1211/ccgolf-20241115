package com.ccgolf.sharedCodeService.service.impl;

import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroupRelation;
import com.ccgolf.sharedCodeService.exception.EntityNotFoundException;
import com.ccgolf.sharedCodeService.repository.SharedCodePermissionGroupRelationRepository;
import com.ccgolf.sharedCodeService.service.ISharedCodePermissionGroupRelationService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SharedCodePermissionGroupRelation 서비스를 구현한 클래스입니다.
 * ISharedCodePermissionGroupRelationService 인터페이스를 구현하며,
 * SharedCodePermissionGroupRelation 엔티티에 대한 CRUD 작업을 수행합니다.
 */
@Service
public class SharedCodePermissionGroupRelationServiceImpl implements ISharedCodePermissionGroupRelationService {

    private final SharedCodePermissionGroupRelationRepository repository;

    /**
     * 생성자 주입을 통한 레포지토리 의존성 주입.
     *
     * @param repository SharedCodePermissionGroupRelationRepository 인스턴스
     */
    @Autowired
    public SharedCodePermissionGroupRelationServiceImpl(SharedCodePermissionGroupRelationRepository repository) {
        this.repository = repository;
    }

    /**
     * 모든 SharedCodePermissionGroupRelation 엔티티를 조회합니다.
     *
     * @return SharedCodePermissionGroupRelation 엔티티의 리스트
     */
    @Override
    public List<SharedCodePermissionGroupRelation> getAllRelations() {
        return repository.findAll();
    }

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroupRelation 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodePermissionGroupRelation 엔티티
     * @throws EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    @Override
    public SharedCodePermissionGroupRelation getRelationById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.formatErrMsg("SharedCodePermissionGroupRelation", "ID", id)));
    }

    /**
     * 새로운 SharedCodePermissionGroupRelation 엔티티를 생성합니다.
     *
     * @param relation 생성할 SharedCodePermissionGroupRelation 엔티티
     * @return 생성된 SharedCodePermissionGroupRelation 엔티티
     */
    @Override
    public SharedCodePermissionGroupRelation createRelation(SharedCodePermissionGroupRelation relation) {
        return repository.save(relation);
    }

    /**
     * 기존 SharedCodePermissionGroupRelation 엔티티를 업데이트합니다.
     *
     * @param id        업데이트할 엔티티의 ID
     * @param relation  업데이트할 데이터가 담긴 SharedCodePermissionGroupRelation 엔티티
     * @return 업데이트된 SharedCodePermissionGroupRelation 엔티티
     * @throws EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    @Override
    public SharedCodePermissionGroupRelation updateRelation(Long id, SharedCodePermissionGroupRelation relation) {
        SharedCodePermissionGroupRelation existingRelation = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.formatErrMsg("SharedCodePermissionGroupRelation", "ID", id)));

        if (relation.getPermissionGroupSeq() != null) {
            existingRelation.setPermissionGroupSeq(relation.getPermissionGroupSeq());
        }
        if (relation.getPermissionSeq() != null) {
            existingRelation.setPermissionSeq(relation.getPermissionSeq());
        }

        return repository.save(existingRelation);
    }

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroupRelation 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @throws EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    @Override
    public void deleteRelation(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(MessageUtil.formatErrMsg("SharedCodePermissionGroupRelation", "ID", id));
        }
        repository.deleteById(id);
    }
}
