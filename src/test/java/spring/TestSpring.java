//package spring;
//
//import com.itgary.pro3.spring.TestServerImpl;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * Created by gary.chen on 2016/8/3.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//        "classpath*:spring-context.xml"
//})
//public class TestSpring extends AbstractJUnit4SpringContextTests{
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Test
//    public void test(){
//
//        TestServerImpl imp = (TestServerImpl)applicationContext.getBean("testServerImpl");
//        String str = imp.hello();
//        logger.info("slf4j:{} str:{}",logger,str);
//        System.out.println("Junit test:{}" + str);
//    }
//}
