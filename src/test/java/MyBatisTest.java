import class_.Brand;
import class_.User;
import mapper.tb_brandMapper;
import mapper.tb_userMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testselectAll() throws Exception {
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



    @Test
    public void testselectById() throws Exception {
        int id = 1;
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

        Brand brand = mapper.selectById(id);
        System.out.println(brand);

        sqlSession.close();
    }


    @Test
    public void testselectByCondition() throws Exception {
//        接收参数
        int status = 0;
        String companyName = "三只松鼠";
        String brandName = "三只松鼠";
//        处理参数
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

//        封装对象
        Brand brands = new Brand();
        brands.setStatus(status);
        brands.setCompanyName(companyName);
        brands.setBrandName(brandName);

//        Map
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

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

//        List<Brand> brand = mapper.selectByCondition(status,companyName,brandName);

//        List<Brand> brand = mapper.selectByCondition(brands);

//        List<Brand> brand = mapper.selectByCondition(map);
        List<Brand> brand = mapper.selectByConditionSingle(map);
        System.out.println(brand);
        sqlSession.close();
    }

    @Test
    public void testadd() throws Exception {
//        接收参数
        int status = 0;
        int ordered = 99;
        String description = "只卖坚果2";
        String companyName = "三只松鼠2";
        String brandName = "三只松鼠2";


//        封装对象
        Brand brands = new Brand();

        brands.setBrandName(brandName);
        brands.setCompanyName(companyName);
        brands.setOrdered(ordered);
        brands.setDescription(description);
        brands.setStatus(status);

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

//        List<Brand> brand = mapper.selectByCondition(status,companyName,brandName);

//        List<Brand> brand = mapper.selectByCondition(brands);

//        List<Brand> brand = mapper.selectByCondition(map);
//        List<Brand> brand = mapper.selectByConditionSingle(map);
        mapper.add(brands);
        Integer id = brands.getId();
        System.out.println(id);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testup() throws Exception {
//        接收参数
        int id = 8;
        int status = 1;
        int ordered = 666;
        String description = "老九";
        String companyName = "老八老八";
        String brandName = "吃粑粑+1";

//        封装对象
        Brand brands = new Brand();
        brands.setId(id);
        brands.setBrandName(brandName);
//        brands.setCompanyName(companyName);
//        brands.setOrdered(ordered);
        brands.setDescription(description);
//        brands.setStatus(status);

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

//        List<Brand> brand = mapper.selectByCondition(status,companyName,brandName);

//        List<Brand> brand = mapper.selectByCondition(brands);

//        List<Brand> brand = mapper.selectByCondition(map);
//        List<Brand> brand = mapper.selectByConditionSingle(map);
        int count = mapper.updata(brands);
        System.out.println(count);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void del() throws Exception {
//        接收参数
        int id = 7;

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

//        List<Brand> brand = mapper.selectByCondition(status,companyName,brandName);

//        List<Brand> brand = mapper.selectByCondition(brands);

//        List<Brand> brand = mapper.selectByCondition(map);
//        List<Brand> brand = mapper.selectByConditionSingle(map);
        mapper.del(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delids() throws Exception {
//        接收参数
        int[] ids = {6,4};

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

//        List<Brand> brand = mapper.selectByCondition(status,companyName,brandName);

//        List<Brand> brand = mapper.selectByCondition(brands);

//        List<Brand> brand = mapper.selectByCondition(map);
//        List<Brand> brand = mapper.selectByConditionSingle(map);
        mapper.delids(ids);
        sqlSession.commit();
        sqlSession.close();
    }
}
