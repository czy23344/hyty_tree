package com.hyty.tree.treejiegou.controller;

import com.alibaba.fastjson.JSON;
import com.hyty.tree.treejiegou.entity.TreeEntiy;
import com.hyty.tree.treejiegou.service.TreeEntiyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by czy on 2019/3/22.
 */
@RestController
@RequestMapping("/tree")
public class TreeController {
    @Autowired
    TreeEntiyService treeEntiyService;

    /**
     * 保存组织架构节点
     *
     * @param treeEntiy 组织结构实体
     * @return JSON
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public Object saveupload(TreeEntiy treeEntiy) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Object entiy = treeEntiyService.saveorupload(treeEntiy);
            if(entiy!=null){
                resultMap.put("result", true);
                resultMap.put("entiy", entiy);
                resultMap.put("message", "保存成功");
                return JSON.toJSONString(resultMap);
            }else{
                resultMap.put("result", false);
                resultMap.put("message", "保存失败，自动生成code出错");
                return JSON.toJSONString(resultMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result", false);
            resultMap.put("message", "保存失败");
            return JSON.toJSONString(resultMap);
        }
    }
}
