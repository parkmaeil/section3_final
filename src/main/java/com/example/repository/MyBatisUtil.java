package com.example.repository;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtil {
    // SqlSessionFactoryBuilder - Connection Pool--> SqlSessionFactory
    private static SqlSessionFactory sqlSessionFactory;  // SqlSession
    static {
        try {
            String resource = "mybatis-config/config.xml"; //  파일->I/O API(Stream API)
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream); // Connection(SqlSession) : 10개, +5개, 20초, 20초
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//static_end
    public static SqlSession openSession(){   // SqlSession session=MyBatisUtil.openSession()
        return sqlSessionFactory.openSession();
    }
}
