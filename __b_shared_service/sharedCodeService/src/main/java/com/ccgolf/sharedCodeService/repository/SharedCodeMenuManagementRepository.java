package com.ccgolf.sharedCodeService.repository;

import com.ccgolf.sharedCodeService.entity.SharedCodeMenuManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SharedCodeMenuManagementRepository extends JpaRepository<SharedCodeMenuManagement, Long> {

    // CODE_TYPE, CODE, UPPER_MENU_ID, MENU_CODE의 조합으로 엔티티 조회
    Optional<SharedCodeMenuManagement> findByCodeTypeAndCodeAndUpperMenuIdAndMenuCode(
            String codeType, String code, Long upperMenuId, String menuCode);
}
