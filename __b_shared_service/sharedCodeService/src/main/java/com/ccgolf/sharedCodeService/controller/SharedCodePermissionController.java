package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodePermission;
import com.ccgolf.sharedCodeService.service.SharedCodePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
public class SharedCodePermissionController {

    @Autowired
    private SharedCodePermissionService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodePermission>>> getAllPermissions() {
        List<SharedCodePermission> list = service.getAllPermissions();
        return ResponseEntity.ok(new ApiResponse<>(list, "200", "Success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermission>> getPermissionById(@PathVariable Long id) {
        SharedCodePermission permission = service.getPermissionById(id);
        return ResponseEntity.ok(new ApiResponse<>(permission, "200", "Success"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodePermission>> createPermission(@RequestBody SharedCodePermission permission) {
        SharedCodePermission createdPermission = service.createPermission(permission);
        return ResponseEntity.ok(new ApiResponse<>(createdPermission, "201", "Created"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermission>> updatePermission(@PathVariable Long id, @RequestBody SharedCodePermission permission) {
        SharedCodePermission updatedPermission = service.updatePermission(id, permission);
        return ResponseEntity.ok(new ApiResponse<>(updatedPermission, "200", "Updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePermission(@PathVariable Long id) {
        service.deletePermission(id);
        return ResponseEntity.ok(new ApiResponse<>(null, "204", "Deleted"));
    }
}
