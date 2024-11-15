package com.ccgolf.sharedCodeService.repository;

import com.ccgolf.sharedCodeService.entity.SharedCodeDetailAttributeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SharedCodeDetailAttributeManagement 엔티티를 위한 레포지토리 인터페이스입니다.
 * JpaRepository를 확장하여 기본적인 CRUD 메서드를 제공합니다.
 */
@Repository
public interface SharedCodeDetailAttributeManagementRepository extends JpaRepository<SharedCodeDetailAttributeManagement, Long> {
    // 추가적인 쿼리 메서드를 여기에 정의할 수 있습니다.
}
