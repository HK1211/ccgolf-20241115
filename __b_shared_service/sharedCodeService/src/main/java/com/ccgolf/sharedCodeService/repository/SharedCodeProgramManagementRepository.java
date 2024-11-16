package com.ccgolf.sharedCodeService.repository;

import com.ccgolf.sharedCodeService.entity.SharedCodeProgramManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SharedCodeProgramManagement 엔티티를 위한 레포지토리 인터페이스입니다.
 * JpaRepository를 확장하여 기본적인 CRUD 메서드를 제공합니다.
 */
@Repository
public interface SharedCodeProgramManagementRepository extends JpaRepository<SharedCodeProgramManagement, Long> {
}