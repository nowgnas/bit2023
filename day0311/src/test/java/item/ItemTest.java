//package item;
//
//import dto.Item;
//import frame.ServiceFrame;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.logging.Logger;
//
//public class ItemTest {
//    Logger log = Logger.getLogger("ItemTest");
//    ServiceFrame<String, Item> service;
//
//    @BeforeEach
//    void before() {
//        service = new ItemService();
//    }
//
//    @DisplayName("insert test ...")
//    @Test
//    void insert() {
//        Item item = Item.builder()
//                .id(1)
//                .name("name")
//                .price(12345)
//                .build();
//        service.register(item);
//        Item item1 = service.get(String.valueOf(1));
//
//        Assertions.assertEquals(item.getId(), item1.getId(), "insert error ...");
//
//
//    }
//}
