package com.hyty.tree.treejiegou.controller;

import com.alibaba.fastjson.JSON;
import com.hyty.tree.treejiegou.entity.BusinessModule;
import com.hyty.tree.treejiegou.entity.BusinessSystem;
import com.hyty.tree.treejiegou.service.BusinessSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WangHK on 2019/4/1.
 * 业务系统Controller
 */
@RestController
@RequestMapping(value = "/system")
public class BusinessSystemController {
    @Autowired
    BusinessSystemService businessSystemService;

    /**
     * 新增/修改 业务系统
     *
     * @param businessSystem
     * @return staffRole实体
     */
    @RequestMapping(value = "/savesystem", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object saveSystem(BusinessSystem businessSystem) {
        Map<String, Object> map = new HashMap<>();
        try {
            BusinessSystem businessSystem1 = businessSystemService.saveSystem(businessSystem);
            map.put("result", true);
            map.put("value", businessSystem1);
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
     * 新增/保存 业务系统与业务模块_头体信息
     *
     * @param module
     * @return
     */
    @RequestMapping(value = "/savemodule", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object saveModule(BusinessModule module) {
        Map<String, Object> map = new HashMap<>();
        try {
            BusinessModule module2 = businessSystemService.saveModule(module);
            map.put("result", true);
            map.put("value",module2);
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
     * 查询所有 业务系统
     *
     * @param businessSystem
     * @return Json
     */
    @RequestMapping(value = "/selectall", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object selectAll(BusinessSystem businessSystem) {
        Map<String, Object> map = new HashMap<>();
        try {
            List<BusinessSystem> list = businessSystemService.selectAll();
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
     * 根据Id 查询业务系统
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectsystem", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object selectSystem(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            BusinessSystem businessSystem = businessSystemService.selectSystem(id);
            map.put("result", true);
            map.put("value", businessSystem);
            map.put("msg", "查询成功");
            return JSON.toJSONString(map);
        } catch (Exception e) {
            map.put("result", true);
            map.put("msg", "查询成功");
            return JSON.toJSONString(map);
        }
    }

    /**
     * 根据Id 删除业务系统
     *
     * @param id
     * @return
     * @RequestParam
     */
    @RequestMapping(value = "/deletesystem", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object deleteSystem(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            boolean businessSystem = businessSystemService.deleteSystem(id);
            if (businessSystem) {
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
}

