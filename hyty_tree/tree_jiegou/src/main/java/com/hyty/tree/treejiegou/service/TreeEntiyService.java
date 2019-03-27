package com.hyty.tree.treejiegou.service;

import com.hyty.tree.treejiegou.entity.TreeEntiy;

import java.util.List;

/**
 * Created by czy on 2019/3/22.
 */
public interface TreeEntiyService {
    /**
     * 保存节点
     * @return TreeEntiy
     * @throws Exception
     */
    TreeEntiy saveorupload(TreeEntiy treeEntiy)throws Exception;

    /**
     * 查询树形结构
     * @return list
     * @throws Exception
     */
    List<TreeEntiy> select()throws Exception;
    /**
     * 查询所有本级节点
     *
     * @return list
     * @throws Exception
     */
    List<TreeEntiy> selectCode(String superiorcode) throws Exception;

    /**
     * 查询所有组织架构
     * @param treeEntiy
     * @return
     * @throws Exception
     */
     List selectone(String code) throws Exception;
}
