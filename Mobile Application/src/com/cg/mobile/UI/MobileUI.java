package com.cg.mobile.UI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.mobile.DTO.MobileDetails;
import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.DbUtil.DbUtil;
import com.cg.mobile.exception.MobileApplicationException;
import com.cg.mobile.service.IMobileService;
import com.cg.mobile.service.MobileServiceImpl;

public class MobileUI {
	
	static Scanner sc;
	static PurchaseDetails details;
	static IMobileService service;
	static int choice=0;
	
	
	
	public static void main(String[] args) throws MobileApplicationException, SQLException, IOException {
		
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Mobile Application");
		System.out.println("******************");
		
		while(true)
		{
			System.out.println("1.Enter Purchase Details");
			System.out.println("2.Get the Mobile Details");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:addPurchaseDetails();
					break;
			case 2:getMobileDetails();
					break;
			case 3:System.out.println("Thank you");
				   System.exit(0);
				   	break;
		}
	  }
	}
	private static void addPurchaseDetails() throws MobileApplicationException {
		
		int res;
		try 
		{
		service= new MobileServiceImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Customer Name");
		String cName=sc.next();
		if(service.validateName(cName))
		{
		System.out.println("Enter MailId");
		String mailId=sc.next();
		if(service.validateEmail(mailId))
		{
		System.out.println("Enter Phone Number ");
		long phoneNo=sc.nextLong();
		String num=String.valueOf(phoneNo);
		if(service.validatePhoneNo(num))
		{
		System.out.println("Enter Mobile Id");
		int mobileId=sc.nextInt();
		String num1=String.valueOf(mobileId);
		if(service.validateMobileId(num1))
		{
		details=new PurchaseDetails(cName,mailId,phoneNo,mobileId);
		service=new MobileServiceImpl();
		
			res = service.addPurchaseDetails(details);
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
		   }
		  }
	     }
		}
		catch (Exception e) {
			
			
			throw new MobileApplicationException("Exception Occured ");
		}
		
	}   
   
	
    private static void getMobileDetails() throws SQLException, IOException{
    	
    	service =new  MobileServiceImpl();
    	
    	ArrayList<MobileDetails> list=null;
    	
		list=service.retriveDetails();
		
    	for(MobileDetails m:list)
    	{
    		System.out.println(m.getMobileId());
    		System.out.println(m.getName());
    		System.out.println(m.getPrice());
    		System.out.println(m.getQuantity());
    }
    	
    	
	}
}
