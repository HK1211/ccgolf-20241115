package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodeMenuManagement;
import com.ccgolf.sharedCodeService.service.SharedCodeMenuManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class SharedCodeMenuManagementController {

    @Autowired
    private SharedCodeMenuManagementService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodeMenuManagement>>> getAllMenus() {
        List<SharedCodeMenuManagement> list = service.getAllMenus();
        return ResponseEntity.ok(new ApiResponse<>(list, "200", "Success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeMenuManagement>> getMenuById(@PathVariable Long id) {
        SharedCodeMenuManagement menu = service.getMenuById(id);
        return ResponseEntity.ok(new ApiResponse<>(menu, "200", "Success"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodeMenuManagement>> createMenu(@RequestBody SharedCodeMenuManagement menu) {
        SharedCodeMenuManagement createdMenu = service.createMenu(menu);
        return ResponseEntity.ok(new ApiResponse<>(createdMenu, "201", "Created"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeMenuManagement>> updateMenu(@PathVariable Long id, @RequestBody SharedCodeMenuManagement menu) {
        SharedCodeMenuManagement updatedMenu = service.updateMenu(id, menu);
        return ResponseEntity.ok(new ApiResponse<>(updatedMenu, "200", "Updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteMenu(@PathVariable Long id) {
        service.deleteMenu(id);
        return ResponseEntity.ok(new ApiResponse<>(null, "204", "Deleted"));
    }
}
