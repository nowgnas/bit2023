package item;

import dto.Item;
import frame.DaoFrame;
import frame.ServiceFrame;

import java.util.List;

public class ItemService implements ServiceFrame<String, Item> {
    DaoFrame<String, Item> dao;

    public ItemService() {
        this.dao = new ItemDao();
    }

    @Override
    public void register(Item item) {
        dao.insert(item);

    }

    @Override
    public void modify(Item item) {
        dao.update(item);
    }

    @Override
    public void remove(String s) {
        dao.delete(s);
    }

    @Override
    public Item get(String s) {
        return dao.select(s);

    }

    @Override
    public List<Item> get() {
        return dao.select();
    }
}
