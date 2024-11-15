# 2024-11-15 금요일

마지막 한일:
GPT에게 서비스 클레스 생성 요청하고 작성함.
링크: https://chatgpt.com/share/6737751e-0ee8-800e-a396-4d916015668e

다음 할일: gpt에게 컨트롤러 코드를 주고 => 서비스 인터페이스, 서비스 구현, 레포지토리, Dto 만들어 달라고 하기.
```
package com.ccgolf.sharedCodeService.controller;

import com.ccgolf.sharedCodeService.dto.ApiResponse;
import com.ccgolf.sharedCodeService.entity.SharedCodeDetailAttributeManagement;
import com.ccgolf.sharedCodeService.service.SharedCodeDetailAttributeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/code-details")
public class SharedCodeDetailAttributeManagementController {

    @Autowired
    private SharedCodeDetailAttributeManagementService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SharedCodeDetailAttributeManagement>>> getAllAttributes() {
        List<SharedCodeDetailAttributeManagement> list = service.getAllAttributes();
        return ResponseEntity.ok(new ApiResponse<>(list, "200", "Success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeDetailAttributeManagement>> getAttributeById(@PathVariable Long id) {
        SharedCodeDetailAttributeManagement attribute = service.getAttributeById(id);
        return ResponseEntity.ok(new ApiResponse<>(attribute, "200", "Success"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SharedCodeDetailAttributeManagement>> createAttribute(@RequestBody SharedCodeDetailAttributeManagement attribute) {
        SharedCodeDetailAttributeManagement createdAttribute = service.createAttribute(attribute);
        return ResponseEntity.ok(new ApiResponse<>(createdAttribute, "201", "Created"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SharedCodeDetailAttributeManagement>> updateAttribute(@PathVariable Long id, @RequestBody SharedCodeDetailAttributeManagement attribute) {
        SharedCodeDetailAttributeManagement updatedAttribute = service.updateAttribute(id, attribute);
        return ResponseEntity.ok(new ApiResponse<>(updatedAttribute, "200", "Updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAttribute(@PathVariable Long id) {
        service.deleteAttribute(id);
        return ResponseEntity.ok(new ApiResponse<>(null, "204", "Deleted"));
    }
}

위 컨트롤러에 적합한 ISharedCodeDetailAttributeManagementService 클레스와 SharedCodeDetailAttributeManagementServiceImpl 클레스 만들어줘.
```