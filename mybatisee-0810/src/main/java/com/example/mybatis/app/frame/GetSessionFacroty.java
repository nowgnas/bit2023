package com.example.mybatis.app.frame;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class GetSessionFacroty {

    private static SqlSessionFactory instance;


    public static synchronized SqlSessionFactory getInstance() {
        if (instance == null) {
            try {
                instance = new SqlSessionFactoryBuilder().build(
                        Resources.getResourceAsReader("mybatis.xml")
                );
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }

}
