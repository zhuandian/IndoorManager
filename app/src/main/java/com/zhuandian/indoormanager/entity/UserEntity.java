package com.zhuandian.indoormanager.entity;

import cn.bmob.v3.BmobUser;

/**
 * desc :用户实体
 * author：xiedong
 * data：2019/02/28
 */
public class UserEntity extends BmobUser {
    private String nikeName;
    private String userInfo;
    private int roleId;  //1 ，企业参观者 2.入住企业

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
