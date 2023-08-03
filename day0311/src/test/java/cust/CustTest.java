package cust;

import dto.Cust;
import frame.ServiceFrame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;

public class CustTest {
    Logger log = Logger.getLogger("CustTest");
    ServiceFrame<String, Cust> service;

    @BeforeEach
        // 각각의 테스트 진행 시 반드시 실행
    void before() {
        service = new CustService();
    }

    @DisplayName("Insert Test")
    @Test
    void test() {
        Cust inputCust = Cust.builder().id("id01").pwd("pwd01").name("james").build();
        service.register(inputCust);
        log.info("Insert Cust OK.... ");
        Cust cust = service.get("id01");
        Assertions.assertEquals(cust.getId(), inputCust.getId(), "Insert Error");
    }

    @DisplayName("select All Test")
    @Test
    void selectAll() {
        List<Cust> list = null;
        list = service.get();

        log.info("Insert Cust OK.... ");
        Assertions.assertTrue(list.size() == 4, "Select error");
    }

}
