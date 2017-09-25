package com.cg.mobile.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.mobile.DTO.MobileDetails;
import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.DbUtil.DbUtil;
import com.cg.mobile.exception.MobileApplicationException;

public class MobileDaoImpl implements IMobileDAO {
	
	
	Logger logger = Logger.getRootLogger();
	public MobileDaoImpl() 
	{
		PropertyConfigurator.configure("Log4j.properties");
	}
	

	public int addPurchaseDetails(PurchaseDetails p) throws MobileApplicationException  {
		int result=0;
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();

			String insertQuery="Insert into PurchaseDetails Values(seq_id.nextval,?,?,?,SYSDATE,?)";
			PreparedStatement ps=conn.prepareStatement(insertQuery);
			ps.setString(1,p.getcName());
			ps.setString(2,p.getMailId());
			ps.setLong(3,p.getPhoneNo());
		    String sql ="select mobileId from Mobiles where mobileId=?";
		    
		    PreparedStatement ps1=conn.prepareStatement(sql);
		    ps1.setInt(1,p.getMobileId());
		    ResultSet rs=ps1.executeQuery();
		    while(rs.next())
		    {
		    	ps.setInt(4, rs.getInt(1));
		    	 result = ps.executeUpdate();
		    	//System.out.println(result);
		    }  
		    logger.info("Executed Successfully");
		} 
		
		catch (IOException e) {
			
			logger.error("Exception Occured " +e.getMessage());
		} 
		
		catch (SQLException e) {
			
			logger.error("Exception Occured  " +e.getMessage());
      throw new MobileApplicationException(e.getMessage());
			
		}
		return result; 
	}

	@Override
	public ArrayList<MobileDetails> retriveDetails() {
		ArrayList<MobileDetails> list=new ArrayList<MobileDetails>();
		try
		{
		Connection con = DbUtil.getConnection();
		String sql="Select * from mobiles";

		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			int mid=rs.getInt(1);
			String name=rs.getString(2);
			int price=rs.getInt(3);
			String quantity=rs.getString(4);
			list.add(new MobileDetails(mid,name,price,quantity));
			
		}
		}
		catch(SQLException | IOException e)
		{
			logger.error("Error");
			System.out.println(e.getMessage());
		}
		return list;
		
	}


}
