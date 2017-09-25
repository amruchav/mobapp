package com.cg.orb.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.orb.dto.RoomRegistrationDTO;
import com.cg.orb.service.IRoomRegistrationService;
import com.cg.orb.service.RoomRegistrationServiceImpl;

public class Client 
{
	static Scanner sc=new Scanner(System.in);
	static int choice=0;
	static RoomRegistrationDTO flat=null;
	static IRoomRegistrationService Service=new RoomRegistrationServiceImpl();
	public static void main(String[] args) 
	{
		System.out.println("Room Registration Application");
		while(true)
		{
			System.out.println("1.Booking Room");
			System.out.println("2.Exit");
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:getRoomDetails();
			break;
			case 2:
				System.exit(0);
			break;
			}
		}
	}
		private static void getRoomDetails() {
			try {
		sc.nextLine();
		System.out.println("Existing HotelOwner IDS Are:-[1, 2, 3]");
		
		System.out.println("Please enter your hotel owner id from above list:");
		int id=sc.nextInt();
		if(Service.validateownerId(id))
		{
		System.out.println("Select  room type Type (1-1AC, 2-2NON-AC):");
		int type=sc.nextInt();
		if(Service.validateRoomType(type))
		{
		System.out.println("Enter room area in sq. ft.:");
		int area=sc.nextInt();
		
		System.out.println("Enter desired rent amount Rs:");
		float rent=sc.nextInt();
		System.out.println("Enter desired paid amount Rs:");
		float paid=sc.nextInt();
		if(Service.validateTotalamount(rent,paid))
		{
			flat=new RoomRegistrationDTO(id,type,area,rent,paid);
			Service=new RoomRegistrationServiceImpl();
			int	res = Service.registerRoom(flat);
			System.out.println("Room no: "+res);
			
			if(res>0)
			{
				System.out.println("Value added in database");
				//System.out.println("Room Successfully Registered.Room No:<" +room_no+">");
			}
			else
			{
				System.out.println("Value not added");
			}
			
		} 
		}
		}
		}
		catch (IOException e) 
		{
				
				e.printStackTrace();
				
			}
		catch (SQLException e) 
		{
				
				e.printStackTrace();
				
			}
			}
		}
			
			
package com.cg.frs.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.orb.dto.RoomRegistrationDTO;

public interface IRoomRegistrationDAO {
int registerRoom(RoomRegistrationDTO flat) throws IOException, SQLException;
}




package com.cg.frs.dao;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;



import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.frs.DbUtil.DbUtil;
import com.cg.orb.dto.RoomRegistrationDTO;

public class RoomRegistrationDAOImpl implements IRoomRegistrationDAO{
	Connection conn=null;
	int result=0, id=0;
	@Override
	public int registerRoom(RoomRegistrationDTO flat) throws IOException, SQLException {
		
		conn=DbUtil.getConnection();
		String insertQuery="Insert into room_registration values(room_no.nextval,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(insertQuery);
		ps.setInt(1,flat.getHotelId());
		ps.setInt(2,flat.getRoomType());
		ps.setInt(3,flat.getRoomArea());
		ps.setFloat(4, flat.getRentAmount());
		ps.setFloat(5, flat.getPaidAmount());
		result = ps.executeUpdate();
		System.out.println(result);
		String selectQuery = "SELECT room_no.CURRVAL FROM room_registration";
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);
		
		if(rs.next()){
			id = rs.getInt(1);
		}
		
		
		System.out.println("Room successfully registered.");
		return id;
		
	}

}




package com.cg.orb.dto;

public class RoomRegistrationDTO {
private int roomNumber;
private int hotelId;
private int roomType;
private int roomArea;
private float rentAmount;
private float paidAmount;
public int getRoomNumber() {
	return roomNumber;
}
public void setRoomNumber(int roomNumber) {
	this.roomNumber = roomNumber;
}
public int getHotelId() {
	return hotelId;
}
public void setHotelId(int hotelId) {
	this.hotelId = hotelId;
}
public int getRoomType() {
	return roomType;
}
public void setRoomType(int roomType) {
	this.roomType = roomType;
}
public int getRoomArea() {
	return roomArea;
}
public void setRoomArea(int roomArea) {
	this.roomArea = roomArea;
}
public float getRentAmount() {
	return rentAmount;
}
public void setRentAmount(float rentAmount) {
	this.rentAmount = rentAmount;
}
public float getPaidAmount() {
	return paidAmount;
}
public void setPaidAmount(float paidAmount) {
	this.paidAmount = paidAmount;
}
public RoomRegistrationDTO(int hotelId, int roomType, int roomArea,
		float rentAmount, float paidAmount) {
	super();
	this.hotelId = hotelId;
	this.roomType = roomType;
	this.roomArea = roomArea;
	this.rentAmount = rentAmount;
	this.paidAmount = paidAmount;
}
public RoomRegistrationDTO() {
	
}


}





package com.cg.orb.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.orb.dto.RoomRegistrationDTO;

public interface IRoomRegistrationService {
	int registerRoom(RoomRegistrationDTO flat) throws IOException, SQLException;

	boolean validateownerId(int id);

	boolean validateRoomType(int type);

	boolean validateTotalamount(float rent, float paid);
}


package com.cg.orb.service;


import java.io.IOException;
import java.sql.SQLException;

import com.cg.frs.dao.IRoomRegistrationDAO;
import com.cg.frs.dao.RoomRegistrationDAOImpl;
import com.cg.orb.dto.RoomRegistrationDTO;

public class RoomRegistrationServiceImpl implements IRoomRegistrationService {
	IRoomRegistrationDAO dao=null;
	@Override
	public int registerRoom(RoomRegistrationDTO flat) throws IOException, SQLException {
		dao=new RoomRegistrationDAOImpl();
		return dao.registerRoom(flat);
		
		
	}

	@Override
	public boolean validateownerId(int id) {
		if(id==1||id==2||id==3)
		{
			return true;
		}
		else{
			System.out.println("Hotel Owner ID does not exist");
			return false;
	}
	}

	@Override
	public boolean validateRoomType(int type) {
		if(type==1||type==2)
		{
			return true;
		}
		else
		{
			System.out.println("Please select from these two mentioned only");
			return false;
		}
		
	}

	@Override
	public boolean validateTotalamount(float rent, float paid) {
		if(paid>rent)
		{
			return true;
		}
		else
		{
			System.out.println("Paid amount should not be less than rent amount.");
			return false;
		}
		
	}

}

		
		
		
	
