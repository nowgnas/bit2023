package com.example.mybatis.app.service;

import com.example.mybatis.app.cust.CustDaoImpl;
import com.example.mybatis.app.dto.Cust;
import com.example.mybatis.app.frame.DaoFrame;
import com.example.mybatis.app.frame.GetSessionFacroty;
import com.example.mybatis.app.frame.ServiceFrame;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CustServiceImpl implements ServiceFrame<String, Cust> {
    DaoFrame<String, Cust> dao; // interface 를 선언해서 사용해야 한다 - 구체를 가지고 오는 것이 아님
    // 인터페이스를 가지고 오게 되면 루즈 커플링 - 느슨한 결합이 된다
    SqlSession session; // session 은 mybatis 커넥션을 가지고 사용한다

    public CustServiceImpl() {
        this.dao = new CustDaoImpl();
        session = GetSessionFacroty.getInstance().openSession();
    }

    @Override
    public int register(Cust cust) throws Exception {
        session = GetSessionFacroty.getInstance().openSession();
        try {
            dao.insert(cust, session);
            session.commit(); // 서비스에서 트랜잭션을 관리 하므로 커밋을 해야 반영이 된다ㅣ

        } catch (Exception e) {
            session.rollback();
            throw new Exception("E0001");
        }
        return 0;
    }

    @Override
    public int modify(Cust cust) throws Exception {
        return 0;
    }

    @Override
    public int remove(String s) throws Exception {
        return 0;
    }

    @Override
    public Cust get(String s) throws Exception {
        session = GetSessionFacroty.getInstance().openSession();
        Cust cust = null;
        try {
            cust = dao.select(s, session);
            session.commit();
        } catch (Exception e) {
            throw new Exception("E0003");
        }
        return cust;
    }

    @Override
    public List<Cust> get() throws Exception {
        return dao.select(session);
    }
}
