package com.ccgolf.sharedCodeService.service;

import com.ccgolf.sharedCodeService.entity.SharedCodeManagement;

import java.util.List;

public interface ISharedCodeManagementService {

    List<SharedCodeManagement> getAllCodes();

    SharedCodeManagement getCodeById(Long id);

    SharedCodeManagement createCode(SharedCodeManagement code);

    SharedCodeManagement updateCode(Long id, SharedCodeManagement code);

    void deleteCode(Long id);
}
