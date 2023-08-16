package cust;

import static org.junit.Assert.*;

import org.junit.Test;

import app.cust.CustServiceImpl;
import app.dto.Cust;

public class CustSelect {

	
	
	@Test
	public void test() {
		CustServiceImpl service;
		service = new CustServiceImpl();
		
		Cust data = new Cust("id16","pwd16","james");
		
		try {
			service.register(data);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		Cust cust = null;
		
		try {
			cust = service.get("id16");
			System.out.println(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}







