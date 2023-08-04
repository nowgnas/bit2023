package cust;

import dto.Cust;
import frame.DaoFrame;
import frame.ServiceFrame;

import java.util.List;
import java.util.Optional;

public class CustServiceImpl implements ServiceFrame<String, Cust> {
    DaoFrame<String, Cust> dao;

    public CustServiceImpl() {
        dao = new CustDaoImpl();
    }

    @Override
    public int register(Cust cust) throws Exception {
        return dao.insert(cust);

    }

    @Override
    public int modify(Cust cust) throws Exception {
        return dao.update(cust);

    }

    @Override
    public int remove(String s) throws Exception {
        int result = dao.delete(s);
        if (result == 0) throw new Exception("삭제에러");
        return result;
    }

    @Override
    public Cust get(String s) throws Exception {
        Optional<Cust> select = dao.select(s);
        if (select.isEmpty())
            throw new Exception("조회내용 없음");
        return select.get();
    }

    @Override
    public List<Cust> get() throws Exception {
        return dao.select();
    }
}
