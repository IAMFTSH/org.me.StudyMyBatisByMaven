import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.studyMybatisByMaven.entity.Address;
import org.studyMybatisByMaven.entity.Person;
import org.studyMybatisByMaven.mapper.PersonMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*使用Map调用存储函数*/
public class TestPerson4 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = null;
        sqlSession = new TestPerson4().getSqlSession();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("idValue","15");
        personMapper.selectLittleByIdWithProcedureAndMap(map);
        Object object=map.get("count");
        System.out.println(map);
        sqlSession.close();
    }

    public SqlSession getSqlSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
