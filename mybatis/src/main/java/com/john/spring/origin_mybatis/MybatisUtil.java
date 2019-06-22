package com.john.spring.origin_mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    public synchronized static SqlSessionFactory getSessionFactory() {
        if(sqlSessionFactory != null) {
            return sqlSessionFactory;
        }
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
//            sessionFactory.getConfiguration().addMappers("com.john.spring.mapper.annotation");
            sqlSessionFactory = sessionFactory;
            return sessionFactory;
        } catch (IOException e) {
            log.error("加载Mybatis配置文件失败", e);
        }
        return null;
    }

    public static SqlSession getSession() {
        return getSessionFactory().openSession();
    }

    public static SqlSession getSession(boolean autoCommit) {
        return getSessionFactory().openSession(autoCommit);
    }

}
