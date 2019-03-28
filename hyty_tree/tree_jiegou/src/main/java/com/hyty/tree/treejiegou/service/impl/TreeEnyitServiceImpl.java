package com.hyty.tree.treejiegou.service.impl;

import com.hyty.tree.treejiegou.dao.TreeEntiyDao;
import com.hyty.tree.treejiegou.entity.TreeEntiy;
import com.hyty.tree.treejiegou.service.TreeEntiyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/3/22.
 */
@Service
@Transactional
public class TreeEnyitServiceImpl implements TreeEntiyService {
    @Autowired
    TreeEntiyDao entiyDao;
    private static final List<TreeEntiy> treeEntiyList = new ArrayList<>();

    @Override
    public Object saveorupload(TreeEntiy treeEntiy) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        String founder = "测试demo";
        treeEntiy.setState("1");
        treeEntiy.setFounder(founder);
        treeEntiy.setFounderts(date);
        String code = this.saveservice(treeEntiy);
        if(code!=null){
            treeEntiy.setCode(this.saveservice(treeEntiy));
        }else{
            return null;
        }
        TreeEntiy t =entiyDao.save(treeEntiy);
        return t;
    }

    @Override
    public List<TreeEntiy> select() throws Exception {
        return null;
    }

    /**
     * 本节点编码生成规则
     *
     * @param entiy
     * @return
     */
    public String saveservice(TreeEntiy entiy) throws Exception {
        List<Integer> code = new ArrayList<>();
        //如果上级编码为初始化1的话
        if (entiy.getSuperiorcode().equals("1")) {
            //在上级节点基础上查询所有本节点的code
            List<TreeEntiy> treeEntiys = this.selectCode(entiy.getSuperiorcode());
            //如果能查询到集团下有子集团
            if (treeEntiys.size() > 0) {
                for (TreeEntiy entiy1 : treeEntiys) {
                    code.add(Integer.valueOf(entiy1.getCode()));
                }
                //取到最大值+1 为新生成的code
                String number = String.valueOf(Collections.max(code) + 1);
                return number;
            } else {
                return entiy.getSuperiorcode() + "001";
            }

        }//先判断传入的上级节点是否等于null
        else if (entiy.getSuperiorcode() != null) {
            //在上级节点基础上查询所有本节点的code
            List<TreeEntiy> treeEntiys = this.selectCode(entiy.getSuperiorcode());
            if (treeEntiys.size() > 0) {
                for (TreeEntiy entiy1 : treeEntiys) {
                    code.add(Integer.valueOf(entiy1.getCode()));
                }
                //取到最大值+1 为新生成的code
                String number = String.valueOf(Collections.max(code) + 1);
                return number;
            } else {
                return entiy.getSuperiorcode() + "001";
            }
        }
        return null;
    }

    /**
     * 查询本节点为code的节点
     *
     * @return list
     * @throws Exception
     */
    public List<TreeEntiy> selectoneCode(String code) throws Exception {
        Specification<TreeEntiy> select = selectlocode(code);
        return entiyDao.findAll(select);
    }

    public Specification<TreeEntiy> selectlocode(String code) {
        //封装查询条件
        return (root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            Predicate p = null;
            //本节点code
            if (StringUtils.isNotBlank(code)) {
                Predicate p3 = cb.equal(root.get("code").as(String.class), code);
                if (p != null) {
                    p = cb.and(p, p3);
                } else {
                    p = p3;
                }
            }
            Predicate p1 = cb.equal(root.get("state").as(String.class), "1");
            if (p != null) {
                p = cb.and(p, p1);
            } else {
                p = p1;
            }
            if (p != null) {
                list.add(p);
            }
            Predicate[] pre = new Predicate[list.size()];
            return query.where(list.toArray(pre)).getRestriction();
        };
    }

    /**
     * 查询所有上级节点为superiorcode的子节点
     *
     * @return list
     * @throws Exception
     */
    @Override
    public List<TreeEntiy> selectCode(String superiorcode) throws Exception {
        Specification<TreeEntiy> select = select(superiorcode);
        return entiyDao.findAll(select);
    }

    public Specification<TreeEntiy> select(String superiorcode) {
        //封装查询条件
        return (root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            Predicate p = null;
            //上级节点
            if (StringUtils.isNotBlank(superiorcode)) {
                Predicate p3 = cb.equal(root.get("superiorcode").as(String.class), superiorcode);
                if (p != null) {
                    p = cb.and(p, p3);
                } else {
                    p = p3;
                }
            }
            Predicate p1 = cb.equal(root.get("state").as(String.class), "1");
            if (p != null) {
                p = cb.and(p, p1);
            } else {
                p = p1;
            }
            if (p != null) {
                list.add(p);
            }
            Predicate[] pre = new Predicate[list.size()];
            return query.where(list.toArray(pre)).getRestriction();
        };
    }

    public void selecttwo(String code) throws Exception {
        if (code != null) {
            //查询到上级节点的实体
            TreeEntiy entiy = this.selectoneCode(code).get(0);
            //添加到全局集合中
            treeEntiyList.add(entiy);
            //判断是否还有上级节点的存在
            if (entiy.getSuperiorcode() != null) {
                //存在继续查询
                this.selecttwos(entiy.getSuperiorcode());
            }
        }
    }
    public void selecttwos(String code) throws Exception {
        if (code != null) {
            //查询到节点的实体
            TreeEntiy entiy = this.selectoneCode(code).get(0);
            //添加到全局集合中
            treeEntiyList.add(entiy);
            //判断是否还有上级节点的存在
            if (entiy.getSuperiorcode() != null) {
                //存在继续查询
                this.selecttwo(entiy.getSuperiorcode());
            }
        }
    }
    @Override
    public synchronized List selectone(String code) throws Exception {
        List<TreeEntiy> treeEntiys = new ArrayList<>();
        //查询到当前实体
        TreeEntiy entiy = this.selectoneCode(code).get(0);
        //把当前实体添加到集合中
        treeEntiyList.add(entiy);
        //判断是否还需要查询上级节点
        if (entiy.getSuperiorcode() != null) {
            //进入到查询上级节点
            this.selecttwo(entiy.getSuperiorcode());
        }
        for (TreeEntiy treeEntiy1 : treeEntiyList) {
            treeEntiys.add(treeEntiy1);
        }
        treeEntiyList.clear();
        return treeEntiys;
    }


}
