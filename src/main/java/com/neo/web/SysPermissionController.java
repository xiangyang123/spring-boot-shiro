package com.neo.web;

import com.alibaba.fastjson.JSONObject;
import com.neo.entity.SysPermission;
import com.neo.service.SysPermissionService;
import com.neo.util.ConstantUtil;
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

import java.util.List;

/**
 * Created by zouxiang on 2017/9/14.
 * 权限管理
 */
@Controller
@RequestMapping("/sysPermission")
public class SysPermissionController {


    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 权限查询.
     * @return
     */
    @RequestMapping("/sysPermissionList")
    public String sysPermission(){
        return "permissionInfo";
    }

    /**
     * 权限添加;
     * @return
     */
    @RequestMapping("/sysPermissionAdd")
    public String sysPermissionAdd(Model model){
        List<SysPermission> sysPermissions = sysPermissionService.findMenus();
        model.addAttribute("sysPermissions",sysPermissions);
        return "permissionInfoAdd";
    }

    /**
     * 权限删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }

    @RequestMapping("/findAllSysPermission")
    @ResponseBody
    public JSONObject findAllsysPermission(@RequestParam int page, @RequestParam int rows){
        /**
         * 分页查找数据
         */
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page-1, rows, sort);
        Page<SysPermission> permissionList = sysPermissionService.findAll(pageable);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",permissionList.getTotalElements());
        System.out.println(permissionList.getContent());
        for (SysPermission sysPermission : permissionList.getContent()) {
            sysPermission.setRoles(null);
        }
        jsonObject.put("rows",permissionList.getContent());
        return jsonObject;
    }

    @RequestMapping("/submitPermissionAdd")
    @ResponseBody
    public String submitPermissionAdd(SysPermission sysPermission){
        String status = ConstantUtil.FAIlED;
        try {
            sysPermission.setAvailable(true);
            String resourceType = sysPermission.getResourceType();
            if("menu".equals(resourceType)){
                sysPermission.setParentId(0L);
                sysPermission.setParentIds("0/");
            }else if("button".equals(resourceType)){
                sysPermission.setParentIds("0/"+sysPermission.getParentId());
            }
            sysPermissionService.save(sysPermission);
            status = ConstantUtil.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }
//
//    @RequestMapping("/userDelete")
//    @ResponseBody
//    public String userDelete(int delId){
//        String status = ConstantUtil.FAIlED;
//        try {
//            userInfoService.delete(delId);
//            status = ConstantUtil.SUCCESS;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//       return status;
//    }

}
