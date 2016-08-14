package com.itgary.pro3.spring.mybatis.server;

import com.itgary.pro3.spring.mybatis.entity.UserInfo;
import com.itgary.pro3.spring.mybatis.mapping.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gary on 2016/8/14.
 */
@Service
public class UserImpl implements IUser{
    @Autowired
    private UserInfoMapper mapper;

    @Override
    public List<UserInfo> selectAll() {
        return mapper.selectAll();
    }
}
