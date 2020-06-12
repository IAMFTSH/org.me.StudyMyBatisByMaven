package org.studyMybatisByMaven.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 邝明山
 * @Date 2020/6/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    private Lesson lesson;
    private Teacher teacher;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
