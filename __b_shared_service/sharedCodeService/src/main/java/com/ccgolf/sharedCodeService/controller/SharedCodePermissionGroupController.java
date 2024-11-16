package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroup;
import com.ccgolf.sharedCodeService.service.ISharedCodePermissionGroupService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SharedCodePermissionGroup 관련 요청을 처리하는 컨트롤러 클래스입니다.
 */
@RestController
@RequestMapping("/api/permission-groups")
public class SharedCodePermissionGroupController {

    @Autowired
    private ISharedCodePermissionGroupService service;

    /**
     * 모든 SharedCodePermissionGroup 엔티티를 조회합니다.
     *
     * @return ApiResponse 형식의 응답 엔티티
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodePermissionGroup>>> getAllPermissionGroups() {
        List<SharedCodePermissionGroup> list = service.getAllPermissionGroups();
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(list, message));
    }

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroup 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return ApiResponse 형식의 응답 엔티티
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermissionGroup>> getPermissionGroupById(@PathVariable Long id) {
        SharedCodePermissionGroup group = service.getPermissionGroupById(id);
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(group, message));
    }

    /**
     * 새로운 SharedCodePermissionGroup 엔티티를 생성합니다.
     *
     * @param group 생성할 SharedCodePermissionGroup 엔티티
     * @return ApiResponse 형식의 응답 엔티티
     */
    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodePermissionGroup>> createPermissionGroup(@RequestBody SharedCodePermissionGroup group) {
        SharedCodePermissionGroup createdGroup = service.createPermissionGroup(group);
        String message = MessageUtil.formatSuccessMessage("등록");
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(createdGroup, DefaultConsts.STATUS_201, message));
    }

    /**
     * 기존 SharedCodePermissionGroup 엔티티를 업데이트합니다.
     *
     * @param id    업데이트할 엔티티의 ID
     * @param group 업데이트할 데이터가 담긴 SharedCodePermissionGroup 엔티티
     * @return ApiResponse 형식의 응답 엔티티
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermissionGroup>> updatePermissionGroup(@PathVariable Long id, @RequestBody SharedCodePermissionGroup group) {
        SharedCodePermissionGroup updatedGroup = service.updatePermissionGroup(id, group);
        String message = MessageUtil.formatSuccessMessage("수정");
        return ResponseEntity.ok(ApiResponse.ok(updatedGroup, message));
    }

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroup 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @return ApiResponse 형식의 응답 엔티티
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePermissionGroup(@PathVariable Long id) {
        service.deletePermissionGroup(id);
        String message = MessageUtil.formatSuccessMessage("삭제");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.ok(null, message));
    }
}
