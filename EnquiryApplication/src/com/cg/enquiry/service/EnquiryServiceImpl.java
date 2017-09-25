package com.cg.enquiry.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.enquiry.DAO.EnquiryDAOImpl;
import com.cg.enquiry.DAO.IEnquiryDAO;
import com.cg.enquiry.DTO.EnquiryDetails;
import com.cg.enquiry.exception.EnquiryApplicationException;


public class EnquiryServiceImpl implements IEnquiryService {
	
	IEnquiryDAO dao;

	@Override
	public int addEnquiryDetails(EnquiryDetails details) throws EnquiryApplicationException {
		
		dao=new EnquiryDAOImpl();
		return dao.addEnquiryDetails(details);
		
	}
	
	public ArrayList<EnquiryDetails> retriveDetails() throws SQLException, IOException {
		IEnquiryDAO dao=new EnquiryDAOImpl(); 
		return dao.retriveDetails();
	}

	@Override
	public ArrayList<EnquiryDetails> retriveDetails(int id) {
		// TODO Auto-generated method stub
		IEnquiryDAO dao=new EnquiryDAOImpl(); 
		return dao.retriveDetails(id);
	}

}
