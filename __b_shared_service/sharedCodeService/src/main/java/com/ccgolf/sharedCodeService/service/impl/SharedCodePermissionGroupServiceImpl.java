package com.ccgolf.sharedCodeService.service.impl;

import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroup;
import com.ccgolf.sharedCodeService.exception.EntityNotFoundException;
import com.ccgolf.sharedCodeService.repository.SharedCodePermissionGroupRepository;
import com.ccgolf.sharedCodeService.service.ISharedCodePermissionGroupService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SharedCodePermissionGroup 서비스를 구현한 클래스입니다.
 * ISharedCodePermissionGroupService 인터페이스를 구현하며,
 * SharedCodePermissionGroup 엔티티에 대한 CRUD 작업을 수행합니다.
 */
@Service
public class SharedCodePermissionGroupServiceImpl implements ISharedCodePermissionGroupService {

    private final SharedCodePermissionGroupRepository repository;

    /**
     * 생성자 주입을 통한 레포지토리 의존성 주입.
     *
     * @param repository SharedCodePermissionGroupRepository 인스턴스
     */
    @Autowired
    public SharedCodePermissionGroupServiceImpl(SharedCodePermissionGroupRepository repository) {
        this.repository = repository;
    }

    /**
     * 모든 SharedCodePermissionGroup 엔티티를 조회합니다.
     *
     * @return SharedCodePermissionGroup 엔티티의 리스트
     */
    @Override
    public List<SharedCodePermissionGroup> getAllPermissionGroups() {
        return repository.findAll();
    }

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroup 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodePermissionGroup 엔티티
     * @throws EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    @Override
    public SharedCodePermissionGroup getPermissionGroupById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.formatErrMsg("SharedCodePermissionGroup", "ID", id)));
    }

    /**
     * 새로운 SharedCodePermissionGroup 엔티티를 생성합니다.
     *
     * @param group 생성할 SharedCodePermissionGroup 엔티티
     * @return 생성된 SharedCodePermissionGroup 엔티티
     */
    @Override
    public SharedCodePermissionGroup createPermissionGroup(SharedCodePermissionGroup group) {
        return repository.save(group);
    }

    /**
     * 기존 SharedCodePermissionGroup 엔티티를 업데이트합니다.
     *
     * @param id    업데이트할 엔티티의 ID
     * @param group 업데이트할 데이터가 담긴 SharedCodePermissionGroup 엔티티
     * @return 업데이트된 SharedCodePermissionGroup 엔티티
     * @throws EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    @Override
    public SharedCodePermissionGroup updatePermissionGroup(Long id, SharedCodePermissionGroup group) {
        SharedCodePermissionGroup existingGroup = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.formatErrMsg("SharedCodePermissionGroup", "ID", id)));

        if (group.getCodeType() != null) {
            existingGroup.setCodeType(group.getCodeType());
        }
        if (group.getCode() != null) {
            existingGroup.setCode(group.getCode());
        }
        if (group.getPermissionGroupId() != null) {
            existingGroup.setPermissionGroupId(group.getPermissionGroupId());
        }
        if (group.getPermissionGroupName() != null) {
            existingGroup.setPermissionGroupName(group.getPermissionGroupName());
        }
        if (group.getPermissionGroupDescription() != null) {
            existingGroup.setPermissionGroupDescription(group.getPermissionGroupDescription());
        }
        if (group.getPermissionGroupStartDate() != null) {
            existingGroup.setPermissionGroupStartDate(group.getPermissionGroupStartDate());
        }
        if (group.getPermissionGroupEndDate() != null) {
            existingGroup.setPermissionGroupEndDate(group.getPermissionGroupEndDate());
        }

        return repository.save(existingGroup);
    }

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroup 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @throws EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    @Override
    public void deletePermissionGroup(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(MessageUtil.formatErrMsg("SharedCodePermissionGroup", "ID", id));
        }
        repository.deleteById(id);
    }
}
