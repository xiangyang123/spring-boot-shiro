package com.neo.web;

import com.alibaba.fastjson.JSONObject;
import com.neo.entity.SysRole;
import com.neo.entity.UserInfo;
import com.neo.service.SysRoleService;
import com.neo.service.UserInfoService;
import com.neo.util.ConstantUtil;
import com.neo.util.PasswordHelper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouxiang on 2017/9/14.
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {


    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userInfo(){
        return "userInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }

    @RequestMapping("/findAllUserInfo")
    @ResponseBody
    public JSONObject findAllUserInfo(@RequestParam int page, @RequestParam int rows){
        /**
         * 分页查找数据
         */
        Sort sort = new Sort(Sort.Direction.DESC, "uid");
        Pageable pageable = new PageRequest(page-1, rows, sort);
        Page<UserInfo> userList = userInfoService.findAll(pageable);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",userList.getTotalElements());
        System.out.println(userList.getContent());
        List<UserInfo> list = userList.getContent();
        for (UserInfo userInfo : list) {
            StringBuilder stringBuilder = new StringBuilder();
            for (SysRole sysRole : userInfo.getRoleList()) {
                String description = sysRole.getDescription();
                stringBuilder.append(description);
            }
            userInfo.setRoles(stringBuilder.toString());
            userInfo.setRoleList(null);
        }
        jsonObject.put("rows",userList.getContent());
        return jsonObject;
    }

    @RequestMapping("/submitUserAdd")
    @ResponseBody
    public String submitUserAdd(UserInfo userInfo){
        String status = ConstantUtil.FAIlED;
        try {
            userInfo = PasswordHelper.encryptPassword(userInfo);
            userInfoService.save(userInfo);
            status = ConstantUtil.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    /**
     * 删除用户
     * @param delId
     * @return
     */
    @RequestMapping("/userDelete")
    @ResponseBody
    public String userDelete(int delId){
        String status = ConstantUtil.FAIlED;
        try {
            userInfoService.delete(delId);
            status = ConstantUtil.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
       return status;
    }

    /**
     * 分配角色
     */
    @RequestMapping("/assignRoles")
    public String assignRoles(Model model){
        List<SysRole> sysRoles = sysRoleService.findAll();
        for (SysRole sysRole : sysRoles) {
            sysRole.setUserInfos(null);
            sysRole.setPermissions(null);
        }
        model.addAttribute("sysRoles",sysRoles);
        return "assignRoles";
    }

    @RequestMapping("/submitAssignRoles")
    @ResponseBody
    public String submitAssignRoles(int roleId,int userId){
        UserInfo userInfo = userInfoService.findById(userId);
        List<SysRole> roleList = new ArrayList<>();
        SysRole sysRole = sysRoleService.findById(roleId);
        roleList.add(sysRole);
        userInfo.setRoleList(roleList);
        userInfoService.update(userInfo);
        return null;
    }
}
