package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.constants.DefaultConsts;
import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodeProgramManagement;
import com.ccgolf.sharedCodeService.service.ISharedCodeProgramManagementService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SharedCodeProgramManagement 관련 요청을 처리하는 컨트롤러 클래스입니다.
 */
@RestController
@RequestMapping("/api/programs")
public class SharedCodeProgramManagementController {

    @Autowired
    private ISharedCodeProgramManagementService service;

    /**
     * 모든 SharedCodeProgramManagement 엔티티를 조회합니다.
     *
     * @return ApiResponse 형식의 응답 엔티티
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodeProgramManagement>>> getAllPrograms() {
        List<SharedCodeProgramManagement> list = service.getAllPrograms();
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(list, message));
    }

    /**
     * 주어진 ID에 해당하는 SharedCodeProgramManagement 엔티티를 조회합니다.
     *
     * @param id 조회할 엔티티의 ID
     * @return ApiResponse 형식의 응답 엔티티
     */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeProgramManagement>> getProgramById(@PathVariable Long id) {
        SharedCodeProgramManagement program = service.getProgramById(id);
        String message = MessageUtil.formatSuccessMessage("조회");
        return ResponseEntity.ok(ApiResponse.ok(program, message));
    }

    /**
     * 새로운 SharedCodeProgramManagement 엔티티를 생성합니다.
     *
     * @param program 생성할 SharedCodeProgramManagement 엔티티
     * @return ApiResponse 형식의 응답 엔티티
     */
    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodeProgramManagement>> createProgram(@RequestBody SharedCodeProgramManagement program) {
        SharedCodeProgramManagement createdProgram = service.createProgram(program);
        String message = MessageUtil.formatSuccessMessage("등록");
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(createdProgram, DefaultConsts.STATUS_201, message));
    }

    /**
     * 기존 SharedCodeProgramManagement 엔티티를 업데이트합니다.
     *
     * @param id      업데이트할 엔티티의 ID
     * @param program 업데이트할 데이터가 담긴 SharedCodeProgramManagement 엔티티
     * @return ApiResponse 형식의 응답 엔티티
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeProgramManagement>> updateProgram(@PathVariable Long id, @RequestBody SharedCodeProgramManagement program) {
        SharedCodeProgramManagement updatedProgram = service.updateProgram(id, program);
        String message = MessageUtil.formatSuccessMessage("수정");
        return ResponseEntity.ok(ApiResponse.ok(updatedProgram, message));
    }

    /**
     * 주어진 ID에 해당하는 SharedCodeProgramManagement 엔티티를 삭제합니다.
     *
     * @param id 삭제할 엔티티의 ID
     * @return ApiResponse 형식의 응답 엔티티
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProgram(@PathVariable Long id) {
        service.deleteProgram(id);
        String message = MessageUtil.formatSuccessMessage("삭제");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.ok(null, message));
    }
}
