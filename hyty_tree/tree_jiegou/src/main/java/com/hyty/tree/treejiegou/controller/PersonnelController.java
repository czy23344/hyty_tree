package com.hyty.tree.treejiegou.controller;

import com.alibaba.fastjson.JSON;
import com.hyty.tree.treejiegou.entity.Personnel;
import com.hyty.tree.treejiegou.service.PsersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by czy on 2019/3/25.
 */
@RestController
@RequestMapping(value = "/per")
public class PersonnelController {
    @Autowired
    PsersonnelService psersonnelService;

    /**
     * 保存员工实体
     *
     * @param personnel 员工实体
     * @return JSON
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object savePersonnel(Personnel personnel) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            psersonnelService.savePesersonnel(personnel);
            resultMap.put("result", "true");
            resultMap.put("msg", "保存成功");
            return JSON.toJSONString(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result", "false");
            resultMap.put("msg", "保存失败");
            return JSON.toJSONString(resultMap);
        }
    }

    /**
     * 保存员工实体
     *
     * @param
     * @return JSON
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public Object selectPersonnel(String id) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            List<String> list = psersonnelService.selectPesersonnle(id);
            resultMap.put("result", "true");
            resultMap.put("msg", "查询成功");
            resultMap.put("value", list);
            return JSON.toJSONString(resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result", "false");
            resultMap.put("msg", "保存失败");
            return JSON.toJSONString(resultMap);
        }
    }
}
