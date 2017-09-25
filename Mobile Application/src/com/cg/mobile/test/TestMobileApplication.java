package com.cg.mobile.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.dao.IMobileDAO;
import com.cg.mobile.dao.MobileDaoImpl;
import com.cg.mobile.exception.MobileApplicationException;


public class TestMobileApplication {
	static IMobileDAO dao=null;
	static PurchaseDetails bean=null;
	
	@BeforeClass
	public static void initialize() throws MobileApplicationException
	{
		
		dao=new MobileDaoImpl();
		bean=new PurchaseDetails();
	}
	
	@Test
	public void test() {
		
		bean.setcName("Amruta");
		bean.setMailId("shh@gm.com");
		bean.setMobileId(1001);
		bean.setPhoneNo(1234567895);
		bean.setPurchesId(1061);
		
		
	}
	
	@Test

		public void testAddDetails() throws MobileApplicationException
		{
		 assertNotNull(dao.addPurchaseDetails(bean));
		 
		}
	@Test
	public void getDetails() throws SQLException, IOException
	{
		assertNotNull(dao.retriveDetails());
	}
	
}
