package com.ccgolf.sharedCodeService.service.impl;

import com.ccgolf.sharedCodeService.entity.SharedCodeManagement;
import com.ccgolf.sharedCodeService.exception.EntityNotFoundException;
import com.ccgolf.sharedCodeService.repository.SharedCodeManagementRepository;
import com.ccgolf.sharedCodeService.service.ISharedCodeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SharedCodeManagementServiceImpl implements ISharedCodeManagementService {

    @Autowired
    private SharedCodeManagementRepository repository;

    @Override
    public List<SharedCodeManagement> getAllCodes() {
        return repository.findAll();
    }

    @Override
    public SharedCodeManagement getCodeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SharedCodeManagement ID " + id + "를 찾을 수 없습니다."));
    }

    @Override
    public SharedCodeManagement createCode(SharedCodeManagement code) {
        return repository.save(code);
    }

    @Override
    public SharedCodeManagement updateCode(Long id, SharedCodeManagement code) {
        SharedCodeManagement existingCode = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SharedCodeManagement ID " + id + "를 찾을 수 없습니다."));

        // ID가 존재하면, 데이터를 업데이트 (변경된 값만 업데이트)
        if (code.getCodeType() != null) {
            existingCode.setCodeType(code.getCodeType());
        }
        if (code.getCode() != null) {
            existingCode.setCode(code.getCode());
        }
        if (code.getName() != null) {
            existingCode.setName(code.getName());
        }
        if (code.getDescription() != null) {
            existingCode.setDescription(code.getDescription());
        }
        if (code.getSortOrder() != null) {
            existingCode.setSortOrder(code.getSortOrder());
        }

        return repository.save(existingCode);
    }

    @Override
    public void deleteCode(Long id) {
        SharedCodeManagement existingCode = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SharedCodeManagement ID " + id + "를 찾을 수 없습니다."));
        repository.delete(existingCode);
    }
}
