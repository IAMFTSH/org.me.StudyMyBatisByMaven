import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.studyMybatisByMaven.entity.Address;
import org.studyMybatisByMaven.entity.People;
import org.studyMybatisByMaven.entity.Person;
import org.studyMybatisByMaven.mapper.PeopleMapper;
import org.studyMybatisByMaven.mapper.PersonMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/*转换器+resultMap*/
public class TestPerson3 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = null;
        sqlSession = new TestPerson3().getSqlSession();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        PeopleMapper peopleMapper = sqlSession.getMapper(PeopleMapper.class);

        System.out.println(personMapper.queryPersonByIdWithConverter(12));

        System.out.println(personMapper.queryPersonByIdWithConverter2(11));//一对一

        People people=peopleMapper.queryPersonByIdWithConverterOneToMany(1);//一对多 地址因为sql没叫查所以为空
        List<Person> personList=people.getPersons();
        System.out.println(personList);



        int num = personMapper.deletePersonByIdWithConverter(20);
        System.out.println("删除"+num);
        sqlSession.commit();

        Address address=new Address("asd","dsa",4);
        Person person1 = new Person(20, "ddd", 30, false, 1, address, 1);
        System.out.println("插入"+personMapper.insertPersonWithConverter(person1));
        sqlSession.commit();

        List<Person> persons = personMapper.queryAllPersonWithConverter();
        System.out.println("查找全部"+persons);

        Person person2 = new Person(20, "ccc", 30, false, 2, address, 1);
        System.out.println("修改"+personMapper.updatePersonByIdWithConverter(person2));
        sqlSession.commit();

        persons = personMapper.queryAllPersonWithConverter();
        System.out.println("查找全部"+persons);

        sqlSession.close();
    }

    public SqlSession getSqlSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
