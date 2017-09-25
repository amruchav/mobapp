package com.cg.donation.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.donation.DAO.DonationDAOImpl;
import com.cg.donation.DAO.IDonationDAO;
import com.cg.donation.DTO.DonorDetails;
import com.cg.donation.exception.NGOApplicationException;


public class DonationServiceImpl implements IDonationService,IDonationDAO {

	 IDonationDAO dao=null;
		
	public int addDonorDetails(DonorDetails details) throws NGOApplicationException, SQLException, IOException{
		
		dao =new DonationDAOImpl();
		return dao.addDonorDetails(details);
		
		
	}

	@Override
	public ArrayList<DonorDetails> retrieveDetails() {
		
		dao =new DonationDAOImpl();
		return dao.retrieveDetails();
	}
	
}
