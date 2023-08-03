package item;

import dto.Item;
import frame.DaoFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ItemDao implements DaoFrame<String, Item> {
    Logger logger = Logger.getLogger("ItemDao");

    @Override
    public void insert(Item item) {
        logger.info("insert item" + item.toString());
    }

    @Override
    public void update(Item item) {
        logger.info("update item " + item.toString());

    }

    @Override
    public void delete(String s) {
        logger.info("delete item " + s);

    }

    @Override
    public Item select(String s) {
        return Item.builder()
                .id(1)
                .name("name")
                .price(12345)
                .build();
    }

    @Override
    public List<Item> select() {
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Item.builder()
                    .id(1)
                    .name("name")
                    .price(12345)
                    .build());
        }

        return list;
    }
}
