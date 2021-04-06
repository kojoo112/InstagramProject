package com.kojoo.instagram;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisTest {
 
    @Inject
    private SqlSessionFactory sqlFactory;
    private SqlSession session;
    @Test
    public void testFactory() {
        System.out.println(sqlFactory);
        System.out.println(session);
    }
    @Test
    public void testSession() {
        try (SqlSession session = sqlFactory.openSession()){
            System.out.println(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}


