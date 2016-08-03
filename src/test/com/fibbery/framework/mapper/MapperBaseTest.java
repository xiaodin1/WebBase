package com.fibbery.framework.mapper;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jiangnenghua on 2016/8/3.
 */
public class MapperBaseTest {
    protected  ClassPathXmlApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
    }

    @After
    public void tearDown() throws Exception {

    }
}
