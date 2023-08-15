package app.main;

import app.dto.Cust;
import app.service.CustService;

public class Main {
    public static void main(String[] args) {
        CustService custService = new CustService();
        Cust cust = Cust.builder()
                .id("id01")
                .pwd("pwd01")
                .name("james")
                .build();
        custService.register(cust);

    }

}
