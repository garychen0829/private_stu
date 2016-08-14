package com.itgary.pro3.spring.mybatis.server;

import com.itgary.pro3.spring.mybatis.entity.UserInfo;

import java.util.List;

/**
 * Created by gary on 2016/8/14.
 */
public interface IUser {
    List<UserInfo> selectAll();
}
