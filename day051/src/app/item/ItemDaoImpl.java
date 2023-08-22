package app.item;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import app.dto.Item;
import app.frame.DaoFrame;

public class ItemDaoImpl implements DaoFrame<Integer, Item> {

	@Override
	public int insert(Item v, SqlSession session) throws Exception {
		return session.insert("item.insert", v);
	}

	@Override
	public int update(Item v, SqlSession session) throws Exception {
		return session.update("item.update", v);
	}

	@Override
	public int delete(Integer k, SqlSession session) throws Exception {
		return session.insert("item.delete", k);
	}

	@Override
	public Item select(Integer k, SqlSession session) throws Exception {
		return session.selectOne("item.select", k);
	}

	@Override
	public List<Item> select(SqlSession session) throws Exception {
		return session.selectList("item.selectall");
	}

}
