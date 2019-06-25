package com.john.spring.origin_mybatis;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestMyBatisGenarate {

    /*MessageMapper messageMapper = null;

    @Before
    public void setUp() {
        SqlSession sqlSession = MyBatisTools.getInstance().openSession();
        messageMapper = sqlSession.getMapper(MessageMapper.class);
    }

    *//**
     * 测试条件查询
     *//*
    @Test
    public void testConditionQuery() {
        MessageExample me = new MessageExample();
        MessageExample.Criteria mc = new MessageExample.Criteria() {

        };
        me.or(mc);
        List<Message> messageList = messageMapper.selectByExample(me);
        log.info("" + messageList);
    }*/
}
