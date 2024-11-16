package com.ccgolf.sharedCodeService.repository;

import com.ccgolf.sharedCodeService.entity.SharedCodeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SharedCodeManagementRepository extends JpaRepository<SharedCodeManagement, Long> {

    // codeType과 code가 유니크한 제약조건이 있기 때문에 이를 활용한 쿼리 메서드도 작성할 수 있습니다.
    Optional<SharedCodeManagement> findByCodeTypeAndCode(String codeType, String code);
}
