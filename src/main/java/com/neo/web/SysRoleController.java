package com.neo.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neo.entity.MenuTree;
import com.neo.entity.SysPermission;
import com.neo.entity.SysRole;
import com.neo.service.SysPermissionService;
import com.neo.service.SysRoleService;
import com.neo.util.ConstantUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouxiang on 2017/9/14.
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {

    private static final Logger logger = LoggerFactory.getLogger(SysRoleController.class);


    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/sysRoleList")
    public String sysRole(){
        return "roleInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/sysRoleAdd")
    public String sysRoleAdd(){
        return "roleInfoAdd";
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

    @RequestMapping("/findAllSysRole")
    @ResponseBody
    public JSONObject findAllSysRole(@RequestParam int page, @RequestParam int rows){
        /**
         * 分页查找数据
         */
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page-1, rows, sort);
        Page<SysRole> roleList = sysRoleService.findAll(pageable);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",roleList.getTotalElements());
        System.out.println(roleList.getContent());
        for (SysRole sysRole : roleList.getContent()) {
            sysRole.setUserInfos(null);
            sysRole.setPermissions(null);
        }
        jsonObject.put("rows",roleList.getContent());
        return jsonObject;
    }

    @RequestMapping("/submitRoleAdd")
    @ResponseBody
    public String submitRoleAdd(SysRole sysRole){
        String status = ConstantUtil.FAIlED;
        try {
            sysRole.setAvailable(true);
            sysRoleService.save(sysRole);
            status = ConstantUtil.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }


    /**
     * 分配权限
     */
    @RequestMapping("/assignPermissions")
    public String assignPermissions(Model model){
        return "assignPermissions";
    }
    /**
     * 分配权限
     */
    @RequestMapping("/assignMenu")
    @ResponseBody
    public String assignMenu(Model model,int roleId){
        logger.info("进来了");
        List<MenuTree> menuTrees =  sysPermissionService.createMenuTree(roleId);
        model.addAttribute("menuTrees",menuTrees);
        return JSONObject.toJSONString(menuTrees);
    }

    @RequestMapping("/submitAssignPermissions")
    @ResponseBody
    public String submitAssignPermissions(int roleId, HttpServletRequest request){
        String permission = request.getParameter("permissions");
        if(!StringUtils.isEmpty(permission)){
            List<Integer> ids = JSONArray.parseArray(permission,Integer.class);
            SysRole sysRole = sysRoleService.findById(roleId);
            List<SysPermission> permissions = new ArrayList<>(ids.size());
            for (int id : ids) {
                SysPermission sysPermission = sysPermissionService.findById(id);
                permissions.add(sysPermission);
            }
            sysRole.setPermissions(permissions);
            sysRoleService.update(sysRole);
        }
        return null;
    }

}
