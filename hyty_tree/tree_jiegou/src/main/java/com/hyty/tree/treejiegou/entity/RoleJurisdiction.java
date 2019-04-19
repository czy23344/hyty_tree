package com.hyty.tree.treejiegou.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Whk on 2019/3/28.
 * 角色权限表
 * 本表头信息(多)与体信息:系统角色表(多)关联
 * 本表头信息(一)与体信息:业务模块表(多)关联
 */
@Entity
public class RoleJurisdiction implements Serializable {
    /**
     * 主键
     */
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(length = 32, unique = true)
    private String id;
    /**
     * 1.角色标识
     */
    @Column(name = "ROLELOGO", length = 200)
    private String roleLogo;
    /**
     * 2.多对一---角色编号
     */
    @NotNull(message = "角色编号不能为空")
    @Column(name = "ROLENUMBER", length = 200)
    private String roleNumber;
    /**
     * 3.权限标识
     */
    @Column(name = "JURISDICTIONLOGO", length = 200)
    private String JurisdictionLogo;
    /**
     * 4.权限编号+++一对多
     */
    @Column(name = "JURISDICTIONNUMBER", length = 200)
    private String JurisdictionNumber;

    /**
     * 角色权限(多)与企业员工(多)_关联
     */
//    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
//    private Set<Personnel> personnels = new HashSet<>();


    /**
     * 本表(角色权限表):头信息(一)
     * 头信息:业务系统表(一)与体信息:业务模块表(多)关联
     */
    @JoinColumn(name = "businessModule_id")
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private BusinessModule businessModule;

    @Transient
    private String businessModuleId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleLogo() {
        return roleLogo;
    }

    public void setRoleLogo(String roleLogo) {
        this.roleLogo = roleLogo;
    }

    public String getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(String roleNumber) {
        this.roleNumber = roleNumber;
    }

    public String getJurisdictionLogo() {
        return JurisdictionLogo;
    }

    public void setJurisdictionLogo(String jurisdictionLogo) {
        JurisdictionLogo = jurisdictionLogo;
    }

    public String getJurisdictionNumber() {
        return JurisdictionNumber;
    }

    public void setJurisdictionNumber(String jurisdictionNumber) {
        JurisdictionNumber = jurisdictionNumber;
    }

    public BusinessModule getBusinessModule() {
        return businessModule;
    }

    public void setBusinessModule(BusinessModule businessModule) {
        this.businessModule = businessModule;
    }

    public String getBusinessModuleId() {
        return businessModuleId;
    }

    public void setBusinessModuleId(String businessModuleId) {
        this.businessModuleId = businessModuleId;
    }

//    public Set<Personnel> getPersonnels() {
//        return personnels;
//    }
//
//    public void setPersonnels(Set<Personnel> personnels) {
//        this.personnels = personnels;
//    }
}
