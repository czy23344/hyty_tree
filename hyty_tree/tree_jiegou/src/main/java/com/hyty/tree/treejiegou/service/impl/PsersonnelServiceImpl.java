package com.hyty.tree.treejiegou.service.impl;

import com.hyty.tree.treejiegou.dao.PersonnelDao;
import com.hyty.tree.treejiegou.dao.TreeEntiyDao;
import com.hyty.tree.treejiegou.entity.Personnel;
import com.hyty.tree.treejiegou.entity.TreeEntiy;
import com.hyty.tree.treejiegou.service.PsersonnelService;
import com.hyty.tree.treejiegou.service.TreeEntiyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * Created by czy on 2019/3/25.
 */
@Service
@Transactional
public class PsersonnelServiceImpl implements PsersonnelService {
    @Autowired
    TreeEntiyDao treeEntiyDao;
    @Autowired
    PersonnelDao personnelDao;
    @Autowired
    TreeEntiyService treeEntiyService;

    /**
     * 保存员工与树形结构建立关系
     *
     * @param personnel
     * @return String
     * @throws Exception
     */
    @Override
    public String savePesersonnel(Personnel personnel) throws Exception {
        //查询出树形节点实体
        TreeEntiy entiy = treeEntiyDao.findById(personnel.getTreeId()).get();
        //初始化时间格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        //保存录入时间
        personnel.setTs(date);
        //建立一对多关系
        personnel.setTreeentiy(entiy);
        this.personnelDao.save(personnel);
        return "true";
    }

    @Override
    public List selectPesersonnle(String id) throws Exception {
        List<String> list = new ArrayList<>();
        //查询员工
        Personnel personnel = personnelDao.findById(id).get();
        //找到当前所处节点
        TreeEntiy treeEntiy = personnel.getTreeentiy();
        List<TreeEntiy> treeEntiys =treeEntiyService.selectone(treeEntiy.getCode());
        for(TreeEntiy treeEntiy1 :treeEntiys){
            list.add(treeEntiy1.getName());
        }
        Collections.reverse(list);
        return list;
    }


}
