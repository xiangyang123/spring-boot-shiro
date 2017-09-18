package com.neo.service;

import com.neo.entity.MenuTree;
import com.neo.entity.SysPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zouxiang on 2017/9/14.
 */
public interface SysPermissionService {

    Page<SysPermission> findAll(Pageable pageable);

    void save(SysPermission sysPermission);

    List<SysPermission> findMenus();

    List<MenuTree> createMenuTree(int roleId);

    SysPermission findById(int id);
}
