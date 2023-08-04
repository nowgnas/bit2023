package cust;

import dto.Cust;
import frame.DaoFrame;
import frame.ServiceFrame;

import java.util.List;

public class CustServiceImpl implements ServiceFrame<String, Cust> {
    DaoFrame<String, Cust> dao;

    public CustServiceImpl() {
        dao = new CustDaoImpl();
    }

    @Override
    public void register(Cust cust) throws Exception {
        dao.insert(cust);

    }

    @Override
    public void modify(Cust cust) throws Exception {
        dao.update(cust);
    }

    @Override
    public void remove(String s) throws Exception {
        dao.delete(s);
    }

    @Override
    public Cust get(String s) throws Exception {
        return dao.select(s);
    }

    @Override
    public List<Cust> get() throws Exception {
        return dao.select();
    }
}
