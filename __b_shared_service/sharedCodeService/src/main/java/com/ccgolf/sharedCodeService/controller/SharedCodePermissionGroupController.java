package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroup;
import com.ccgolf.sharedCodeService.service.SharedCodePermissionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permission-groups")
public class SharedCodePermissionGroupController {

    @Autowired
    private SharedCodePermissionGroupService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodePermissionGroup>>> getAllPermissionGroups() {
        List<SharedCodePermissionGroup> list = service.getAllPermissionGroups();
        return ResponseEntity.ok(new ApiResponse<>(list, "200", "Success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermissionGroup>> getPermissionGroupById(@PathVariable Long id) {
        SharedCodePermissionGroup group = service.getPermissionGroupById(id);
        return ResponseEntity.ok(new ApiResponse<>(group, "200", "Success"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodePermissionGroup>> createPermissionGroup(@RequestBody SharedCodePermissionGroup group) {
        SharedCodePermissionGroup createdGroup = service.createPermissionGroup(group);
        return ResponseEntity.ok(new ApiResponse<>(createdGroup, "201", "Created"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermissionGroup>> updatePermissionGroup(@PathVariable Long id, @RequestBody SharedCodePermissionGroup group) {
        SharedCodePermissionGroup updatedGroup = service.updatePermissionGroup(id, group);
        return ResponseEntity.ok(new ApiResponse<>(updatedGroup, "200", "Updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePermissionGroup(@PathVariable Long id) {
        service.deletePermissionGroup(id);
        return ResponseEntity.ok(new ApiResponse<>(null, "204", "Deleted"));
    }
}
