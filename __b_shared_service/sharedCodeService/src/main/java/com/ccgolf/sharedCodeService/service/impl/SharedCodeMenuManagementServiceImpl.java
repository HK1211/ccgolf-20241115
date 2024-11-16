package com.ccgolf.sharedCodeService.service.impl;

import com.ccgolf.sharedCodeService.entity.SharedCodeMenuManagement;
import com.ccgolf.sharedCodeService.exception.EntityNotFoundException;
import com.ccgolf.sharedCodeService.repository.SharedCodeMenuManagementRepository;
import com.ccgolf.sharedCodeService.service.ISharedCodeMenuManagementService;
import com.ccgolf.sharedCodeService.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SharedCodeMenuManagementServiceImpl implements ISharedCodeMenuManagementService {

    private final SharedCodeMenuManagementRepository repository;

    @Autowired
    public SharedCodeMenuManagementServiceImpl(SharedCodeMenuManagementRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SharedCodeMenuManagement> getAllMenus() {
        return repository.findAll();
    }

    @Override
    public SharedCodeMenuManagement getMenuById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SharedCodeMenuManagement ID " + id + "를 찾을 수 없습니다."));
    }

    @Override
    public SharedCodeMenuManagement createMenu(SharedCodeMenuManagement menu) {
        // 필요 시 추가적인 비즈니스 로직을 여기에 추가할 수 있습니다.
        return repository.save(menu);
    }

    @Override
    public SharedCodeMenuManagement updateMenu(Long id, SharedCodeMenuManagement menu) {
        SharedCodeMenuManagement existingMenu = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageUtil.formatErrMsg("SharedCodeMenuManagement", "ID", id)));

        // 메뉴 사용 시작일과 종료일이 유효한지 확인
        if (menu.getMenuUseStartDate() != null && menu.getMenuUseEndDate() != null) {
            if (menu.getMenuUseEndDate().isBefore(menu.getMenuUseStartDate())) {
                throw new IllegalArgumentException("메뉴 사용 종료일은 시작일 이후여야 합니다.");
            }
            existingMenu.setMenuUseStartDate(menu.getMenuUseStartDate());
            existingMenu.setMenuUseEndDate(menu.getMenuUseEndDate());
        }

        // 나머지 필드 업데이트
        if (menu.getCodeType() != null) {
            existingMenu.setCodeType(menu.getCodeType());
        }
        if (menu.getCode() != null) {
            existingMenu.setCode(menu.getCode());
        }
        if (menu.getUpperMenuId() != null) {
            existingMenu.setUpperMenuId(menu.getUpperMenuId());
        }
        if (menu.getMenuCode() != null) {
            existingMenu.setMenuCode(menu.getMenuCode());
        }
        if (menu.getMenuLevel() != null) {
            existingMenu.setMenuLevel(menu.getMenuLevel());
        }
        if (menu.getMenuName() != null) {
            existingMenu.setMenuName(menu.getMenuName());
        }
        if (menu.getMenuSortOrder() != null) {
            existingMenu.setMenuSortOrder(menu.getMenuSortOrder());
        }
        if (menu.getMenuDescription() != null) {
            existingMenu.setMenuDescription(menu.getMenuDescription());
        }
        if (menu.getMenuTypeCode() != null) {
            existingMenu.setMenuTypeCode(menu.getMenuTypeCode());
        }
        if (menu.getMenuTypeName() != null) {
            existingMenu.setMenuTypeName(menu.getMenuTypeName());
        }
        if (menu.getMenuTypeDescription() != null) {
            existingMenu.setMenuTypeDescription(menu.getMenuTypeDescription());
        }
        if (menu.getMenuParameter() != null) {
            existingMenu.setMenuParameter(menu.getMenuParameter());
        }
        if (menu.getMultiOpenStatus() != null) {
            existingMenu.setMultiOpenStatus(menu.getMultiOpenStatus());
        }
        if (menu.getHelpPageLink() != null) {
            existingMenu.setHelpPageLink(menu.getHelpPageLink());
        }

        return repository.save(existingMenu);
    }


    @Override
    public void deleteMenu(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("SharedCodeMenuManagement ID " + id + "를 찾을 수 없습니다.");
        }
        repository.deleteById(id);
    }
}
