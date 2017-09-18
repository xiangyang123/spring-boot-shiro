package com.neo.service.impl;

import com.neo.dao.SysPermissionDao;
import com.neo.dao.SysRoleDao;
import com.neo.entity.MenuTree;
import com.neo.entity.SysPermission;
import com.neo.entity.SysRole;
import com.neo.service.SysPermissionService;
import com.neo.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zouxiang on 2017/9/14.
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionDao sysPermissionDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Override
    public Page<SysPermission> findAll(Pageable pageable) {
        return sysPermissionDao.findAll(pageable);
    }

    @Override
    public void save(SysPermission sysPermission) {
        sysPermissionDao.save(sysPermission);
    }

    @Override
    public List<SysPermission> findMenus() {
        return sysPermissionDao.findByResourceTypeOrderByIdAsc("menu");
    }

    @Override
    public List<MenuTree> createMenuTree(int roleId) {
        SysRole role = sysRoleDao.findOne(roleId);
        List<MenuTree> menuTrees = TreeNoteUtil.getFatherNode(sysPermissionDao.findAll(),role.getPermissions());
        return menuTrees;
    }

    @Override
    public SysPermission findById(int id) {
        return sysPermissionDao.findOne(id);
    }
}
