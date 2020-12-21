package com.fpi.test.model;

public class UserInfo {

    private Long userId;

    private String nickname;

    private String tenantId;

    private String openId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", openId='" + openId + '\'' +
                '}';
    }
}
