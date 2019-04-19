package com.hyty.tree.treejiegou.service.impl;

import com.hyty.tree.treejiegou.dao.BusinessModuleDao;
import com.hyty.tree.treejiegou.dao.BusinessSystemDao;
import com.hyty.tree.treejiegou.entity.BusinessModule;
import com.hyty.tree.treejiegou.entity.BusinessSystem;
import com.hyty.tree.treejiegou.service.BusinessSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by WangHK on 2019/4/1.
 * 业务系统Impl
 */
@Service
@Transactional
public class BusinessSystemServiceImpl implements BusinessSystemService {
    @Autowired
    BusinessSystemDao businessSystemDao;
    @Autowired
    BusinessModuleDao businessModuleDao;

    /**
     * 新增/修改 业务系统
     *
     * @param businessSystem
     * @return
     * @throws Exception
     */
    @Override
    public BusinessSystem saveSystem(BusinessSystem businessSystem) throws Exception {
        return businessSystemDao.save(businessSystem);
    }

    /**
     * 新增/修改 业务模块关联业务系统_头体对应关系
     *
     * @param module
     * @return
     * @throws Exception
     */
    @Override
    public BusinessModule saveModule(BusinessModule module) throws Exception {
        if (module.getBusinessSystemId() != null && module.getBusinessSystemId() != "") {
            BusinessSystem system = businessSystemDao.findById(module.getBusinessSystemId()).get();
            if (system != null) {
                module.setBusinessSystem(system);
                BusinessModule module1 = businessModuleDao.save(module);
                return module1;
            }
        }
        return null;
    }

    /**
     * 查询所有员工与角色对应关系
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<BusinessSystem> selectAll() throws Exception {
        return businessSystemDao.findAll();
    }

    /**
     * 根据Id 查询员工与角色对应关系信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public BusinessSystem selectSystem(String id) throws Exception {
        return businessSystemDao.findById(id).get();
    }

    /**
     * 根据Id 删除员工与角色对应关系信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteSystem(String id) throws Exception {
        if (id != null && id != "") {
            businessSystemDao.deleteById(id);
            return true;
        } else {
            return false;
        }
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
