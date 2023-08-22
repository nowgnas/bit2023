package app.cust;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import app.dto.Cust;
import app.frame.DaoFrame;
import app.frame.GetSessionFacroty;
import app.frame.ServiceFrame;

public class CustServiceImpl implements ServiceFrame<String, Cust>{

	DaoFrame<String,Cust> dao;
	SqlSession session;
	
	public CustServiceImpl() {
		dao = new CustDaoImpl();
	}
	public CustServiceImpl(CustDaoImpl dao) {
		this.dao = dao;
	}
	
	@Override
	public int register(Cust v) throws Exception {
		session = GetSessionFacroty.getInstance().openSession();
		int result = 0;

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
	public int modify(Cust v) throws Exception {
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
	public int remove(String k) throws Exception {
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
	public Cust get(String k) throws Exception {
		session = GetSessionFacroty.getInstance().openSession();

		Cust cust = null;
		try {
			cust = dao.select(k, session);
		}catch(Exception e) {
			throw new Exception("ER0003");
		}finally {
			session.close();
		}
		return cust;
	}

	@Override
	public List<Cust> get() throws Exception {
		session = GetSessionFacroty.getInstance().openSession();

		List<Cust> list = null;
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
