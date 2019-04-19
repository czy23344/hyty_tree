package com.hyty.tree.treejiegou.service;

import com.hyty.tree.treejiegou.entity.BusinessModule;
import com.hyty.tree.treejiegou.entity.BusinessSystem;

import java.util.List;

/**
 * Created by WangHK on 2019/4/1.
 * 业务系统Service
 */
public interface BusinessSystemService {

    /**
     * 新增/修改 业务系统
     * @param businessSystem
     * @return
     */
    BusinessSystem saveSystem(BusinessSystem businessSystem) throws Exception;

    /**
     * 新增/修改 业务系统与业务模块_头体信息
     *
     * @param module
     * @return
     */
    BusinessModule saveModule(BusinessModule module) throws Exception;
    /**
     * 查询所有 业务系统
     * @return
     */
    List<BusinessSystem> selectAll() throws Exception;

    /**
     * 根据Id 查询业务系统
     * @param id
     * @return
     */
    BusinessSystem selectSystem(String id) throws Exception;

    /**
     * 根据Id 删除业务系统
     * @param id
     * @return
     */
    boolean deleteSystem(String id) throws Exception;


}
