package com.hyty.tree.treejiegou.dao;

import com.hyty.tree.treejiegou.entity.BusinessSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by WangHK on 2019/4/1.
 * 业务系统Dao
 */
public interface BusinessSystemDao extends JpaRepository<BusinessSystem, String>, JpaSpecificationExecutor<BusinessSystem> {
}
