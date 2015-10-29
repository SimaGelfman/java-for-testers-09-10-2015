package com.example.fw;

import java.util.Scanner;
import java.util.*;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation(){
		click(By.linkText("add new"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.firstAdress);
		type(By.name("home"), contact.homePhoneNumber);
		type(By.name("mobile"), contact.mobilePhoneNumber);
		type(By.name("work"), contact.workPhoneNumber);
		type(By.name("email"), contact.firstEmail);
		type(By.name("email2"), contact.secondEmail);
		if(contact.groupName != null){
			selectByText(By.name("new_group"),contact.groupName);
		}
		if(contact.birthDay != null){
			selectByText(By.name("bday"), contact.birthDay);
		}
		if(contact.birthMonth != null){
			selectByText(By.name("bmonth"),contact.birthMonth);
		}
		type(By.name("byear"), contact.birthYear);
		type(By.name("address2"), contact.secondAdress);
		type(By.name("phone2"), contact.homeNumber);
	}

	public void goToHomePage() {
		click(By.linkText("home page"));
	}
	
	
	
	public void selectContactByIndex(int index){
		click(By.xpath("//table/descendant::input[@name= 'selected[]'][" + (index + 1) + "]"));
	}
	
	public void openContactEditPage(int index){
		click(By.xpath("//table/descendant::img[@alt= 'Edit'][" + (index + 1) + "]"));
	}

	public void deleteContact(int index){
		openContactEditPage(index);
		click(By.xpath("//form/descendant::input[@value='Delete']"));
	}
	
	

	public void initContactModification(int index) {
		openContactEditPage(index);
	}
	
	

	public void submitContactModification() {
		click(By.xpath("//form/descendant::input[@value='Update']"));		
	}
	
	

}
