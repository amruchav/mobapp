package com.cg.enquiry.DAO;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.enquiry.DTO.EnquiryDetails;
import com.cg.enquiry.DbUtil.DbUtil;
import com.cg.enquiry.exception.EnquiryApplicationException;



public class EnquiryDAOImpl implements IEnquiryDAO{
	
	Logger logger = Logger.getRootLogger();
	public EnquiryDAOImpl() 
	{
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	

	@Override
	public int addEnquiryDetails(EnquiryDetails details) throws EnquiryApplicationException{
			int result=0;
			Connection conn = null;
			try {
				conn = DbUtil.getConnection();

				String insertQuery="Insert into EnquiryDetails Values(enquiry_id.nextval,?,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(insertQuery);
				ps.setString(1,details.getFirstName());
				ps.setString(2,details.getLastName());
				ps.setString(3,details.getPhoneNo());
				ps.setString(4,details.getDomain());
				ps.setString(5,details.getLocation());
			    result = ps.executeUpdate();
			    
			    logger.info("Executed Successfully");
			   // System.out.println(result);
			     
			} catch (IOException e) {
				
				logger.error("Exception Occured " +e.getMessage());
			} 
			
			catch (SQLException e) {
				
				logger.error("Exception Occured " +e.getMessage());
			throw new EnquiryApplicationException("Exception Occurred");
				
			}

			return result; 
		}

	@Override
	public ArrayList<EnquiryDetails> retriveDetails()  {
		
	
		ArrayList<EnquiryDetails> list=new ArrayList<EnquiryDetails>();
		try
		{
		Connection con = DbUtil.getConnection();
		String sql="Select * from EnquiryDetails";

		//Statement st=con.createStatement();
		//ResultSet rs = st.executeQuery(sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int enquiryId=rs.getInt(1);
			String firstName=rs.getString(2);
			String lastName=rs.getString(3);
			String phoneNo=rs.getString(4);
			String domain=rs.getString(5);
			String location=rs.getString(6);
			list.add(new EnquiryDetails(enquiryId,firstName,lastName,phoneNo,domain,location));
			
		}
		}
		catch(SQLException | IOException e)
		{
			System.out.println(e.getMessage());
		}
		return list;
		
	}

	@Override
	public ArrayList<EnquiryDetails> retriveDetails(int id) {
		// TODO Auto-generated method stub
		ArrayList<EnquiryDetails> list=new ArrayList<EnquiryDetails>();
		try
		{
		Connection con = DbUtil.getConnection();
		String sql="Select * from EnquiryDetails WHERE enquiryId = ?";

		//Statement st=con.createStatement();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int enquiryId=rs.getInt(1);
			String firstName=rs.getString(2);
			String lastName=rs.getString(3);
			String phoneNo=rs.getString(4);
			String domain=rs.getString(5);
			String location=rs.getString(6);
			list.add(new EnquiryDetails(enquiryId,firstName,lastName,phoneNo,domain,location));
			
		}
		}
		catch(SQLException | IOException e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}

}


