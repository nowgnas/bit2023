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
        service = new CustServiceImpl();
    }

    @DisplayName("cust database insert test")
    @Test
    void insert() {
        Cust inputCust = Cust.builder().id("id05").pwd("pwd05").name("james5").build();
        try {
            service.register(inputCust);
        } catch (Exception e) {
            log.info(e.getMessage()); // 예외가 발생 했을 때의 처리가 서비스에서 중요하다
        }
    }

    @DisplayName("select by id")
    @Test
    void select() {
        Cust cust = null;
        try {
            cust = service.get("id01");
            Assertions.assertEquals("id01", cust.getId(), "id 조회 에러 ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("update information by id")
    @Test
    void update() {
        Cust inputCust = Cust.builder().id("id05").pwd("helloid05").name("newname5").build();
        try {
            service.modify(inputCust);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    @DisplayName("select all cust")
    @Test
    void selectAll() {
        try {
            List<Cust> list = service.get();
        } catch (Exception e) {
            log.info("전체 조회 실패");
            log.info(e.getMessage());
        }
    }

    @DisplayName("delete item by id")
    @Test
    void delete(){
        try{
            service.remove("id01");
        }catch (Exception e){
            log.info(e.getMessage());
        }
    }

    // database 연결 전 junit 테스트
//
//    @DisplayName("Insert Test")
//    @Test
//    void test() {
//        Cust inputCust = Cust.builder().id("id01").pwd("pwd01").name("james").build();
//        service.register(inputCust);
//        log.info("Insert Cust OK.... ");
//        Cust cust = service.get("id01");
//        Assertions.assertEquals(cust.getId(), inputCust.getId(), "Insert Error");
//    }
//
//    @DisplayName("select All Test")
//    @Test
//    void selectAll() {
//        List<Cust> list = null;
//        list = service.get();
//
//        log.info("Insert Cust OK.... ");
//        Assertions.assertTrue(list.size() == 4, "Select error");
//    }

}
