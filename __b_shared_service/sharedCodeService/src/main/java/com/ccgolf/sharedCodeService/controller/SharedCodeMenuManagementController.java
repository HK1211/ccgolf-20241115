package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodeMenuManagement;
import com.ccgolf.sharedCodeService.service.ISharedCodeMenuManagementService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class SharedCodeMenuManagementController {

    @Autowired
    private ISharedCodeMenuManagementService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodeMenuManagement>>> getAllMenus() {
        List<SharedCodeMenuManagement> list = service.getAllMenus();
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(list, message));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeMenuManagement>> getMenuById(@PathVariable Long id) {
        SharedCodeMenuManagement menu = service.getMenuById(id);
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(menu, message));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodeMenuManagement>> createMenu(@RequestBody SharedCodeMenuManagement menu) {
        SharedCodeMenuManagement createdMenu = service.createMenu(menu);
        String message = MessageUtil.formatSuccessMessage("등록");
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(createdMenu, DefaultConsts.STATUS_201, message));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeMenuManagement>> updateMenu(@PathVariable Long id, @RequestBody SharedCodeMenuManagement menu) {
        SharedCodeMenuManagement updatedMenu = service.updateMenu(id, menu);
        String message = MessageUtil.formatSuccessMessage("수정");
        return ResponseEntity.ok(ApiResponse.ok(updatedMenu, message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteMenu(@PathVariable Long id) {
        service.deleteMenu(id);
        String message = MessageUtil.formatSuccessMessage("삭제");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.ok(null, message));
    }
}
