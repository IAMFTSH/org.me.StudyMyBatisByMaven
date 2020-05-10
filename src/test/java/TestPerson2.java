import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.studyMybatisByMaven.entity.Address;
import org.studyMybatisByMaven.entity.Person;
import org.studyMybatisByMaven.mapper.PersonMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestPerson2 {


    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = null;
        sqlSession = new TestPerson2().getSqlSession();

        Address address =new Address("asd","dsa",6);
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

        System.out.println(personMapper.queryPersonById(20));


        int num = personMapper.deletePersonById(20);
        System.out.println(num);
        sqlSession.commit();

        Person person1 = new Person(20, "ddd", 30, false,20,100);
        System.out.println(personMapper.insertPerson(person1));
        sqlSession.commit();

        List<Person> persons = personMapper.queryAllPerson();
        System.out.println(persons);

        Person person2 = new Person(20, "ccc", 30, false, 1, address, 1);
        System.out.println(personMapper.updatePersonById(person2));
        sqlSession.commit();

        persons = personMapper.queryAllPerson();
        System.out.println(persons);

        sqlSession.close();
    }

    public SqlSession getSqlSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

}
