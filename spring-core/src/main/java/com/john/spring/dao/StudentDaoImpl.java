package com.john.spring.dao;

import com.john.spring.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 由于在事务中配置的策略是dao中所有query、find、get开头的方法，事务是只读。所以如果在此方法中写更新、插入语句是不会提交到数据库的
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Student> queryStudents() {
        /*List<Student> studentList = jdbcTemplate.query("select * from student;", new BeanPropertyRowMapper<Student>());
        return studentList;*/

        // 下面代码模拟在query开头的方法中执行插入操作
        Object[] params = new Object[]{
                "张三", 28, "男", "三哥"
        };

        int effectRows = jdbcTemplate.update("insert into student (sname, age, gender, nick_name) values (?,?,?,?);", params);
        System.out.println("插入了"+effectRows+"行数据.");
        return null;
    }

    @Transactional
    @Override
    public int[] batchInsertStudent(List<Student> studentList) {

        List<Object[]> params = new ArrayList<>();
        for(Student stu : studentList) {
            Object[] stuParam = new Object[]{
                    stu.getSname(),
                    stu.getAge(),
                    stu.getGender(),
                    stu.getNickName()
            };
            params.add(stuParam);
        }
        int[] retIds = jdbcTemplate.batchUpdate("insert into student (sname, age, gender, nick_name) values (?,?,?,?);", params);

        // 模拟数据库保存方法中出现异常
        // 如果配置了事务，则上面批量保存的数据不会提交到数据库。反之，如果没配置事务，则会提交到数据库
        int ret = 9 / 0;

        return retIds;
    }

    public void init() {
        System.out.println("StudentDaoImpl init...");
    }

    public void destroy() {
        System.out.println("StudentDaoImpl destroy...");
    }

}
