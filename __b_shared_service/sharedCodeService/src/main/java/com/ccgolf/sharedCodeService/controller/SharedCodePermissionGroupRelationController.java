package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodePermissionGroupRelation;
import com.ccgolf.sharedCodeService.service.SharedCodePermissionGroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permission-group-relations")
public class SharedCodePermissionGroupRelationController {

    @Autowired
    private SharedCodePermissionGroupRelationService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodePermissionGroupRelation>>> getAllRelations() {
        List<SharedCodePermissionGroupRelation> list = service.getAllRelations();
        return ResponseEntity.ok(new ApiResponse<>(list, "200", "Success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermissionGroupRelation>> getRelationById(@PathVariable Long id) {
        SharedCodePermissionGroupRelation relation = service.getRelationById(id);
        return ResponseEntity.ok(new ApiResponse<>(relation, "200", "Success"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodePermissionGroupRelation>> createRelation(@RequestBody SharedCodePermissionGroupRelation relation) {
        SharedCodePermissionGroupRelation createdRelation = service.createRelation(relation);
        return ResponseEntity.ok(new ApiResponse<>(createdRelation, "201", "Created"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodePermissionGroupRelation>> updateRelation(@PathVariable Long id, @RequestBody SharedCodePermissionGroupRelation relation) {
        SharedCodePermissionGroupRelation updatedRelation = service.updateRelation(id, relation);
        return ResponseEntity.ok(new ApiResponse<>(updatedRelation, "200", "Updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRelation(@PathVariable Long id) {
        service.deleteRelation(id);
        return ResponseEntity.ok(new ApiResponse<>(null, "204", "Deleted"));
    }
}
