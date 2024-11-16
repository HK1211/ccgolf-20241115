package com.ccgolf.sharedCodeService.repository;

import com.ccgolf.sharedCodeService.entity.SharedCodePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharedCodePermissionRepository extends JpaRepository<SharedCodePermission, Long> {
    // 예시: 특정 타입의 권한을 찾는 메서드
    List<SharedCodePermission> findByType(String type);
}
