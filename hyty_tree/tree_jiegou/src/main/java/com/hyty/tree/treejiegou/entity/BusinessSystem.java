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
 * 业务系统表
 * 本表体信息(多)与头信息:业务模块表(一)关联
 */
@Entity
public class BusinessSystem implements Serializable {
    /**
     * 主键
     */
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(length = 32, unique = true)
    private String id;
    /**
     * 1.系统标识
     */
    @Column(name = "SYSTEMLOGO", length = 200)
    private String SystemLogo;
    /**
     * 2.---系统编号
     */
    @NotNull(message = "系统编号不能为空")
    @Column(name = "SYSTEMNUMBER", length = 200)
    private String SystemNumber;

    /**
     * 3.系统名称
     */
    @Column(name = "SYSTEMNAME", length = 200)
    private String SystemName;

    /**
     * 本表(业务模块表):头信息(一)
     * 头信息:业务系统表(一)与体信息:业务模块表(多)关联
     */
/*    @JSONField(serialize = false)
    @OneToMany(mappedBy = "businessSystem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BusinessModule businessModule;
    private Set<BusinessModule> businessModules = new HashSet<>(0);
    @Transient
    private String businessModuleId;*/

    @JSONField(serialize = false)
    @OneToMany(mappedBy = "businessSystem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private  BusinessModule businessModule;
    private Set<BusinessModule> businessModules = new HashSet<>(0);

    @Transient
    private String businessModuleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSystemLogo() {
        return SystemLogo;
    }

    public void setSystemLogo(String systemLogo) {
        SystemLogo = systemLogo;
    }

    public String getSystemNumber() {
        return SystemNumber;
    }

    public void setSystemNumber(String systemNumber) {
        SystemNumber = systemNumber;
    }

    public String getSystemName() {
        return SystemName;
    }

    public void setSystemName(String systemName) {
        SystemName = systemName;
    }

    public Set<BusinessModule> getBusinessModules() {
        return businessModules;
    }

    public void setBusinessModules(Set<BusinessModule> businessModules) {
        this.businessModules = businessModules;
    }

    public String getBusinessModuleId() {
        return businessModuleId;
    }

    public void setBusinessModuleId(String businessModuleId) {
        this.businessModuleId = businessModuleId;
    }

/*    public BusinessModule getBusinessModule() {
        return businessModule;
    }

    public void setBusinessModule(BusinessModule businessModule) {
        this.businessModule = businessModule;
    }*/
}
