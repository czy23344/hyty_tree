package com.hyty.tree.treejiegou.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by czy on 2019/3/22.
 */
@Entity
public class Personnel implements Serializable {
    /**
     * 主键
     */
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(length = 32, unique = true)
    private String id;

    /**
     * 员工编号
     */
    @Column(name = "CODE", length = 200)
    private String code;
    /**
     * 员工名称
     */
    @Column(name = "NAME", length = 200)
    private String name;
    /**
     * 创建时间
     */
    @Column(name = "TS", length = 50)
    private String ts;
    /**
     * 与用户表关联
     */
    @JoinColumn(name = "treeentiy_id")
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private TreeEntiy treeentiy;
    /**
     * 树形结构节点ID
     */
    @Transient
    private String treeId;

    /**
     * 与角色权限关联
     * @return
     */
    @JSONField(serialize = false)
    @ManyToMany ( mappedBy = "personnels" ,cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private Set<RoleJurisdiction> roleJurisdictions = new HashSet<>();



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public TreeEntiy getTreeentiy() {
        return treeentiy;
    }

    public void setTreeentiy(TreeEntiy treeentiy) {
        this.treeentiy = treeentiy;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public Set<RoleJurisdiction> getRoleJurisdictions() {
        return roleJurisdictions;
    }

    public void setRoleJurisdictions(Set<RoleJurisdiction> roleJurisdictions) {
        this.roleJurisdictions = roleJurisdictions;
    }
}
