package com.cg.enquiry.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.enquiry.DTO.EnquiryDetails;
import com.cg.enquiry.exception.EnquiryApplicationException;

public interface IEnquiryDAO {

	public int addEnquiryDetails(EnquiryDetails details) throws EnquiryApplicationException;

	public ArrayList<EnquiryDetails> retriveDetails() throws SQLException, IOException;

	public ArrayList<EnquiryDetails> retriveDetails(int id);

}
