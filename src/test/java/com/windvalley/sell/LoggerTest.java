package com.windvalley.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void Test1(){
        //定义变量方式
//        logger.debug("debug... ...");
//        logger.info("debug... ...");
//        logger.error("error... ...");

        //注解方式
        log.debug("debug... ...");
        log.info("debug... ...");
        log.error("error... ...");
    }
}
