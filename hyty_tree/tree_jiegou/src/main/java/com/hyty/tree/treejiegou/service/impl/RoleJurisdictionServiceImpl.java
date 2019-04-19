package com.hyty.tree.treejiegou.service.impl;


import com.hyty.tree.treejiegou.dao.BusinessModuleDao;
import com.hyty.tree.treejiegou.dao.PersonnelDao;
import com.hyty.tree.treejiegou.dao.RoleJurisdictionDao;
import com.hyty.tree.treejiegou.entity.BusinessModule;
import com.hyty.tree.treejiegou.entity.Personnel;
import com.hyty.tree.treejiegou.entity.RoleJurisdiction;
import com.hyty.tree.treejiegou.service.RoleJurisdictionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Whk on 2019/3/29.
 * 角色与权限对应关系Impl
 */
@Service
@Transactional
public class RoleJurisdictionServiceImpl implements RoleJurisdictionService {
    @Autowired
    RoleJurisdictionDao roleJurisdictionDao;
    @Autowired
    PersonnelDao personnelDao;
    @Autowired
    BusinessModuleDao businessModuleDao;

    /**
     * 新增/修改 员工角色
     *
     * @param roleJurisdiction
     * @return
     * @throws Exception
     */
    @Override
    public RoleJurisdiction saveRoleJurisdiction(RoleJurisdiction roleJurisdiction) throws Exception {
        return roleJurisdictionDao.save(roleJurisdiction);
    }

    /**
     * 新增/修改 角色权限关联企业员工_头体对应关系
     *
     * @param personnel
     * @return
     * @throws Exception
     */
    @Override
    public Personnel savePersonnel(Personnel personnel) throws Exception {
        if (personnel.getRoleJurisdictionId() != null && personnel.getRoleJurisdictionId() != "") {
            RoleJurisdiction roleJurisdiction = roleJurisdictionDao.findById(personnel.getRoleJurisdictionId()).get();
            if (roleJurisdiction != null) {
                personnel.setRoleJurisdiction(roleJurisdiction);
                Personnel personnel1 = personnelDao.save(personnel);
                return personnel1;
            }
        }
        return null;
    }

/*    *//**
     * 新增/修改 角色权限与业务模块_头体对应关系
     *
     * @param module
     * @return
     * @throws Exception
     *//*
    @Override
    public BusinessModule savebusinessModule(BusinessModule module) throws Exception {
        if (module.getRoleJurisdictionId() != null && module.getRoleJurisdictionId() != "") {
            RoleJurisdiction roleJurisdiction = roleJurisdictionDao.findById(module.getRoleJurisdictionId()).get();
            if (roleJurisdiction != null) {
                module.setRoleJurisdictions(roleJurisdiction);
                BusinessModule module1 = businessModuleDao.save(module);
                return module1;
            }
        }
        return null;
    }*/

    /**
     * 查询所有员工角色
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<RoleJurisdiction> selectAll() throws Exception {
        return roleJurisdictionDao.findAll();
    }

    /**
     * 根据Id 查询员工角色对应关系信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public RoleJurisdiction selectRoleJurisdiction(String id) throws Exception {
        return roleJurisdictionDao.findById(id).get();
    }

    /**
     * 根据id 查询角色权限与企业员工对应关系
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<Personnel> selectPersonnel(String id) throws Exception {
        Specification<Personnel> select = sSystemRole(id);
        return personnelDao.findAll(select);
    }

    public Specification<Personnel> sSystemRole(String id) {
        return (root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            Predicate p = null;
            Join<Personnel, RoleJurisdiction> roleJurisdictionJoin =
                    root.join(root.getModel().getSingularAttribute
                            ("roleJurisdiction", RoleJurisdiction.class), JoinType.INNER);
            if (StringUtils.isNotBlank(id)) {
                Predicate p3 = cb.equal(roleJurisdictionJoin.get("id").as(String.class), id);
                if (p != null) {
                    p = cb.and(p, p3);
                } else {
                    p = p3;
                }
            }
            if (p != null) {
                list.add(p);
            }
            Predicate[] pre = new Predicate[list.size()];
            return query.where(list.toArray(pre)).getRestriction();
        };
    }

    /**
     * 根据id 查询角色权限关联业务功能_头体对应关系
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<BusinessModule> selectBusinessModule(String id) throws Exception {
        Specification<BusinessModule> select = sFunctions(id);
        return businessModuleDao.findAll(select);
    }

    public Specification<BusinessModule> sFunctions(String id) {
        return (root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            Predicate p = null;
            Join<BusinessModule, RoleJurisdiction> roleJurisdictionJoin =
                    root.join(root.getModel().getSingularAttribute
                            ("roleJurisdiction", RoleJurisdiction.class), JoinType.INNER);
            if (StringUtils.isNotBlank(id)) {
                Predicate p3 = cb.equal(roleJurisdictionJoin.get("id").as(String.class), id);
                if (p != null) {
                    p = cb.and(p, p3);
                } else {
                    p = p3;
                }
            }
            if (p != null) {
                list.add(p);
            }
            Predicate[] pre = new Predicate[list.size()];
            return query.where(list.toArray(pre)).getRestriction();
        };
    }

    /**
     * 根据Id 删除员工角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteRoleJurisdiction(String id) throws Exception {
        if (id != null && id != "") {
            roleJurisdictionDao.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据Id 删除角色权限关联企业员工_头体对应关系
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deletePersonnel(String id) throws Exception {
        if (id != null && id != "") {
            personnelDao.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * 根据Id 删除角色权限与业务功能_头体对应关系
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteModule(String id) throws Exception {
        if (id != null && id != "") {
            businessModuleDao.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * 构建分页参数
     *
     * @param pageNumber 当前页数
     * @param pageSize   每页条数
     * @return 分页参数
     */
    private PageRequest buildPageRequest(int pageNumber, int pageSize) {
        return PageRequest.of(pageNumber - 1, pageSize);
    }
}

