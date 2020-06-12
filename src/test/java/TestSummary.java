import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.studyMybatisByMaven.entity.Grade;
import org.studyMybatisByMaven.entity.Person;
import org.studyMybatisByMaven.entity.Student;
import org.studyMybatisByMaven.mapper.PersonMapper;
import org.studyMybatisByMaven.mapper.SummaryMapper;
import org.studyMybatisByMaven.util.Weekday;
import org.studyMybatisByMaven.util.Weekday2;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 邝明山
 * @Date 2020/6/11
 */
public class TestSummary {
    public static void main(String[] args) throws IOException {

    }


    /**
     * 动态sql
     */
    @Test
    public void sql() throws IOException {
        SqlSession sqlSession = new TestSummary().getSqlSession();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

        Person person = new Person();
        person.setName("ccc");
        person.setAge(30);
        List<Person> persons = personMapper.selectPersonDynamicSqlByNameAndAge(person);
        persons.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------");

        List ids = new ArrayList();
        ids.add(11);
        ids.add(14);
        Grade grade = new Grade(ids);
        persons = personMapper.selectPersonDynamicSqlByGrade(grade);
        persons.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * 插入
     */
    @Test
    public void insertSql() throws IOException {
        SqlSession sqlSession = new TestSummary().getSqlSession();
        SummaryMapper summaryMapper = sqlSession.getMapper(SummaryMapper.class);


        int result = summaryMapper.insertStudent(new Student("jay", 20));
        System.out.println(result);
        sqlSession.commit();
    }

    /**
     * 多表查询
     */
    @Test
    public void selectManyToMany() throws IOException {
        SqlSession sqlSession = new TestSummary().getSqlSession();
        SummaryMapper summaryMapper = sqlSession.getMapper(SummaryMapper.class);


        Student result = summaryMapper.selectManyToMany(1);
        System.out.println(result);
    }

    /**
     * 枚举类测试
     *
     * @throws IOException
     */
    @Test
    public void testEnum() throws IOException {
        System.out.println("nowday ====> " + Weekday.FRIDAY);
        //ordinal()取的是数组下标
        System.out.println("nowday index ====> " + Weekday.SUNDAY.ordinal());
        System.out.println("nowday index ====> " + Weekday.values());
        System.out.println("nextday ====> " + Weekday.getNextDay(Weekday.FRIDAY));
        System.out.println("-------------------------------------------------------------------");
        System.out.println(Weekday2.FRIDAY.ordinal());
    }

    public SqlSession getSqlSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("conf.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
