package app.cust;

import app.dto.Cust;
import app.frame.DaoFrame;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CustDaoImpl implements DaoFrame<String, Cust> {
    // Repository 역할을 하는 Dao


    @Override
    public int insert(Cust cust, SqlSession session) throws Exception {
        return session.insert("cust.insert", cust);
    }

    @Override
    public int update(Cust cust, SqlSession session) throws Exception {
        return session.update("cust.update", cust);
    }

    @Override
    public int delete(String s, SqlSession session) throws Exception {
        return session.delete("cust.delete", s);
    }

    @Override
    public Cust select(String s, SqlSession session) throws Exception {
        return session.selectOne("cust.select", s);
    }

    @Override
    public List<Cust> select(SqlSession session) throws Exception {
        return session.selectList("cust.selectall");
    }
}
