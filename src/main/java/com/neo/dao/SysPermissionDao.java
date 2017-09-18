package com.neo.dao;

import com.neo.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zouxiang on 2017/9/14.
 */
public interface SysPermissionDao extends JpaRepository<SysPermission,Integer> {


    List<SysPermission> findByResourceTypeOrderByIdAsc(String menu);

}
