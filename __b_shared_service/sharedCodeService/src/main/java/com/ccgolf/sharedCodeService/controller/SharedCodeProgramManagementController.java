package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodeProgramManagement;
import com.ccgolf.sharedCodeService.service.SharedCodeProgramManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
public class SharedCodeProgramManagementController {

    @Autowired
    private SharedCodeProgramManagementService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodeProgramManagement>>> getAllPrograms() {
        List<SharedCodeProgramManagement> list = service.getAllPrograms();
        return ResponseEntity.ok(new ApiResponse<>(list, "200", "Success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeProgramManagement>> getProgramById(@PathVariable Long id) {
        SharedCodeProgramManagement program = service.getProgramById(id);
        return ResponseEntity.ok(new ApiResponse<>(program, "200", "Success"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodeProgramManagement>> createProgram(@RequestBody SharedCodeProgramManagement program) {
        SharedCodeProgramManagement createdProgram = service.createProgram(program);
        return ResponseEntity.ok(new ApiResponse<>(createdProgram, "201", "Created"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeProgramManagement>> updateProgram(@PathVariable Long id, @RequestBody SharedCodeProgramManagement program) {
        SharedCodeProgramManagement updatedProgram = service.updateProgram(id, program);
        return ResponseEntity.ok(new ApiResponse<>(updatedProgram, "200", "Updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProgram(@PathVariable Long id) {
        service.deleteProgram(id
