package cust;

import dto.Cust;
import frame.ServiceFrame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class CustSelectTest {
    Logger log = Logger.getLogger("CustTest");
    ServiceFrame<String, Cust> service;

    @BeforeEach
        // 각각의 테스트 진행 시 반드시 실행
    void before() throws Exception {
        service = new CustServiceImpl();
        Cust inputCust = Cust.builder().id("id07").pwd("pwd05").name("james5").build();
        int result = service.register(inputCust);
    }

    @DisplayName("cust database select test")
    @Test
    void select() throws Exception {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            Cust cust = null;
            cust = service.get("id44");
        });
        Assertions.assertEquals("조회에러", exception.getMessage(), "throw error");

    }
}
