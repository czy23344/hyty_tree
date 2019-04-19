package com.hyty.tree.treejiegou.service;

import com.hyty.tree.treejiegou.entity.BusinessModule;
import com.hyty.tree.treejiegou.entity.RoleJurisdiction;

import java.util.List;

/**
 * Created by WangHK on 2019/4/1.
 * 业务模块Service
 */
public interface BusinessModuleService {

    /**
     * 新增/修改 员工与角色对应关系
     *
     * @param businessModule
     * @return
     * @throws Exception
     */
    BusinessModule saveModule(BusinessModule businessModule) throws Exception;

    /**
     *新增/保存 业务模块关联角色权限_头体对应关系
     *
     * @param role
     * @return
     */
    RoleJurisdiction saveRoleJurisdiction(RoleJurisdiction role) throws Exception;

    /**
     * 查询所有业务模块
     * @return
     */
    List<BusinessModule> selectAll() throws Exception;

    /**
     * 根据Id 查询业务模块
     *
     * @param id
     * @return
     */
    BusinessModule selectModule(String id) throws Exception;

    /**
     * 根据Id 查询业务模块关联业务系统_头体对应关系
     *
     * @param id
     * @return
     */
    List<RoleJurisdiction> selectRole(String id) throws Exception;

    /**
     * 根据Id 删除业务模块信息
     *
     * @param id
     * @return
     */
    boolean deleteModule(String id) throws Exception;

    /**
     * 根据Id 删除业务模块关联业务系统_头体对应关系
     *
     * @param id
     * @return
     */
    boolean deleteRole(String id) throws Exception;


}
