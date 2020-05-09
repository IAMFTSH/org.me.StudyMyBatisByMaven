package org.studyMybatisByMaven.mapper;

import org.studyMybatisByMaven.entity.People;

public interface PeopleMapper {
    People queryPeopleAndStudentByIdLazyLoad(int i);
    People queryPersonByIdWithConverterOneToMany(int i);
}
