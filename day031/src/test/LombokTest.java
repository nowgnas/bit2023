package test;

import app.dto.Cust;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;


class LombokTest {

    Logger logger = Logger.getLogger("LombokTest");

    @Test
    void test() {
        Cust cust = Cust.builder()
                .id("id01")
                .pwd("pwd01")
                .name("james")
                .build();
        logger.info(cust.toString());
        assertEquals("Error! ", cust.getId(), "id01");
    }

}
