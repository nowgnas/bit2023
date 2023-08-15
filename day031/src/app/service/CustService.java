package app.service;

import app.dao.CustMysqlDao;
import app.dto.Cust;

import java.util.logging.Logger;

public class CustService {
    CustMysqlDao dao;
    Logger logger = Logger.getLogger("CustService");

    public CustService() {
        dao = new CustMysqlDao();
    }

    public void register(Cust cust) {
        logger.info("security check");
        dao.insert(cust);
        logger.info("send mail... ");

    }

    public Cust get(String id) {
        return dao.select(id);
    }
}
