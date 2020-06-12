package org.studyMybatisByMaven.mapper;

import org.springframework.stereotype.Repository;
import org.studyMybatisByMaven.entity.People;

@Repository
public interface PeopleMapper {
    /**
     *
     * @param i
     * @return
     */
    People queryPeopleAndStudentByIdLazyLoad(int i);

    /**
     *
     * @param i
     * @return
     */
    People queryPersonByIdWithConverterOneToMany(int i);
}
