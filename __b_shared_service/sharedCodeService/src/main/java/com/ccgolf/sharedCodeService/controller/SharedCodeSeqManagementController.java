package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodeSeqManagement;
import com.ccgolf.sharedCodeService.service.SharedCodeSeqManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sequence")
public class SharedCodeSeqManagementController {

    @Autowired
    private SharedCodeSeqManagementService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodeSeqManagement>>> getAllSequences() {
        List<SharedCodeSeqManagement> list = service.getAllSequences();
        return ResponseEntity.ok(new ApiResponse<>(list, "200", "Success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeSeqManagement>> getSequenceById(@PathVariable Long id) {
        SharedCodeSeqManagement seq = service.getSequenceById(id);
        return ResponseEntity.ok(new ApiResponse<>(seq, "200", "Success"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodeSeqManagement>> createSequence(@RequestBody SharedCodeSeqManagement seq) {
        SharedCodeSeqManagement createdSeq = service.createSequence(seq);
        return ResponseEntity.ok(new ApiResponse<>(createdSeq, "201", "Created"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeSeqManagement>> updateSequence(@PathVariable Long id, @RequestBody SharedCodeSeqManagement seq) {
        SharedCodeSeqManagement updatedSeq = service.updateSequence(id, seq);
        return ResponseEntity.ok(new ApiResponse<>(updatedSeq, "200", "Updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSequence(@PathVariable Long id) {
        service.deleteSequence(id);
        return ResponseEntity.ok(new ApiResponse<>(null, "204", "Deleted"));
    }
}
