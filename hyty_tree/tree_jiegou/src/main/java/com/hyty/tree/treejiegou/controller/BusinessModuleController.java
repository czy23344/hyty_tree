package com.hyty.tree.treejiegou.controller;


import com.alibaba.fastjson.JSON;
import com.hyty.tree.treejiegou.entity.BusinessModule;
import com.hyty.tree.treejiegou.entity.RoleJurisdiction;
import com.hyty.tree.treejiegou.service.BusinessModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WangHK on 2019/4/1.
 * 业务模块Controller
 */
@RestController
@RequestMapping(value = "/mod")
public class BusinessModuleController {
    @Autowired
    BusinessModuleService businessModuleService;

    /**
     * 新增/修改 业务模块
     *
     * @param businessModule
     * @return businessModuleService实体
     */
    @RequestMapping(value = "/savemodele", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object saveModele(BusinessModule businessModule) {
        Map<String, Object> map = new HashMap<>();
        try {
            BusinessModule businessModule1 = businessModuleService.saveModule(businessModule);
            map.put("result", true);
            map.put("value", businessModule1);
            map.put("msg", "保存成功");
            return JSON.toJSONString(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", false);
            map.put("msg", "保存失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 新增/保存 业务模块关联角色权限_头体对应关系
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/saverole", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object saveRoleJurisdiction(RoleJurisdiction role) {
        Map<String, Object> map = new HashMap<>();
        try {
            RoleJurisdiction role2 = businessModuleService.saveRoleJurisdiction(role);
            map.put("result", true);
            map.put("value",role2);
            map.put("msg", "保存成功");
            return JSON.toJSONString(map);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", false);
            map.put("msg", "保存失败,异常处理");
            return JSON.toJSONString(map);
        }
    }

    /**
     * 查询所有 业务模块
     *
     * @param businessModule
     * @return Json
     */
    @RequestMapping(value = "/selectall", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object selectAll(BusinessModule businessModule) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<BusinessModule> list = businessModuleService.selectAll();
            map.put("result", true);
            map.put("value", list);
            map.put("msg", "查询成功");
            return JSON.toJSONString(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", false);
            map.put("msg", "查询失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 根据Id 查询业务模块
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectmodele", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object selectModule(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            BusinessModule businessModule = businessModuleService.selectModule(id);
            map.put("result", true);
            map.put("value", businessModule);
            map.put("msg", "查询成功");
            return JSON.toJSONString(map);
        } catch (Exception e) {
            map.put("result", true);
            map.put("msg", "查询成功");
            return JSON.toJSONString(map);
        }
    }

/**
     * 根据Id 查询业务模块关联角色权限_头体对应关系
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectrole", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object selectRole(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<RoleJurisdiction> role = businessModuleService.selectRole(id);
            map.put("result", true);
            map.put("value", role);
            map.put("msg", "查询成功");
            return JSON.toJSONString(map);
        } catch (Exception e) {
            map.put("result", true);
            map.put("msg", "查询成功");
            return JSON.toJSONString(map);
        }
    }


    /**
     * 根据Id 删除业务模块信息
     *
     * @param id
     * @return
     * @RequestParam
     */
    @RequestMapping(value = "/deletemodule", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object deleteModule(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            boolean businessModule = businessModuleService.deleteModule(id);
            if (businessModule) {
                map.put("result", true);
                map.put("msg", "删除成功");
                return JSON.toJSONString(map);
            } else {
                map.put("result", false);
                map.put("msg", "删除失败，检查ID是否表内存在");
                return JSON.toJSONString(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", false);
            map.put("msg", "删除失败, 系统异常");
            return JSON.toJSONString(map);
        }
    }

    /**
     * 根据Id 删除业务模块关联业务系统_头体对应关系
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleterole", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object deleteRole(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            boolean role = businessModuleService.deleteRole(id);
            if (role) {
                map.put("result", true);
                map.put("mag", "删除成功");
                return JSON.toJSONString(map);
            }
            map.put("result", false);
            map.put("mag", "删除失败,检查ID是否表内存在");
            return JSON.toJSONString(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", false);
            map.put("mag", "删除失败,系统异常");
            return JSON.toJSONString(map);
        }
    }
}

