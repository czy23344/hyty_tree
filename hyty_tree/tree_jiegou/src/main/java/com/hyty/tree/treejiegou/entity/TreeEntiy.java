package com.hyty.tree.treejiegou.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by czy on 2019/3/22.
 */
@Entity
public class TreeEntiy implements Serializable {
    /**
     * 主键
     */
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(length = 32, unique = true)
    private String id;
    /**
     * 节点编号
     */
    @NotNull(message = "节点编号不能为空")
    @Column(name = "CODE", length = 200)
    private String code;
    /**
     * 节点名称
     */
    @NotNull(message = "节点名称名称不能为空")
    @Column(name = "NAME", length = 200)
    private String name;

    /**
     * 上级节点编号
     */
    @Column(name = "SUPERIOR_CODE", length = 200)
    private String superiorcode;

    /**
     * 状态（1 启用 0 禁用或删除）
     */
    @Column(name = "STATE", length = 10)
    private String state;
    /**
     * 创建人
     */
    @Column(name = "FOUNDER", length = 200)
    private String founder;

    /**
     * 创建时间
     */
    @Column(name = "FOUNDER_TS", length = 200)
    private String founderts;

    /**
     * 与员工关联
     */
    @JSONField(serialize = false)
    @OneToMany(mappedBy = "treeentiy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Personnel> personnels = new HashSet<>(0);


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

    public String getSuperiorcode() {
        return superiorcode;
    }

    public void setSuperiorcode(String superiorcode) {
        this.superiorcode = superiorcode;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getFounderts() {
        return founderts;
    }

    public void setFounderts(String founderts) {
        this.founderts = founderts;
    }

    public Set<Personnel> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(Set<Personnel> personnels) {
        this.personnels = personnels;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
