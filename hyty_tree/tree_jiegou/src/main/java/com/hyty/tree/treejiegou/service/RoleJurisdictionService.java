package com.hyty.tree.treejiegou.service;

import com.hyty.tree.treejiegou.entity.BusinessModule;
import com.hyty.tree.treejiegou.entity.Personnel;
import com.hyty.tree.treejiegou.entity.RoleJurisdiction;

import java.util.List;

/**
 * Created by Whk on 2019/3/29.
 * 角色与权限对应关系Service
 */
public interface RoleJurisdictionService {

    /**
     * 新增/修改 角色权限
     */
    RoleJurisdiction saveRoleJurisdiction(RoleJurisdiction roleJurisdiction) throws Exception;

    /**
     * 新增/修改 角色权限关联企业员工_头体对应关系
     *
     * @param personnel
     * @return
     * @throws Exception
     */
    Personnel savePersonnel(Personnel personnel) throws Exception;

/*    *//**
     * 新增/修改 角色权限与业务模块_头体对应关系
     *
     * @param module
     * @return
     *//*
    BusinessModule savebusinessModule(BusinessModule module) throws Exception;*/

    /**
     * 查询所有 角色权限
     *
     * @return
     */
    List<RoleJurisdiction> selectAll() throws Exception;

    /**
     * 根据Id 查询角色权限
     *
     * @param id
     * @return
     */
    RoleJurisdiction selectRoleJurisdiction(String id) throws Exception;

    /**
     * 根据id 查询角色权限与系统角色对应关系
     *
     * @param id
     * @return
     */
    List<Personnel> selectPersonnel(String id) throws Exception;

    /**
     * 根据id 查询角色权限关联业务功能_头体对应关系
     *
     * @param id
     * @return
     */

    List<BusinessModule> selectBusinessModule(String id) throws Exception;

    /**
     * 根据Id 删除角色权限
     *
     * @param id
     * @return
     */
    boolean deleteRoleJurisdiction(String id) throws Exception;

    /**
     * 根据Id 删除角色权限关联企业员工_头体对应关系
     *
     * @param id
     * @return
     */
    boolean deletePersonnel(String id) throws Exception;

    /**
     * 根据Id 删除角色权限与业务功能_头体对应关系
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteModule(String id) throws Exception;
}
