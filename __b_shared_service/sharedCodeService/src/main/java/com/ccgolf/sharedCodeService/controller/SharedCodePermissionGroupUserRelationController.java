package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroupUserRelation;
import com.ccgolf.sharedCodeService.service.SharedCodePermissionGroupUserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permission-group-user-relations")
public class SharedCodePermissionGroupUserRelationController {

    @Autowired
    private SharedCodePermissionGroupUserRelationService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodePermissionGroupUserRelation>>> getAllUserRelations() {
        List<SharedCodePermissionGroupUserRelation> list = service.getAllUserRelations();
        return ResponseEntity.ok(new ApiResponse<>(list, "200", "Success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermissionGroupUserRelation>> getUserRelationById(@PathVariable Long id) {
        SharedCodePermissionGroupUserRelation userRelation = service.getUserRelationById(id);
        return ResponseEntity.ok(new ApiResponse<>(userRelation, "200", "Success"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodePermissionGroupUserRelation>> createUserRelation(@RequestBody SharedCodePermissionGroupUserRelation userRelation) {
        SharedCodePermissionGroupUserRelation createdUserRelation = service.createUserRelation(userRelation);
        return ResponseEntity.ok(new ApiResponse<>(createdUserRelation, "201", "Created"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermissionGroupUserRelation>> updateUserRelation(@PathVariable Long id, @RequestBody SharedCodePermissionGroupUserRelation userRelation) {
        SharedCodePermissionGroupUserRelation updatedUserRelation = service.updateUserRelation(id, userRelation);
        return ResponseEntity.ok(new ApiResponse<>(updatedUserRelation, "200", "Updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUserRelation(@PathVariable Long id) {
        service.deleteUserRelation(id);
        return ResponseEntity.ok(new ApiResponse<>(null, "204", "Deleted"));
    }
}
