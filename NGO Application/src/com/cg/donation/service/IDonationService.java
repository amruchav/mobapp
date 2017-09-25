package com.cg.donation.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.donation.DTO.DonorDetails;
import com.cg.donation.exception.NGOApplicationException;

public interface IDonationService {
	
		public  int addDonorDetails(DonorDetails details) throws NGOApplicationException, SQLException, IOException;

		public ArrayList<DonorDetails> retrieveDetails(); 
			
		}		
		

	


