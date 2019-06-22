package com.john.spring.mapper.annotation;

import com.john.spring.bean.Student;
import com.john.spring.bean.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    @Insert("insert into teacher(tname) values (#{tname})")
    int insertTeacher(Teacher teacher);

    @Select("select * from teacher")
    List<Teacher> queryAll();

}
