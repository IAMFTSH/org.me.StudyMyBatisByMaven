package org.studyMybatisByMaven.mapper;

import org.studyMybatisByMaven.entity.Person;
import org.studyMybatisByMaven.entity.Student;

import java.util.List;

/**
 * @author 邝明山
 * @Date 2020/6/11
 */
public interface SummaryMapper {
    /**
     * 动态sql测试
     * @param person
     * @return personList
     */
    List<Person> selectPersonDynamicSqlByNameAndAge(Person person);


    /**
     *单表插入
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**
     * 多表查询
     * @param i
     * @return Student
     */
    Student selectManyToMany(int i);
}
