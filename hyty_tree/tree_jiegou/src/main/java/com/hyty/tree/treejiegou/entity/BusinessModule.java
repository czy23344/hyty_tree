package com.hyty.tree.treejiegou.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Whk on 2019/3/28.
 * 业务模块表
 * 本表体信息(多)与头信息:业务功能表(一)关联
 * 本表头信息(一)与体信息:业务系统表(多)关联
 */
@Entity
public class BusinessModule implements Serializable {
    /**
     * 主键
     */
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(length = 32, unique = true)
    private String id;
    /**
     * 1.模块标识
     */
    @Column(name = "MODULELOGO", length = 200)
    private String ModuleLogo;
    /**
     * 2.多对一---模块编号
     */
    @NotNull(message = "模块编号不能为空")
    @Column(name = "BUSINESSNUMBER", length = 200)
    private String BusinessNumber;

    /**
     * 3.模块名称
     */
    @Column(name = "MODULENAME", length = 200)
    private String ModuleName;
    /**
     * 4.模块描述
     */
    @Column(name = "MODULEDESCRIPTION", length = 200)
    private String ModuleDescription;

/*    5.所属业务系统编号+++一对多

    @Column(name = "BUSINESSSYSTEMNUMBER", length = 200)
    private String BusinessSystemNumber;*/

    /**
     * 本表(业务系统表):体信息(一)
     * 体信息:业务模块表(一)与头信息:角色权限表(多)关联
     */
/*    @JoinColumn(name = "businessModule_id")
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private RoleJurisdiction roleJurisdiction;*/

    @JSONField(serialize = false)
    @OneToMany(mappedBy = "businessModule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RoleJurisdiction> roleJurisdictions = new HashSet<>(0);

    /**
     * 角色权限表Id
     */
    @Transient
    private String roleJurisdictionId;

    /**
     * 本表(业务系统表):体信息(多)
     * 体信息:业务模块表(多)与头信息:业务系统表(一)关联
     */
/*    @JoinColumn(name = "businessSystem_id")
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private BusinessSystem businessSystem;
    *//**
     * 业务系统表Id
     *//*
    @Transient
    private String businessSystemId;*/

    @JoinColumn(name = "businessSystem_id")
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private BusinessSystem businessSystem;

    @Transient
    private String businessSystemId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModuleLogo() {
        return ModuleLogo;
    }

    public void setModuleLogo(String moduleLogo) {
        ModuleLogo = moduleLogo;
    }

    public String getBusinessNumber() {
        return BusinessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        BusinessNumber = businessNumber;
    }

    public String getModuleName() {
        return ModuleName;
    }

    public void setModuleName(String moduleName) {
        ModuleName = moduleName;
    }

    public String getModuleDescription() {
        return ModuleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        ModuleDescription = moduleDescription;
    }

    public Set<RoleJurisdiction> getRoleJurisdictions() {
        return roleJurisdictions;
    }

    public void setRoleJurisdictions(Set<RoleJurisdiction> roleJurisdictions) {
        this.roleJurisdictions = roleJurisdictions;
    }

    public String getRoleJurisdictionId() {
        return roleJurisdictionId;
    }

    public void setRoleJurisdictionId(String roleJurisdictionId) {
        this.roleJurisdictionId = roleJurisdictionId;
    }

    public BusinessSystem getBusinessSystem() {
        return businessSystem;
    }

    public void setBusinessSystem(BusinessSystem businessSystem) {
        this.businessSystem = businessSystem;
    }

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId;
    }


}
