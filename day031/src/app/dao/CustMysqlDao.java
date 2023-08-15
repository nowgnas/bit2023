package app.dao;


import app.dto.Cust;

import java.util.logging.Logger;

public class CustMysqlDao {
    Logger log = Logger.getLogger("LombokTest");

    public void insert(Cust cust) {
        log.info(cust.toString() + "inserted....");


    }

    public Cust select(String id) {
        log.info("selected...");
        Cust cust = Cust.builder()
                .id("id01")
                .pwd("pwd01")
                .name("james")
                .build();
        return cust;
    }

}
