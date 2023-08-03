package cust;

import dto.Cust;
import frame.DaoFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustDao implements DaoFrame<String, Cust> {
    Logger logger = Logger.getLogger("CustDao");

    @Override
    public void insert(Cust cust) {
        logger.info("inserted: " + cust.toString());
    }

    @Override
    public void update(Cust cust) {
        logger.info("updated: " + cust.toString());

    }

    @Override
    public void delete(String s) {
        logger.info("deleted: " + s);

    }

    @Override
    public Cust select(String s) {
        Cust cust = Cust.builder()
                .id("id01")
                .pwd("pwd01")
                .name("james")
                .build();
        return cust;
    }

    @Override
    public List<Cust> select() {
        ArrayList<Cust> list = new ArrayList<>();
        list.add(Cust.builder().id("id01").pwd("pwd01").name("james").build());
        list.add(Cust.builder().id("id01").pwd("pwd01").name("james").build());
        list.add(Cust.builder().id("id01").pwd("pwd01").name("james").build());
        list.add(Cust.builder().id("id01").pwd("pwd01").name("james").build());
        return list;
    }
}
