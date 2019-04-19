package com.hyty.tree.treejiegou.controller;

import com.alibaba.fastjson.JSON;
import com.hyty.tree.treejiegou.entity.BusinessModule;
import com.hyty.tree.treejiegou.entity.Personnel;
import com.hyty.tree.treejiegou.entity.RoleJurisdiction;
import com.hyty.tree.treejiegou.service.RoleJurisdictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Whk on 2019/3/29.
 * 角色与权限对应关系Controller
 */
@RestController
@RequestMapping(value = "/role")
public class RoleJurisdictionController {
    @Autowired
    RoleJurisdictionService roleJurisdictionService;

    /**
     * 新增/修改 角色权限
     *
     * @param roleJurisdiction
     * @return staffRole实体
     */
    @RequestMapping(value = "/saverolejurisdiction", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object saveRoleJurisdiction(RoleJurisdiction roleJurisdiction) {
        Map<String, Object> map = new HashMap<>();
        try {
            RoleJurisdiction roleJurisdiction1 = roleJurisdictionService.saveRoleJurisdiction(roleJurisdiction);
            map.put("result", true);
            map.put("value", roleJurisdiction1);
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
     * 新增/修改 角色权限关联企业员工_头体对应关系
     *
     * @param personnel
     * @return
     */
    @RequestMapping(value = "/savepersonnel", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object savePersonnel(Personnel personnel) {
        Map<String, Object> map = new HashMap<>();
        try {
            Personnel personnel1 = roleJurisdictionService.savePersonnel(personnel);
            map.put("result", true);
            map.put("value", personnel1);
            map.put("msg", "保存成功");
            return JSON.toJSONString(map);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", false);
            map.put("msg", "保存失败,异常处理");
            return JSON.toJSONString(map);
        }
    }

/*    *//**
     * 新增/修改 角色权限关联业务模块_头体对应关系
     *
     * @param module
     * @return
     *//*
    @RequestMapping(value = "/savemodule", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object savebusinessModule(BusinessModule module) {
        Map<String, Object> map = new HashMap<>();
        try {
            BusinessModule module1 = roleJurisdictionService.savebusinessModule(module);
            map.put("result", true);
            map.put("value", module1);
            map.put("msg", "保存成功");
            return JSON.toJSONString(map);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", false);
            map.put("msg", "保存失败,异常处理");
            return JSON.toJSONString(map);
        }
    }*/

    /**
     * 查询所有 角色权限
     *
     * @param roleJurisdiction
     * @return Json
     */
    @RequestMapping(value = "/selectall", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object selectAll(RoleJurisdiction roleJurisdiction) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<RoleJurisdiction> list = roleJurisdictionService.selectAll();
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
     * 根据Id 查询角色权限
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectrolejurisdiction", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object selectRoleJurisdiction(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            RoleJurisdiction roleJurisdiction = roleJurisdictionService.selectRoleJurisdiction(id);
            map.put("result", true);
            map.put("value", roleJurisdiction);
            map.put("msg", "查询成功");
            return JSON.toJSONString(map);
        } catch (Exception e) {
            map.put("result", true);
            map.put("msg", "查询成功");
            return JSON.toJSONString(map);
        }
    }

    /**
     * 根据id 查询角色权限关联企业员工_头体对应关系
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectpersonnel", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object selectPersonnel(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Personnel> list = roleJurisdictionService.selectPersonnel(id);
            map.put("result", true);
            map.put("value", list);
            map.put("msg", "查询成功");
            return JSON.toJSONString(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", true);
            map.put("msg", "查询失败");
            return JSON.toJSONString(map);
        }
    }

    /**
     * 根据id 查询角色权限关联业务功能_头体对应关系
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectmodule", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object selectBusinessModule(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<BusinessModule> list = roleJurisdictionService.selectBusinessModule(id);
            map.put("result", true);
            map.put("value", list);
            map.put("msg", "查询成功");
            return JSON.toJSONString(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", true);
            map.put("msg", "查询失败");
            return JSON.toJSONString(map);
        }
    }

    /**
     * 根据Id 删除角色权限
     *
     * @param id
     * @return
     * @RequestParam
     */
    @RequestMapping(value = "/deleterolejurisdiction", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object deleteRoleJurisdiction(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            boolean roleJurisdiction = roleJurisdictionService.deleteRoleJurisdiction(id);
            if (roleJurisdiction) {
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
     * 根据Id 删除角色权限关联企业员工_头体对应关系
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deletepersonnel", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object deletePersonnel(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            boolean personnel = roleJurisdictionService.deletePersonnel(id);
            if (personnel) {
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

    /**
     * 根据Id 删除角色权限关联业务模块_头体对应关系
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deletemodule", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object deleteModule(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            boolean module = roleJurisdictionService.deleteModule(id);
            if (module) {
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

