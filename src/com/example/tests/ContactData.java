package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String firstAdress;
	public String homePhoneNumber;
	public String mobilePhoneNumber;
	public String workPhoneNumber;
	public String firstEmail;
	public String secondEmail;
	public String groupName;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String secondAdress;
	public String homeNumber;
	
	
	public ContactData(){
		
	}
	public ContactData(String firstName, String lastName, String firstAdress, String homePhoneNumber,
		String mobilePhoneNumber, String workPhoneNumber, String firstEmail, String secondEmail, String groupName,
		String birthDay, String birthMonth, String birthYear, String secondAdress, String homeNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.firstAdress = firstAdress;
		this.homePhoneNumber = homePhoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.workPhoneNumber = workPhoneNumber;
		this.firstEmail = firstEmail;
		this.secondEmail = secondEmail;
		this.groupName = groupName;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.secondAdress = secondAdress;
		this.homeNumber = homeNumber;
	}
}