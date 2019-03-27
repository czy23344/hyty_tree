package com.hyty.tree.treejiegou.dao;

import com.hyty.tree.treejiegou.entity.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by czy on 2019/3/22.
 */
@Repository
public interface PersonnelDao extends JpaRepository<Personnel, String>, JpaSpecificationExecutor<Personnel> {
}
