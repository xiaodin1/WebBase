package com.fibbery.ticket.bean;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class Station implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(table = "t_ticket_station",name = "id")
    private Long id;

    @Column(table = "t_ticket_station",name = "number")
    private Long number;

    @Column(table = "t_ticket_station",name = "shuangpin")
    private String shuangpin;

    @Column(table = "t_ticket_station",name = "quanpin")
    private String quanpin;

    @Column(table = "t_ticket_station",name = "jianpin")
    private String jianpin;

    @Column(table = "t_ticket_station",name = "wubi")
    private String wubi;

    @Column(table = "t_ticket_station",name = "name")
    private String name;

    @Column(table = "t_ticket_station",name = "create_date")
    private Date createDate;

    @Column(table = "t_ticket_station",name = "create_user")
    private Long createUser;

    @Column(table = "t_ticket_station",name = "last_update_date")
    private Date lastUpdateDate;

    @Column(table = "t_ticket_station",name = "last_update_user")
    private Long lastUpdateUser;

    @Column(table = "t_ticket_station",name = "fileMd5")
    private byte[] filemd5;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getShuangpin() {
        return shuangpin;
    }

    public void setShuangpin(String shuangpin) {
        this.shuangpin = shuangpin == null ? null : shuangpin.trim();
    }

    public String getQuanpin() {
        return quanpin;
    }

    public void setQuanpin(String quanpin) {
        this.quanpin = quanpin == null ? null : quanpin.trim();
    }

    public String getJianpin() {
        return jianpin;
    }

    public void setJianpin(String jianpin) {
        this.jianpin = jianpin == null ? null : jianpin.trim();
    }

    public String getWubi() {
        return wubi;
    }

    public void setWubi(String wubi) {
        this.wubi = wubi == null ? null : wubi.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public byte[] getFilemd5() {
        return filemd5;
    }

    public void setFilemd5(byte[] filemd5) {
        this.filemd5 = filemd5;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", shuangpin=").append(shuangpin);
        sb.append(", quanpin=").append(quanpin);
        sb.append(", jianpin=").append(jianpin);
        sb.append(", wubi=").append(wubi);
        sb.append(", name=").append(name);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", lastUpdateDate=").append(lastUpdateDate);
        sb.append(", lastUpdateUser=").append(lastUpdateUser);
        sb.append(", filemd5=").append(filemd5);
        sb.append("]");
        return sb.toString();
    }
}