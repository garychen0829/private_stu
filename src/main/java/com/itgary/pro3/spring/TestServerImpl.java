package com.itgary.pro3.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by gary.chen on 2016/8/3.
 */
@Service
public class TestServerImpl implements TestServer{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public String hello() {
        String ss = "hello spring test.";
        logger.info("logger print: {}",ss);
        return ss;
    }
}
