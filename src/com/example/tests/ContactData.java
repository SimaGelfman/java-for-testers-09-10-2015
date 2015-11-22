package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	
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
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	//	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	//	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	public void printContact(){
		System.out.print(firstName + " " + lastName + "\t"); 
	}
	
	@Override
	public int compareTo(ContactData other) {
		int res =  this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		if (res != 0) {
		  return res;
		}
		return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
	}
	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	public ContactData withFirstName(String firstName){
		this.firstName = firstName;
		return this;
	}
	
	public ContactData withLastName(String lastName){
		this.lastName = lastName;
		return this;
	}
	
	public ContactData withFirstAdress(String firstAdress){
		this.firstAdress = firstAdress;
		return this;
	}
	
	public ContactData withHomePhoneNumber(String homePhoneNumber){
		this.homePhoneNumber = homePhoneNumber;
		return this;
	}
	
	public ContactData withMobilePhoneNumber(String mobilePhoneNumber){
		this.mobilePhoneNumber = mobilePhoneNumber;
		return this;
	}
	
	
	public ContactData withWorkPhoneNumber(String workPhoneNumber){
		this.workPhoneNumber = workPhoneNumber;
		return this;
	}
	
	public ContactData withFirstEmail(String firstEmail){
		this.firstEmail = firstEmail;
		return this;
	}
	
	public ContactData withSecondEmail(String secondEmail){
		this.secondEmail = secondEmail;
		return this;
	}
	
	public ContactData withGroupName(String groupName){
		this.groupName = groupName;
		return this;
	}
	
	public ContactData withBirthDay(String birthDay){
		this.birthDay = birthDay;
		return this;
	}
	
	public ContactData withBirthMonth(String birthMonth){
		this.birthMonth = birthMonth;
		return this;
	}
	
	public ContactData withBirthYear(String birthYear){
		this.birthYear = birthYear;
		return this;
	}

	public ContactData withSecondAdress(String secondAdress){
		this.secondAdress = secondAdress;
		return this;
	}
	
	public ContactData withHomeNumber(String homeNumber){
		this.homeNumber = homeNumber;
		return this;
	}

}