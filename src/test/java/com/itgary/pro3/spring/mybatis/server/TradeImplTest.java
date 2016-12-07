package com.itgary.pro3.spring.mybatis.server;

import com.itgary.pro3.spring.mybatis.entity.TradeInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by gary.chen on 2016/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:spring-context.xml"
})
public class TradeImplTest extends AbstractJUnit4SpringContextTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void testSelectAll() throws Exception {
        ITrade iTrade = (ITrade)applicationContext.getBean("tradeImpl");
        List<TradeInfo> list = iTrade.selectAll();
        logger.info("list size:{}" , list.size());

    }
}