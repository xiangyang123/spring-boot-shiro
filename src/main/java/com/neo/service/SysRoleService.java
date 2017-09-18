package com.neo.service;

import com.neo.entity.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by zouxiang on 2017/9/14.
 */
public interface SysRoleService {

    Page<SysRole> findAll(Pageable pageable);

    void save(SysRole sysRole);

    List<SysRole> findAll();

    SysRole findById(int roleId);

    void update(SysRole sysRole);
}
