package com.cg.donation.DTO;

import java.time.LocalDate;

public class DonorDetails {
	
	private int donorId;
	private String donorName;
	private String phoneNo;
	private String address;
	private String donationAmount;
	private String donationDate;
	

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}


	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(String donationAmount) {
		this.donationAmount = donationAmount;
	}

	public String getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}

	public DonorDetails(int donorId, String donorName, String phoneNo,
			String address, String donationAmount, String donationDate) {
		super();
		this.donorId = donorId;
		this.donorName = donorName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.donationAmount = donationAmount;
		this.donationDate = donationDate;
	}

	public DonorDetails(String donorName, String phoneNo, String address,
			String donationAmount) {
		super();
		this.donorName = donorName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.donationAmount = donationAmount;
	}

	public DonorDetails() {
		
	}

	
	
	
}
