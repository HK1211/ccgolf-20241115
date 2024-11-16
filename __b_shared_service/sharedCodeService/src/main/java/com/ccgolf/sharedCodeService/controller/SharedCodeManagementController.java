package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodeManagement;
import com.ccgolf.sharedCodeService.service.ISharedCodeManagementService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/codes")
public class SharedCodeManagementController {

    @Autowired
    private ISharedCodeManagementService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodeManagement>>> getAllCodes() {
        List<SharedCodeManagement> list = service.getAllCodes();
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(list, message));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeManagement>> getCodeById(@PathVariable Long id) {
        SharedCodeManagement code = service.getCodeById(id);
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(code, message));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodeManagement>> createCode(@RequestBody SharedCodeManagement code) {
        SharedCodeManagement createdCode = service.createCode(code);
        String message = MessageUtil.formatSuccessMessage("등록");
        return ResponseEntity.ok(ApiResponse.ok(createdCode, DefaultConsts.STATUS_201, message));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeManagement>> updateCode(@PathVariable Long id, @RequestBody SharedCodeManagement code) {
        SharedCodeManagement updatedCode = service.updateCode(id, code);
        String message = MessageUtil.formatSuccessMessage("수정");
        return ResponseEntity.ok(ApiResponse.ok(updatedCode, message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCode(@PathVariable Long id) {
        service.deleteCode(id);
        String message = MessageUtil.formatSuccessMessage("삭제");
        return ResponseEntity.ok(ApiResponse.ok(null, message));
    }
}
