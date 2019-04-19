package com.hyty.tree.treejiegou.dao;

import com.hyty.tree.treejiegou.entity.BusinessModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by WangHK on 2019/4/1.
 * 业务模块Dao
 */
public interface BusinessModuleDao extends JpaRepository<BusinessModule, String>, JpaSpecificationExecutor<BusinessModule> {
}
