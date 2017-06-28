package com.jia16.uc.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by lazyb on 2017/6/22.
 */
public class User implements Serializable {

    private long id;
    private Long userId;
    private String username;
    private String phone;
    private String password;
    private Certificate certificate;
    private String boundIdentity;
    private String dealPassword;
    private String openid;
    private Timestamp createdAt;
    private boolean notifyDepositAgreement = true;
    private Timestamp lastLoginAt;
    private int modifyUserNameCount;
    private String stock;
    private long zallUserId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public String getBoundIdentity() {
        return boundIdentity;
    }

    public void setBoundIdentity(String boundIdentity) {
        this.boundIdentity = boundIdentity;
    }

    public String getDealPassword() {
        return dealPassword;
    }

    public void setDealPassword(String dealPassword) {
        this.dealPassword = dealPassword;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isNotifyDepositAgreement() {
        return notifyDepositAgreement;
    }

    public void setNotifyDepositAgreement(boolean notifyDepositAgreement) {
        this.notifyDepositAgreement = notifyDepositAgreement;
    }

    public Timestamp getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(Timestamp lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public int getModifyUserNameCount() {
        return modifyUserNameCount;
    }

    public void setModifyUserNameCount(int modifyUserNameCount) {
        this.modifyUserNameCount = modifyUserNameCount;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public long getZallUserId() {
        return zallUserId;
    }

    public void setZallUserId(long zallUserId) {
        this.zallUserId = zallUserId;
    }
}
