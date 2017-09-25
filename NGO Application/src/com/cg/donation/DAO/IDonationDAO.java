package com.cg.donation.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.donation.DTO.DonorDetails;
import com.cg.donation.exception.NGOApplicationException;

public interface IDonationDAO {
  
	public int addDonorDetails(DonorDetails details) throws SQLException, IOException, NGOApplicationException;

	public ArrayList<DonorDetails> retrieveDetails(); 
		
	
}
