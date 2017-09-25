package com.cg.donation.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.donation.DTO.DonorDetails;
import com.cg.donation.DbUtil.DbUtil;
import com.cg.donation.exception.NGOApplicationException;





public class DonationDAOImpl implements IDonationDAO {
	
	public int addDonorDetails(DonorDetails details) throws NGOApplicationException  {
		int result=0;
		Connection conn = null;
		
			try {
				conn = DbUtil.getConnection();
			
			String insertQuery="Insert into DonorDetails Values(donor_seq_id.nextval,?,?,?,?,SYSDATE)";
			PreparedStatement ps=conn.prepareStatement(insertQuery);
			ps.setString(1,details.getDonorName());
			ps.setString(2,details.getPhoneNo());
			ps.setString(3,details.getAddress());
			ps.setString(4,details.getDonationAmount());
			result = ps.executeUpdate();
			 System.out.println(result+" rows inserted");
			   
			
			} catch (SQLException e) {
				
				e.printStackTrace();

             } catch (IOException e) {
			
				 throw new NGOApplicationException(e.getMessage());
			}
		    return result;
		}

	@Override
	public ArrayList<DonorDetails> retrieveDetails() {
		
		ArrayList<DonorDetails> list=new ArrayList<DonorDetails>();
		try
		{
		Connection con = DbUtil.getConnection();
		String sql="Select * from donordetails";

		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			int donorId = rs.getInt(1);
			String donorName=rs.getString(2);
			String phoneNo=rs.getString(3);
			String address=rs.getString(4);
			String donationAmount=rs.getString(5);
			String donationDate=rs.getString(6);
			
			list.add(new DonorDetails(donorId, donorName, phoneNo, address, donationAmount, donationDate));
			//list.add(new DonorDetails(mid,name,price,quantity));
			
		}
		}
		catch(SQLException | IOException e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}
		
	
		
		
	}
	


