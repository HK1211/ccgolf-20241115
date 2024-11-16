package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodePermission;
import com.ccgolf.sharedCodeService.service.ISharedCodePermissionService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
public class SharedCodePermissionController {

    @Autowired
    private ISharedCodePermissionService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodePermission>>> getAllPermissions() {
        List<SharedCodePermission> list = service.getAllPermissions();
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(list, message));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermission>> getPermissionById(@PathVariable Long id) {
        SharedCodePermission permission = service.getPermissionById(id);
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(permission, message));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodePermission>> createPermission(@RequestBody SharedCodePermission permission) {
        SharedCodePermission createdPermission = service.createPermission(permission);
        String message = MessageUtil.formatSuccessMessage("등록");
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(createdPermission, DefaultConsts.STATUS_201, message));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermission>> updatePermission(@PathVariable Long id, @RequestBody SharedCodePermission permission) {
        SharedCodePermission updatedPermission = service.updatePermission(id, permission);
        String message = MessageUtil.formatSuccessMessage("수정");
        return ResponseEntity.ok(ApiResponse.ok(updatedPermission, message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePermission(@PathVariable Long id) {
        service.deletePermission(id);
        String message = MessageUtil.formatSuccessMessage("삭제");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.ok(null, message));
    }
}
