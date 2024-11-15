package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodeManagement;
import com.ccgolf.sharedCodeService.service.SharedCodeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/codes")
public class SharedCodeManagementController {

    @Autowired
    private SharedCodeManagementService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodeManagement>>> getAllCodes() {
        List<SharedCodeManagement> list = service.getAllCodes();
        return ResponseEntity.ok(new ApiResponse<>(list, "200", "Success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeManagement>> getCodeById(@PathVariable Long id) {
        SharedCodeManagement code = service.getCodeById(id);
        return ResponseEntity.ok(new ApiResponse<>(code, "200", "Success"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodeManagement>> createCode(@RequestBody SharedCodeManagement code) {
        SharedCodeManagement createdCode = service.createCode(code);
        return ResponseEntity.ok(new ApiResponse<>(createdCode, "201", "Created"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeManagement>> updateCode(@PathVariable Long id, @RequestBody SharedCodeManagement code) {
        SharedCodeManagement updatedCode = service.updateCode(id, code);
        return ResponseEntity.ok(new ApiResponse<>(updatedCode, "200", "Updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCode(@PathVariable Long id) {
        service.deleteCode(id);
        return ResponseEntity.ok(new ApiResponse<>(null, "204", "Deleted"));
    }
}
