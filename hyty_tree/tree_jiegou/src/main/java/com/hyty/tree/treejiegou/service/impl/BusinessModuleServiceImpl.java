package com.hyty.tree.treejiegou.service.impl;


import com.hyty.tree.treejiegou.dao.BusinessModuleDao;
import com.hyty.tree.treejiegou.dao.BusinessSystemDao;
import com.hyty.tree.treejiegou.dao.RoleJurisdictionDao;
import com.hyty.tree.treejiegou.entity.BusinessModule;
import com.hyty.tree.treejiegou.entity.RoleJurisdiction;
import com.hyty.tree.treejiegou.service.BusinessModuleService;
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
 * Created by WangHK on 2019/4/1.
 * 业务模块Impl
 */
@Service
@Transactional
public class BusinessModuleServiceImpl implements BusinessModuleService {
    @Autowired
    BusinessModuleDao businessModuleDao;
    @Autowired
    BusinessSystemDao businessSystemDao;
    @Autowired
    RoleJurisdictionDao roleJurisdictionDao;


    /**
     * 新增/修改 业务模块
     *
     * @param businessModule
     * @return
     * @throws Exception
     */
    @Override
    public BusinessModule saveModule(BusinessModule businessModule) throws Exception {
        return businessModuleDao.save(businessModule);
    }

    /**
     * 新增/保存 业务模块关联角色权限_头体对应关系
     *
     * @param role
     * @return
     */
    @Override
    public RoleJurisdiction saveRoleJurisdiction(RoleJurisdiction role) throws Exception{
        if (role.getBusinessModuleId() != null && role.getBusinessModuleId() != "") {
            BusinessModule module = businessModuleDao.findById(role.getBusinessModuleId()).get();
            if (module != null) {
                role.setBusinessModule(module);
                RoleJurisdiction role1 = roleJurisdictionDao.save(role);
                return role1;
            }
        }
        return null;
    }

    /**
     * 查询所有业务模块
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<BusinessModule> selectAll() throws Exception {
        return businessModuleDao.findAll();
    }

    /**
     * 根据Id 查询业务模块
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public BusinessModule selectModule(String id) throws Exception {
        return businessModuleDao.findById(id).get();
    }

    /**
     * 根据Id 查询业务模块关联业务系统_头体对应关系
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<RoleJurisdiction> selectRole(String id) throws Exception {
        Specification<RoleJurisdiction> select = sRole(id);
        return roleJurisdictionDao.findAll(select);
    }

    public Specification<RoleJurisdiction> sRole(String id) {
        return (root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            Predicate p = null;
            Join<RoleJurisdiction, BusinessModule> businessModuleJoin =
                    root.join(root.getModel().getSingularAttribute
                            ("businessModule", BusinessModule.class), JoinType.INNER);
            if (StringUtils.isNotBlank(id)) {
                Predicate p3 = cb.equal(businessModuleJoin.get("id").as(String.class), id);
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
     * 根据Id 删除业务模块信息
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
        } else {
            return false;
        }
    }

    /**
     * 根据Id 删除业务模块关联业务系统_头体对应关系
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteRole(String id) throws Exception {
        if (id != null && id != "") {
            roleJurisdictionDao.deleteById(id);
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
