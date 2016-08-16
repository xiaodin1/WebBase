package com.fibbery.framework.bean;

import com.fibbery.framework.vo.enums.StatusEnum;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(table = "sys_role",name = "id")
    private Long id;

    @Column(table = "sys_role",name = "create_date")
    private Date createDate;

    @Column(table = "sys_role",name = "create_user")
    private Long createUser;

    @Column(table = "sys_role",name = "last_update_date")
    private Date lastUpdateDate;

    @Column(table = "sys_role",name = "last_update_user")
    private Long lastUpdateUser;

    @Column(table = "sys_role",name = "status")
    private StatusEnum status;

    @Column(table = "sys_role",name = "name")
    private String name;

    @Column(table = "sys_role",name = "isAdmin")
    private Integer isadmin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(Long lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", lastUpdateDate=").append(lastUpdateDate);
        sb.append(", lastUpdateUser=").append(lastUpdateUser);
        sb.append(", status=").append(status);
        sb.append(", name=").append(name);
        sb.append(", isadmin=").append(isadmin);
        sb.append("]");
        return sb.toString();
    }
}