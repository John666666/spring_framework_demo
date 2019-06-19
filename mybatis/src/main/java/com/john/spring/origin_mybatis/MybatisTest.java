package com.john.spring.origin_mybatis;

import com.john.spring.bean.Student;
import com.john.spring.bean.Teacher;
import com.john.spring.mapper.StudentMapper;
import com.john.spring.mapper.annotation.TeacherMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class MybatisTest {

    public static SqlSessionFactory getSessionFactory() {
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            sessionFactory.getConfiguration().addMappers("com.john.spring.mapper.annotation");
            return sessionFactory;
        } catch (IOException e) {
            log.error("加载Mybatis配置文件失败", e);
        }
        return null;
    }

    public static SqlSession getSession() {
        return getSessionFactory().openSession(true);
    }

    public List<Student> queryAllStudent() {
        StudentMapper mapper = getSession().getMapper(StudentMapper.class);
        List<Student> studentList = mapper.queryAll();
        return studentList;
    }

    public int insertTeacher(Teacher teacher) {
        TeacherMapper mapper = getSession().getMapper(TeacherMapper.class);
        return mapper.insertTeacher(teacher);
    }

}
