package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroupRelation;
import com.ccgolf.sharedCodeService.service.ISharedCodePermissionGroupRelationService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SharedCodePermissionGroupRelation 관련 요청을 처리하는 컨트롤러 클래스입니다.
 */
@RestController
@RequestMapping("/api/permission-group-relations")
public class SharedCodePermissionGroupRelationController {

    @Autowired
    private ISharedCodePermissionGroupRelationService service;

    /**
     * 모든 SharedCodePermissionGroupRelation 엔티티를 조회합니다.
     *
     * @return ApiResponse 형식의 응답 엔티티
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodePermissionGroupRelation>>> getAllRelations() {
        List<SharedCodePermissionGroupRelation> list = service.getAllRelations();
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(list, message));
    }

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroupRelation 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return ApiResponse 형식의 응답 엔티티
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermissionGroupRelation>> getRelationById(@PathVariable Long id) {
        SharedCodePermissionGroupRelation relation = service.getRelationById(id);
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(relation, message));
    }

    /**
     * 새로운 SharedCodePermissionGroupRelation 엔티티를 생성합니다.
     *
     * @param relation 생성할 SharedCodePermissionGroupRelation 엔티티
     * @return ApiResponse 형식의 응답 엔티티
     */
    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodePermissionGroupRelation>> createRelation(@RequestBody SharedCodePermissionGroupRelation relation) {
        SharedCodePermissionGroupRelation createdRelation = service.createRelation(relation);
        String message = MessageUtil.formatSuccessMessage("등록");
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(createdRelation, DefaultConsts.STATUS_201, message));
    }

    /**
     * 기존 SharedCodePermissionGroupRelation 엔티티를 업데이트합니다.
     *
     * @param id        업데이트할 엔티티의 ID
     * @param relation  업데이트할 데이터가 담긴 SharedCodePermissionGroupRelation 엔티티
     * @return ApiResponse 형식의 응답 엔티티
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermissionGroupRelation>> updateRelation(@PathVariable Long id, @RequestBody SharedCodePermissionGroupRelation relation) {
        SharedCodePermissionGroupRelation updatedRelation = service.updateRelation(id, relation);
        String message = MessageUtil.formatSuccessMessage("수정");
        return ResponseEntity.ok(ApiResponse.ok(updatedRelation, message));
    }

    /**
     * 주어진 ID에 해당하는 SharedCodePermissionGroupRelation 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @return ApiResponse 형식의 응답 엔티티
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRelation(@PathVariable Long id) {
        service.deleteRelation(id);
        String message = MessageUtil.formatSuccessMessage("삭제");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.ok(null, message));
    }
}
