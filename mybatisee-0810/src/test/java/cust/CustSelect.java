package cust;

import app.dto.Cust;
import app.service.CustServiceImpl;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustSelect {

    @Test
    @DisplayName("select test")
    void select() throws Exception {
        CustServiceImpl service = new CustServiceImpl();
        Cust custs = service.get("id01");
        System.out.println(custs);

    }

    @Test
    @DisplayName("select test")
    void insert() throws Exception {
        CustServiceImpl service = new CustServiceImpl();
        service.register(Cust.builder()
                .id("id01")
                .name("lee")
                .pwd("erel").build());

    }

    @Test
    void test(){
        System.out.println("hello test ");
    }
}
