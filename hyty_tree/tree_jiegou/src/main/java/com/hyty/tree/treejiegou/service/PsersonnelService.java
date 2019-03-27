package com.hyty.tree.treejiegou.service;

import com.hyty.tree.treejiegou.entity.Personnel;

import java.util.List;

/**
 * Created by czy on 2019/3/25.
 */
public interface PsersonnelService {
    /**
     * 保存员工与树形结构建立关系
     * @param personnel
     * @return String
     * @throws Exception
     */
    String savePesersonnel(Personnel personnel)throws Exception;

    /**
     * 查询当前员工组织架构
     * @param id 员工编号
     * @return JSON
     * @throws Exception
     */
    List selectPesersonnle(String id)throws Exception;
}
