package com.itgary.pro3.spring.mybatis.mapping;

import com.itgary.pro3.spring.mybatis.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gary on 2016/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:spring-context.xml"
})
public class UserInfoMapperTest  extends AbstractJUnit4SpringContextTests {
    @Test
    public void selectAll() throws Exception {
        UserInfoMapper mapper = (UserInfoMapper)applicationContext.getBean("userInfoMapper");
        List<UserInfo> list = mapper.selectAll();

        System.out.println("list size():" + list.size());
    }

}