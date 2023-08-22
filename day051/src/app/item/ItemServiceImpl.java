package app.item;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import app.dto.Item;
import app.frame.DaoFrame;
import app.frame.GetSessionFacroty;
import app.frame.ServiceFrame;

public class ItemServiceImpl implements ServiceFrame<Integer, Item>{

	DaoFrame<Integer,Item> dao;
	SqlSession session;
	
	public ItemServiceImpl() {
		dao = new ItemDaoImpl();
	}
	
	@Override
	public int register(Item v) throws Exception {
		int result = 0;
		session = GetSessionFacroty.getInstance().openSession();
		try {
			result = dao.insert(v, session);
			session.commit();	
		}catch(Exception e) {
			session.rollback();
			throw new Exception("ER0001");
		}finally {
			session.close();
		}
		return result;
	}

	@Override
	public int modify(Item v) throws Exception {
		session = GetSessionFacroty.getInstance().openSession();
		int result = 0;

		try {
			result = dao.update(v, session);
			session.commit();	
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new Exception("ER0001");
		}finally {
			session.close();
		}
		return result;
	}

	@Override
	public int remove(Integer k) throws Exception {
		session = GetSessionFacroty.getInstance().openSession();
		int result = 0;

		try {
			result = dao.delete(k, session);
			session.commit();	
		}catch(Exception e) {
			session.rollback();
			throw new Exception("ER0001");
		}finally {
			session.close();
		}
		return result;
	}

	@Override
	public Item get(Integer k) throws Exception {
		session = GetSessionFacroty.getInstance().openSession();

		Item item = null;
		try {
			item = dao.select(k, session);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("ER0003");
		}finally {
			session.close();
		}
		return item;
	}

	@Override
	public List<Item> get() throws Exception {
		session = GetSessionFacroty.getInstance().openSession();

		List<Item> list = null;
		try {
			list = dao.select(session);
		}catch(Exception e) {
			throw new Exception("ER0003");
		}finally {
			session.close();
		}
		return list;
	}

}
