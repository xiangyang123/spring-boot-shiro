package com.neo.util;

import com.neo.entity.MenuTree;
import com.neo.entity.SysPermission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zouxiang on 2017/9/18.
 */
public class TreeNoteUtil {

    /**
     * 获取父节点菜单
     * @param sysPermissionsList 所有树菜单集合
     * @return
     */
    public final static List<MenuTree> getFatherNode(List<SysPermission> sysPermissionsList, List<SysPermission> selectPermissionList){
        List<MenuTree> newTrees = new ArrayList<MenuTree>();
        for (SysPermission sysPermission : sysPermissionsList) {
            MenuTree menuTree = new MenuTree();
            menuTree.setId(sysPermission.getId());
            menuTree.setpId(sysPermission.getParentId());
            menuTree.setText(sysPermission.getName());
            menuTree.setUrl(sysPermission.getUrl());
            menuTree.setState("close");
            if(selectPermissionList.contains(sysPermission)){
                menuTree.setChecked(true);
            }
            if (sysPermission.getParentId() == 0L) {//如果pId为空，则该节点为父节点
                //递归获取父节点下的子节点
                menuTree.setChildren(getChildrenNode(sysPermission.getId(), sysPermissionsList,selectPermissionList));
                newTrees.add(menuTree);
            }
        }
        return newTrees;
    }

    /**
     * 递归获取子节点下的子节点
     * @param pId 父节点的ID
     * @param sysPermissionsList 所有菜单树集合
     * @param selectPermissionList
     * @return
     */
    private final static List<MenuTree> getChildrenNode(Integer pId, List<SysPermission> sysPermissionsList, List<SysPermission> selectPermissionList){
        List<MenuTree> newTrees = new ArrayList<MenuTree>();
        for (SysPermission sysPermission : sysPermissionsList) {
            if (sysPermission.getParentId() == 0L) {
                continue;
            }
            if(sysPermission.getParentId().intValue() == pId){
                MenuTree menuTree = new MenuTree();
                menuTree.setId(sysPermission.getId());
                menuTree.setpId(sysPermission.getParentId());
                menuTree.setText(sysPermission.getName());
                menuTree.setUrl(sysPermission.getUrl());
                menuTree.setState("close");
                if(selectPermissionList.contains(sysPermission)){
                    menuTree.setChecked(true);
                }
                //递归获取子节点下的子节点，即设置树控件中的children
                menuTree.setChildren(getChildrenNode(sysPermission.getId(), sysPermissionsList, selectPermissionList));
                //设置树控件attributes属性的数据
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("url", menuTree.getUrl());
                menuTree.setAttributes(map);
                newTrees.add(menuTree);
            }
        }
        return newTrees;
    }

}
