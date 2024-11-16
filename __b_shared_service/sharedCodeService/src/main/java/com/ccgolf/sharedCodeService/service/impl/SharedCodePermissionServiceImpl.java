package com.ccgolf.sharedCodeService.service.impl;

import com.ccgolf.sharedCodeService.entity.SharedCodePermission;
import com.ccgolf.sharedCodeService.exception.EntityNotFoundException;
import com.ccgolf.sharedCodeService.repository.SharedCodePermissionRepository;
import com.ccgolf.sharedCodeService.service.ISharedCodePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SharedCodePermissionServiceImpl implements ISharedCodePermissionService {

    private final SharedCodePermissionRepository repository;

    @Autowired
    public SharedCodePermissionServiceImpl(SharedCodePermissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SharedCodePermission> getAllPermissions() {
        return repository.findAll();
    }

    @Override
    public SharedCodePermission getPermissionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SharedCodePermission ID " + id + "를 찾을 수 없습니다."));
    }

    @Override
    public SharedCodePermission createPermission(SharedCodePermission permission) {
        return repository.save(permission);
    }

    @Override
    public SharedCodePermission updatePermission(Long id, SharedCodePermission permission) {
        SharedCodePermission existingPermission = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SharedCodePermission ID " + id + "를 찾을 수 없습니다."));

        if (permission.getName() != null) {
            existingPermission.setName(permission.getName());
        }
        if (permission.getType() != null) {
            existingPermission.setType(permission.getType());
        }

        return repository.save(existingPermission);
    }

    @Override
    public void deletePermission(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("SharedCodePermission ID " + id + "를 찾을 수 없습니다.");
        }
        repository.deleteById(id);
    }
}
