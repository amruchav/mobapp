package com.cg.frs.DAO;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.orb.DTO.Room_Registration;

public interface IRoomRegistrationDAO {

	public int addRoomRegistrationDetails(Room_Registration details) throws SQLException, IOException;

}
