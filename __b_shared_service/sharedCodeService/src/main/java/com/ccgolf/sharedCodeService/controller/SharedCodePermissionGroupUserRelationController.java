package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroupUserRelation;
import com.ccgolf.sharedCodeService.service.ISharedCodePermissionGroupUserRelationService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SharedCodePermissionGroupUserRelation 관련 요청을 처리하는 컨트롤러 클래스입니다.
 */
@RestController
@RequestMapping("/api/permission-group-user-relations")
public class SharedCodePermissionGroupUserRelationController {

    @Autowired
    private ISharedCodePermissionGroupUserRelationService service;

    /**
     * 모든 SharedCodePermissionGroupUserRelation 엔티티를 조회합니다.
     *
     * @return ApiResponse 형식의 응답 엔티티
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodePermissionGroupUserRelation>>> getAllUserRelations() {
        List<SharedCodePermissionGroupUserRelation> list = service.getAllUserRelations();
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(list, message));
    }

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroupUserRelation 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return ApiResponse 형식의 응답 엔티티
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermissionGroupUserRelation>> getUserRelationById(@PathVariable Long id) {
        SharedCodePermissionGroupUserRelation userRelation = service.getUserRelationById(id);
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(userRelation, message));
    }

    /**
     * 새로운 SharedCodePermissionGroupUserRelation 엔티티를 생성합니다.
     *
     * @param userRelation 생성할 SharedCodePermissionGroupUserRelation 엔티티
     * @return ApiResponse 형식의 응답 엔티티
     */
    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodePermissionGroupUserRelation>> createUserRelation(@RequestBody SharedCodePermissionGroupUserRelation userRelation) {
        SharedCodePermissionGroupUserRelation createdUserRelation = service.createUserRelation(userRelation);
        String message = MessageUtil.formatSuccessMessage("등록");
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(createdUserRelation, DefaultConsts.STATUS_201, message));
    }

    /**
     * 기존 SharedCodePermissionGroupUserRelation 엔티티를 업데이트합니다.
     *
     * @param id          업데이트할 엔티티의 ID
     * @param userRelation 업데이트할 데이터가 담긴 SharedCodePermissionGroupUserRelation 엔티티
     * @return ApiResponse 형식의 응답 엔티티
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermissionGroupUserRelation>> updateUserRelation(@PathVariable Long id, @RequestBody SharedCodePermissionGroupUserRelation userRelation) {
        SharedCodePermissionGroupUserRelation updatedUserRelation = service.updateUserRelation(id, userRelation);
        String message = MessageUtil.formatSuccessMessage("수정");
        return ResponseEntity.ok(ApiResponse.ok(updatedUserRelation, message));
    }

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroupUserRelation 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @return ApiResponse 형식의 응답 엔티티
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUserRelation(@PathVariable Long id) {
        service.deleteUserRelation(id);
        String message = MessageUtil.formatSuccessMessage("삭제");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.ok(null, message));
    }
}
