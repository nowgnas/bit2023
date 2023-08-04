package cust;

import dto.Cust;
import frame.ServiceFrame;
import org.junit.jupiter.api.*;

import java.util.logging.Logger;

public class CustInsertTest {
    Logger log = Logger.getLogger("CustTest");
    ServiceFrame<String, Cust> service;

    @BeforeEach
        // 각각의 테스트 진행 시 반드시 실행
    void before() throws Exception {
        service = new CustServiceImpl();
        Cust inputCust = Cust.builder().id("id07").pwd("pwd05").name("james5").build();
        int result = service.register(inputCust);
    }

    @AfterEach
    void after() throws Exception {
        service.remove("id07");
    }

    @DisplayName("cust database insert test")
    @Test
    void insert() throws Exception {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            Cust inputCust = Cust.builder().id("id10").pwd("pwd05").name("james5").build();
            int result = service.register(inputCust);
            Assertions.assertEquals(1, result, "insert error");
        });
    }
}
