package com.cg.frs.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.orb.DTO.Room_Registration;
import com.cg.orb.DbUtil.DbUtil;

public class RoomRegistrationDAOImpl implements IRoomRegistrationDAO {

	int result=0, Room_NO=0;
	@Override
	public int addRoomRegistrationDetails(Room_Registration details) throws SQLException, IOException
 {
		
		
	
		Connection conn = null;
	
			conn = DbUtil.getConnection();

			String insertQuery="Insert into Room_Registration Values(room_SEQ.nextval,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(insertQuery);
			
			ps.setInt(2,details.getRoom_TYPE());
			ps.setInt(3,details.getRoom_AREA());
			ps.setFloat(4,details.getRENT_AMOUNT());
			ps.setFloat(5,details.getPaid_AMOUNT());
			ps.executeUpdate();
			
		    String sql ="select room_SEQ.nextval from Room_Registration";
		    
		    PreparedStatement ps1=conn.prepareStatement(sql);
		    ResultSet rs=ps1.executeQuery();
		    while(rs.next())
		    {
		    	Room_NO=rs.getInt(1);
		    	System.out.println(result);
		    }
			return Room_NO;  
	}

}
