package com.itgary.pro3.spring.mybatis.server;

import com.itgary.pro3.spring.mybatis.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gary on 2016/8/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:spring-context.xml"
})
public class UserImplTest  extends AbstractJUnit4SpringContextTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void selectAll() throws Exception {

        IUser iUser = (IUser)applicationContext.getBean("userImpl");
        logger.info("IUser,{}",iUser);
        List<UserInfo> list = iUser.selectAll();
        logger.info("list size:{}",list.size());
    }

}