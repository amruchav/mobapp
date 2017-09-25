package com.cg.orb.SERVICE;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.orb.DTO.Room_Registration;

public interface IRoomRegistrationService {
	
	public int addRoomRegistrationDetails(Room_Registration details) throws SQLException, IOException;

}
