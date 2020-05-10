import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.studyMybatisByMaven.entity.Grade;
import org.studyMybatisByMaven.entity.Person;
import org.studyMybatisByMaven.mapper.PersonMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

/*动态sql语句*/
public class TestPerson5 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = null;
        sqlSession = new TestPerson5().getSqlSession();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

        Person person=new Person();
        person.setName("ccc");
        person.setAge(30);
        List<Person> persons=personMapper.selectPersonDynamicSqlByNameAndAge(person);
        System.out.println(persons);

        List ids=new ArrayList();
        ids.add(11);
        ids.add(14);
        Grade grade=new Grade(ids);
        persons=personMapper.selectPersonDynamicSqlByGrade(grade);
        System.out.println(persons);


    }

    public SqlSession getSqlSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
