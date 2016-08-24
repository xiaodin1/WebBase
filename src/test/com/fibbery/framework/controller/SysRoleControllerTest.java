package com.fibbery.framework.controller;


import com.fibbery.framework.service.SysRoleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.function.Predicate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/webapp")
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SysRoleControllerTest {
    private static Log log = LogFactory.getLog(SysRoleControllerTest.class);

    protected MockMvc mvc;

    @Autowired
    protected WebApplicationContext context;

    @Autowired
    protected SysRoleService service;


    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();  //初始化MockMvc对象
    }

    @Test
    public void testList() {
        String responseStr = "";
        try {
            responseStr = mvc.perform(patch("/role/")).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(responseStr);
        System.out.println(service);
    }

    @Test
    public void testGet() throws Exception {
        Predicate<String> str = s -> s.length() > 0;
        Thread thread = new Thread(() -> {
            System.out.println(str.test("123213123213123123"));
        });
        thread.start();
    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }
}