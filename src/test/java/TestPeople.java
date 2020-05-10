import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.studyMybatisByMaven.mapper.PeopleMapper;
import org.studyMybatisByMaven.mapper.PersonMapper;

import java.io.IOException;
import java.io.Reader;

public class TestPeople {
    
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = null;
        sqlSession = new TestPerson2().getSqlSession();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        PeopleMapper PeopleMapper = sqlSession.getMapper(PeopleMapper.class);

        System.out.println(PeopleMapper.queryPeopleAndStudentByIdLazyLoad(100).toString());
        System.out.println(PeopleMapper.queryPeopleAndStudentByIdLazyLoad(100).getPersons().toString());


        sqlSession.close();
    }

    public SqlSession getSqlSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

}
