package com.ccgolf.sharedCodeService.service.impl;

import com.ccgolf.sharedCodeService.entity.SharedCodeDetailAttributeManagement;
import com.ccgolf.sharedCodeService.exception.EntityNotFoundException;
import com.ccgolf.sharedCodeService.repository.SharedCodeDetailAttributeManagementRepository;
import com.ccgolf.sharedCodeService.service.ISharedCodeDetailAttributeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SharedCodeDetailAttributeManagement 서비스를 구현한 클래스입니다.
 * 이 클래스는 ISharedCodeDetailAttributeManagementService 인터페이스를 구현하며,
 * SharedCodeDetailAttributeManagement 엔티티에 대한 CRUD 작업을 수행합니다.
 */
@Service
public class SharedCodeDetailAttributeManagementServiceImpl implements ISharedCodeDetailAttributeManagementService {

    private final SharedCodeDetailAttributeManagementRepository repository;

    /**
     * 생성자 주입을 통한 레포지토리 의존성 주입.
     *
     * @param repository SharedCodeDetailAttributeManagementRepository 인스턴스
     */
    @Autowired
    public SharedCodeDetailAttributeManagementServiceImpl(SharedCodeDetailAttributeManagementRepository repository) {
        this.repository = repository;
    }

    /**
     * 모든 SharedCodeDetailAttributeManagement 엔티티를 조회합니다.
     *
     * @return SharedCodeDetailAttributeManagement 엔티티의 리스트
     */
    @Override
    public List<SharedCodeDetailAttributeManagement> getAllAttributes() {
        return repository.findAll();
    }

    /**
     * 주어진 ID에 해당하는 SharedCodeDetailAttributeManagement 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return 조회된 SharedCodeDetailAttributeManagement 엔티티
     * @throws EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    @Override
    public SharedCodeDetailAttributeManagement getAttributeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID " + id + "에 해당하는 속성을 찾을 수 없습니다."));
    }

    /**
     * 새로운 SharedCodeDetailAttributeManagement 엔티티를 생성합니다.
     *
     * @param attribute 생성할 SharedCodeDetailAttributeManagement 엔티티
     * @return 생성된 SharedCodeDetailAttributeManagement 엔티티
     */
    @Override
    public SharedCodeDetailAttributeManagement createAttribute(SharedCodeDetailAttributeManagement attribute) {
        // 필요 시 추가적인 비즈니스 로직을 여기에 추가할 수 있습니다.
        return repository.save(attribute);
    }

    /**
     * 기존 SharedCodeDetailAttributeManagement 엔티티를 업데이트합니다.
     *
     * @param id        업데이트할 엔티티의 ID
     * @param attribute 업데이트할 데이터가 담긴 SharedCodeDetailAttributeManagement 엔티티
     * @return 업데이트된 SharedCodeDetailAttributeManagement 엔티티
     * @throws EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    @Override
    public SharedCodeDetailAttributeManagement updateAttribute(Long id, SharedCodeDetailAttributeManagement attribute) {
        // 1. 주어진 ID에 해당하는 엔티티를 조회
        SharedCodeDetailAttributeManagement existingAttribute = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID " + id + "에 해당하는 속성을 찾을 수 없습니다."));

        // 2. 속성 값을 업데이트 (필요한 필드만 수정)
        if (attribute.getCodeType() != null) {
            existingAttribute.setCodeType(attribute.getCodeType());
        }
        if (attribute.getCode() != null) {
            existingAttribute.setCode(attribute.getCode());
        }
        if (attribute.getAttributeCode() != null) {
            existingAttribute.setAttributeCode(attribute.getAttributeCode());
        }
        if (attribute.getAttributeName() != null) {
            existingAttribute.setAttributeName(attribute.getAttributeName());
        }
        if (attribute.getAttributeDescription() != null) {
            existingAttribute.setAttributeDescription(attribute.getAttributeDescription());
        }

        // 3. startDate와 endDate가 유효하면 업데이트 (예시: 특정 날짜 범위 체크)
        if (attribute.getStartDate() != null && attribute.getEndDate() != null) {
            // 날짜가 올바른 범위인지 체크하는 비즈니스 로직 예시
            if (attribute.getEndDate().isBefore(attribute.getStartDate())) {
                throw new IllegalArgumentException("End date cannot be before start date.");
            }
            existingAttribute.setStartDate(attribute.getStartDate());
            existingAttribute.setEndDate(attribute.getEndDate());
        }

        // 4. isActive가 null이 아니면 업데이트
        if (attribute.getIsActive() != null) {
            existingAttribute.setIsActive(attribute.getIsActive());
        }

        // 5. 수정된 데이터를 저장
        return repository.save(existingAttribute);
    }

    /**
     * 주어진 ID에 해당하는 SharedCodeDetailAttributeManagement 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @throws EntityNotFoundException 엔티티를 찾지 못한 경우
     */
    @Override
    public void deleteAttribute(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("ID " + id + "에 해당하는 속성을 찾을 수 없습니다.");
        }
        repository.deleteById(id);
    }
}
