import class_.Brand;
import class_.User;
import mapper.tb_brandMapper;
import mapper.tb_userMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws Exception {
        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象,用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql
//        List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取tb_userMapper接口的代理对象
        tb_brandMapper mapper = sqlSession.getMapper(tb_brandMapper.class);
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);

        sqlSession.close();



    }
}
