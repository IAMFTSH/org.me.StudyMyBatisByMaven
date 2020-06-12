package org.studyMybatisByMaven.mapper;

import org.springframework.stereotype.Repository;
import org.studyMybatisByMaven.entity.Grade;
import org.studyMybatisByMaven.entity.People;
import org.studyMybatisByMaven.entity.Person;

import java.util.List;
import java.util.Map;

@Repository
public interface PersonMapper {
    Person queryPersonById(int id);
    List<Person> queryAllPerson();
    int deletePersonById(int id);
    int insertPerson(Person person);
    int updatePersonById(Person person);

    Person queryPersonByIdWithConverter(int id);
    Person queryPersonByIdWithConverter2(int id);
    List<Person> queryAllPersonWithConverter();
    int deletePersonByIdWithConverter(int id);
    int insertPersonWithConverter(Person person);
    int updatePersonByIdWithConverter(Person person);


    void selectLittleByIdWithProcedureAndMap(Map<String,Object> map);

    List<Person> selectPersonDynamicSqlByNameAndAge(Person person);
    List<Person> selectPersonDynamicSqlByGrade(Grade grade);

}
