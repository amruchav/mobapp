package com.cg.orb.SERVICE;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.cg.frs.DAO.IRoomRegistrationDAO;
import com.cg.frs.DAO.RoomRegistrationDAOImpl;
import com.cg.orb.DTO.Room_Registration;

public class RoomRegistrationServiceImpl implements IRoomRegistrationService {
	
	IRoomRegistrationDAO dao=null;

	public int addRoomRegistrationDetails(Room_Registration details) throws SQLException, IOException {
		
		dao =new RoomRegistrationDAOImpl();
		return dao.addRoomRegistrationDetails(details);
		
	}
	
	public boolean validatehotel_ID(String hotel_ID)
	{
		
		String hotel_IDpattern="[1 || 2 || 3]";
		if(Pattern.matches(hotel_IDpattern, hotel_ID))
		{
			return true;
		}
		else
		{
			System.out.println("hotel owner id does not exists");
			return false;
		}
	}
	
	public boolean validateAmount(float RENT_AMOUNT,float Paid_AMOUNT)
	{
		
		if(Paid_AMOUNT > RENT_AMOUNT )
		{
			return true;
		}
		else
		{
			System.out.println("Paid amount cannot be less than rent amount ");
			return false;
		}
	}

}
