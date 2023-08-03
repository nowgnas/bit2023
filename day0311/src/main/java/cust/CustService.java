package cust;

import dto.Cust;
import frame.DaoFrame;
import frame.ServiceFrame;

import java.util.List;

public class CustService implements ServiceFrame<String, Cust> {
    DaoFrame<String, Cust> dao;

    public CustService() {
        dao = new CustDao();
    }

    @Override
    public void register(Cust cust) {
        dao.insert(cust);

    }

    @Override
    public void modify(Cust cust) {
        dao.update(cust);
    }

    @Override
    public void remove(String s) {
        dao.delete(s);
    }

    @Override
    public Cust get(String s) {
        return dao.select(s);
    }

    @Override
    public List<Cust> get() {
        return dao.select();
    }
}
