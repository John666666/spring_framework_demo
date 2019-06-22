package com.john.spring.origin_mybatis;

import com.john.spring.bean.Student;
import com.john.spring.bean.Teacher;
import com.john.spring.mapper.StudentMapper;
import com.john.spring.mapper.annotation.TeacherMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class TestMyBatis {

    MybatisUtil mybatisUtil = null;
    List<Student> studentList = null;


    @Before
    public void setUp() {
        mybatisUtil = new MybatisUtil();

        // 初始化测试数据
        studentList = new ArrayList<>();
        for(int i = 1; i <= 1000; i++) {
            Student student = new Student();
            student.setAge(i);
            student.setGender("男");
            if(i % 2 == 0) {
                student.setSname("楚云飞");
                student.setNickName("快枪手");
            } else {
                student.setSname("李云龙");
                student.setNickName("李骂娘");
            }
            studentList.add(student);
        }
    }

    @Test
    public void testQueryStudent() {

        // 通过命名空间+语句id的方式执行语句(不需要定义Mapper接口，但是容易书写错误)
        // List<Student> studentList = MybatisUtil.getSession(false).selectList("com.john.spring.mapper.StudentMapper.queryAll");

        StudentMapper studentMapper = MybatisUtil.getSession().getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.queryAll();

        System.out.println(studentList);

    }

    /**
     * 用Executor为Batch方式完成批量插入
     */
    @Test
    public void testBatchInsertStudentByExectorTypeBatch() {
        SqlSession sqlSession = MybatisUtil.getSessionFactory().openSession(ExecutorType.BATCH,false);
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            for(Student student : studentList) {
                studentMapper.insert(student);
            }
            // 提交暂存在JDBC驱动中的批量语句
            sqlSession.flushStatements();

            // 提交事务
            sqlSession.commit();

            log.info("成功批量插入： " + studentList.size()+"条数据");

            // 从本批次插入数据中随机抽查10条数据的自增id
            Random random = new Random();
            for(int i = 0; i < 10; i++) {
                int idx = random.nextInt(studentList.size());
                log.info("第"+(idx+1)+"条数据自增id: " + studentList.get(idx).getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 使用默认的Executor类型SIMPLE，通过在Mapper文件中的<forEach>标签，拼接动态SQL，完成批量操作
     */
    @Test
    public void testBatchInsertStudentByForEachSqlMapper() {

        SqlSession sqlSession = MybatisUtil.getSessionFactory().openSession(false);
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

            System.out.println("影响行数： " + studentMapper.insertBatch(studentList));

            // 提交事务
            sqlSession.commit();

            // 从本批次插入数据中随机抽查10条数据的自增id
            Random random = new Random();
            for(int i = 0; i < 10; i++) {
                int idx = random.nextInt(studentList.size());
                log.info("第"+(idx+1)+"条数据自增id: " + studentList.get(idx).getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

    }


    @Test
    public void testInsertTeacher() {

        TeacherMapper teacherMapper = MybatisUtil.getSession().getMapper(TeacherMapper.class);

        Teacher teacher = new Teacher("银角大王");
        teacherMapper.insertTeacher(teacher);
    }

    @Test
    public void testQueryTeacher() {
        TeacherMapper teacherMapper = MybatisUtil.getSession().getMapper(TeacherMapper.class);
        List<Teacher> teacherList = teacherMapper.queryAll();
        System.out.println(teacherList);
    }
}
