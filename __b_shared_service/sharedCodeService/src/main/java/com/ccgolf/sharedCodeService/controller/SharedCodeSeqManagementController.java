package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodeSeqManagement;
import com.ccgolf.sharedCodeService.service.ISharedCodeSeqManagementService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SharedCodeSeqManagement 관련 요청을 처리하는 컨트롤러 클래스입니다.
 */
@RestController
@RequestMapping("/api/sequences")
public class SharedCodeSeqManagementController {

    @Autowired
    private ISharedCodeSeqManagementService service;

    /**
     * 모든 SharedCodeSeqManagement 엔티티를 조회합니다.
     *
     * @return ApiResponse 형식의 응답 엔티티
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodeSeqManagement>>> getAllSequences() {
        List<SharedCodeSeqManagement> list = service.getAllSequences();
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(list, message));
    }

    /**
     * 주어진 ID에 해당하는 SharedCodeSeqManagement 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return ApiResponse 형식의 응답 엔티티
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeSeqManagement>> getSequenceById(@PathVariable Long id) {
        SharedCodeSeqManagement sequence = service.getSequenceById(id);
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(sequence, message));
    }

    /**
     * 새로운 SharedCodeSeqManagement 엔티티를 생성합니다.
     *
     * @param sequence 생성할 SharedCodeSeqManagement 엔티티
     * @return ApiResponse 형식의 응답 엔티티
     */
    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodeSeqManagement>> createSequence(@RequestBody SharedCodeSeqManagement sequence) {
        SharedCodeSeqManagement createdSequence = service.createSequence(sequence);
        String message = MessageUtil.formatSuccessMessage("등록");
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(createdSequence, DefaultConsts.STATUS_201, message));
    }

    /**
     * 기존 SharedCodeSeqManagement 엔티티를 업데이트합니다.
     *
     * @param id       업데이트할 엔티티의 ID
     * @param sequence 업데이트할 데이터가 담긴 SharedCodeSeqManagement 엔티티
     * @return ApiResponse 형식의 응답 엔티티
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeSeqManagement>> updateSequence(@PathVariable Long id, @RequestBody SharedCodeSeqManagement sequence) {
        SharedCodeSeqManagement updatedSequence = service.updateSequence(id, sequence);
        String message = MessageUtil.formatSuccessMessage("수정");
        return ResponseEntity.ok(ApiResponse.ok(updatedSequence, message));
    }

    /**
     * 주어진 ID에 해당하는 SharedCodeSeqManagement 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @return ApiResponse 형식의 응답 엔티티
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSequence(@PathVariable Long id) {
        service.deleteSequence(id);
        String message = MessageUtil.formatSuccessMessage("삭제");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.ok(null, message));
    }
}
