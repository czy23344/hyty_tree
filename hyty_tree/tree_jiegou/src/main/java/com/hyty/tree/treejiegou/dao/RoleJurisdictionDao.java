package com.hyty.tree.treejiegou.dao;

import com.hyty.tree.treejiegou.entity.RoleJurisdiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Whk on 2019/3/29.
 * 角色与权限对应关系Dao
 */
@Repository
public interface RoleJurisdictionDao extends JpaRepository<RoleJurisdiction, String>, JpaSpecificationExecutor<RoleJurisdiction> {
}
