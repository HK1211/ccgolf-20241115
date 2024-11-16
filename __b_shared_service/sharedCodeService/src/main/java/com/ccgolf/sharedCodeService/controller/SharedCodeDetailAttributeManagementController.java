package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodeDetailAttributeManagement;
import com.ccgolf.sharedCodeService.service.ISharedCodeDetailAttributeManagementService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/code-details")
public class SharedCodeDetailAttributeManagementController {

    @Autowired
    private ISharedCodeDetailAttributeManagementService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodeDetailAttributeManagement>>> getAllAttributes() {
        List<SharedCodeDetailAttributeManagement> list = service.getAllAttributes();
        return ResponseEntity.ok(ApiResponse.ok(list, MessageUtil.formatSuccessMessage("조회")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeDetailAttributeManagement>> getAttributeById(@PathVariable Long id) {
        SharedCodeDetailAttributeManagement attribute = service.getAttributeById(id);
        return ResponseEntity.ok(ApiResponse.ok(attribute, MessageUtil.formatSuccessMessage("조회")));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodeDetailAttributeManagement>> createAttribute(@RequestBody SharedCodeDetailAttributeManagement attribute) {
        SharedCodeDetailAttributeManagement createdAttribute = service.createAttribute(attribute);
        return ResponseEntity.ok(ApiResponse.ok(createdAttribute, MessageUtil.formatSuccessMessage("등록")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeDetailAttributeManagement>> updateAttribute(@PathVariable Long id, @RequestBody SharedCodeDetailAttributeManagement attribute) {
        SharedCodeDetailAttributeManagement updatedAttribute = service.updateAttribute(id, attribute);
        return ResponseEntity.ok(ApiResponse.ok(updatedAttribute, MessageUtil.formatSuccessMessage("수정")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAttribute(@PathVariable Long id) {
        service.deleteAttribute(id);
        return ResponseEntity.ok(ApiResponse.ok(null, MessageUtil.formatSuccessMessage("삭제")));
    }
}
