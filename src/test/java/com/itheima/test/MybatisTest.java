package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import jdk.internal.module.Resources;
import org.apache.ibatis.session.*;

import java.io.InputStream;
import java.util.List;


public class MybatisTest {
    public static void main(String[] args) {
//        1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2.创建SqlSessionFactory工厂
          SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
          SqlSessionFactory factory =builder.build(in);
//        3.使用工厂生产SqlSession对象
          SqlSession session = factory.openSession();
//        4.使用Sqlsession创建Dao接口
        IUserDao userDao = session.getMapper(IUserDao.class);
//        5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user:users)
            System.out.println(user);
//        6.释放资源
        session.close();
        in.close();
    }
}
