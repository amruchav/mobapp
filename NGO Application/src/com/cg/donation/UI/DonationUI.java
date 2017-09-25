package com.cg.donation.UI;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.donation.DTO.DonorDetails;
import com.cg.donation.exception.NGOApplicationException;
import com.cg.donation.service.DonationServiceImpl;
import com.cg.donation.service.IDonationService;


public class DonationUI {
	
	static DonorDetails details; 				//bean object
	static IDonationService service;		//service layer object
	static int choice=0;
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException, IOException, NGOApplicationException {
		
		System.out.println("NGO Application");
		System.out.println("******************");
		while(true)
		{
			System.out.println("1.Enter Donor Details");
			System.out.println("2.Get Donor Details");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:addDonorDetails();
					break;
			case 2:getDonorDetails();
					break;
			case 3:System.out.println("Thank you");
			       System.exit(0);
			   	   break;
		}
	  }
	}
	
	private static void getDonorDetails() {
		
		service=new DonationServiceImpl();
		
		ArrayList<DonorDetails> list = service.retrieveDetails();
		
		for(DonorDetails out:list){
			
			System.out.println(out.getDonorId());
			System.out.println(out.getDonorName());
			System.out.println(out.getPhoneNo());
			System.out.println(out.getAddress());
			System.out.println(out.getDonationAmount());
			System.out.println(out.getDonationDate());
		}
		
	}



	private static void addDonorDetails() throws SQLException, IOException, NGOApplicationException{
		
		
		int res=0;
		
		try{
		
			
		System.out.println("Enter Donor name");
		String donorName=sc.next();
		
		System.out.println("Enter Phone Number ");
		String phoneNo=sc.next();

		System.out.println("Enter Donor Address");
		String address=sc.next();
		
		System.out.println("Enter Donation Amount");
		String donationAmount=sc.next();
		
		details=new DonorDetails(donorName,phoneNo,address,donationAmount);
		service=new DonationServiceImpl();
		
		res = service.addDonorDetails(details);
		System.out.println(res+" inserted");
	   
		if(res==1)
	   {
		System.out.println("Value added in database");
	   }
	    else
	    {
		System.out.println("Value not added");
	    }
		}
		catch (NGOApplicationException e) {
			throw new NGOApplicationException("Exception Occured ");
	
		
	}
}
}


