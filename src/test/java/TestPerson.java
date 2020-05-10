import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.studyMybatisByMaven.entity.Address;
import org.studyMybatisByMaven.entity.Person;

public class TestPerson {
    public static void main(String[] args){
        SqlSession sqlSession = null;
        try {
            sqlSession = new TestPerson().getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Address address=new Address("asd","dsa",5);
        String queryPersonByIdStatement = "org.studyMybatisByMaven.mapper.PersonMapper.queryPersonById";  //这里的参数要和Mapper的namespace相同
        Person person = sqlSession.selectOne(queryPersonByIdStatement, 12);
        System.out.println("id查人"+person);

        String deletePersonByIDStatement = "org.studyMybatisByMaven.mapper.PersonMapper.deletePersonById";
        System.out.println("id刪人"+sqlSession.delete(deletePersonByIDStatement, 1));
        sqlSession.commit();

        String insertPersonStatement = "org.studyMybatisByMaven.mapper.PersonMapper.insertPerson";  //这里的参数要和Mapper的namespace相同
        Person person1=new Person(17,"ddd",30, false,20,100);
        System.out.println("id加人"+sqlSession.insert(insertPersonStatement,person1));
        sqlSession.commit();

        String queryAllPersonStatement = "org.studyMybatisByMaven.mapper.PersonMapper.queryAllPerson";
        List<Person> persons = sqlSession.selectList(queryAllPersonStatement);
        System.out.println("查所有人"+persons);

        String updatePersonByIDStatement = "org.studyMybatisByMaven.mapper.PersonMapper.updatePersonById";  //这里的参数要和Mapper的namespace相同
        Person person2=new Person(11,"ccc",30, true, 1, address, 1);
        System.out.println("id更人"+sqlSession.update(updatePersonByIDStatement,person2));
        sqlSession.commit();

        queryAllPersonStatement = "org.studyMybatisByMaven.mapper.PersonMapper.queryAllPerson";
        persons = sqlSession.selectList(queryAllPersonStatement);
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
