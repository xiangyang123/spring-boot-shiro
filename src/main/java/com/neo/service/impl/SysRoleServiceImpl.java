package com.neo.service.impl;

import com.neo.dao.SysRoleDao;
import com.neo.entity.SysRole;
import com.neo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zouxiang on 2017/9/14.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public Page<SysRole> findAll(Pageable pageable) {
        return sysRoleDao.findAll(pageable);
    }

    @Override
    public void save(SysRole sysRole) {
        sysRoleDao.save(sysRole);
    }

    @Override
    public List<SysRole> findAll() {
        return sysRoleDao.findAll();
    }

    @Override
    public SysRole findById(int roleId) {
        return sysRoleDao.findOne(roleId);
    }

    @Override
    public void update(SysRole sysRole) {
        sysRoleDao.saveAndFlush(sysRole);
    }
}
