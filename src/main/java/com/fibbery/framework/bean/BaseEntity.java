package com.fibbery.framework.bean;

import com.fibbery.framework.vo.enums.StatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiangnenghua on 16/7/30.
 */
public class BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    /* ID */
    private Long id;

    /* 创建时间 */
    private Date createDate;

    /* 创建人员 */
    private Long createUser;

    /* 最后更新时间*/
    private Date lastUpdateDate;

    /* 最后更新人*/
    private Long lastUpdateUser;

    private StatusEnum status;

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
}
