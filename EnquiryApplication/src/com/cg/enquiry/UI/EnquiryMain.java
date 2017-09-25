package com.cg.enquiry.UI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.enquiry.DTO.EnquiryDetails;
import com.cg.enquiry.exception.EnquiryApplicationException;
import com.cg.enquiry.service.EnquiryServiceImpl;
import com.cg.enquiry.service.IEnquiryService;





public class EnquiryMain {
	
	static Scanner sc=new Scanner(System.in);
	static EnquiryDetails details;
	static IEnquiryService service;
	static int choice=0;
	
	public static void main(String[] args) throws EnquiryApplicationException, IOException, SQLException{
		
		
		System.out.println("Equiry Application");
		System.out.println("******************");
		
		while(true)
		{
			System.out.println("1.Enter Enquiry Details");
			System.out.println("2.Get the Enquiry Details");
			System.out.println("3.Get Enquiry Details by ID");
			System.out.println("4.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:addEnquiryDetails();
					break;
			case 2:getEnquiryDetailsByAll();
					break;
			case 3:getEnquiryDetailsById();
				    break;
			case 4:System.out.println("Thank you for selecting us!!!");
				   System.exit(0);
				   	break;
		}
	  }
	}


	private static void getEnquiryDetailsById() {
		
service =new  EnquiryServiceImpl();
    	
		System.out.println("Enter the id");
		int id = sc.nextInt();
    	ArrayList<EnquiryDetails> list=null;
    	
		list=service.retriveDetails(id);
		
    	for(EnquiryDetails m:list)
    	{
    		System.out.println(m.getEnquiryId());
    		System.out.println(m.getFirstName());
    		System.out.println(m.getLastName());
    		System.out.println(m.getPhoneNo());
    		System.out.println(m.getDomain());
    		System.out.println(m.getLocation());
    }
		
		
	}

	private static void getEnquiryDetailsByAll() throws SQLException, IOException {
			service =new  EnquiryServiceImpl();
    	
    	ArrayList<EnquiryDetails> list=null;
    	
		list=service.retriveDetails();
		
    	for(EnquiryDetails m:list)
    	{
    		System.out.println(m.getEnquiryId());
    		System.out.println(m.getFirstName());
    		System.out.println(m.getLastName());
    		System.out.println(m.getPhoneNo());
    		System.out.println(m.getDomain());
    		System.out.println(m.getLocation());
    }
    	
    	
}
	private static void addEnquiryDetails() throws EnquiryApplicationException, IOException {
	
		int res=0;
		
		System.out.println("Enter First Name");
		String firstName=sc.next();
		
		System.out.println("Enter last name ");
		String lastName=sc.next();
		
		System.out.println("Enter Phone Number ");
		String phoneNo=sc.next();
		
		System.out.println("Enter your preferred domain");
		String domain=sc.next();
		
		System.out.println("Enter your preferred location");
		String location=sc.next();
		
		details=new EnquiryDetails(firstName, lastName, phoneNo, domain, location);
		service=new EnquiryServiceImpl();
		
		res = service.addEnquiryDetails(details);
		
		System.out.println(res+" rows inserted");
		System.out.println("Thank you " +firstName  + lastName+ " your unique Id is ");
		
	}
}


