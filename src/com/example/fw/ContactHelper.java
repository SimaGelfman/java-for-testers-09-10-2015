package com.example.fw;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

public static boolean CREATION = true;
public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private List<ContactData> cachedContacts;

	
	public List<ContactData> getContactList() {
		if(cachedContacts == null){
			rebuildCach();
		}
		return cachedContacts;
	}
	
	private void rebuildCach() {
		cachedContacts = new ArrayList<ContactData>();
		List<WebElement> trs = driver.findElements(By.xpath("//tr[@name='entry']"));
		String fname = "", lname = "";
		for(WebElement tr: trs){
			ContactData contact = new ContactData();
			lname = tr.findElement(By.xpath(".//td[2]")).getText();
			fname = tr.findElement(By.xpath(".//td[3]")).getText();
			contact.firstName = fname;
			contact.lastName = lname;
			cachedContacts.add(contact);
		}
		
	}

	
	//----------------------------------
	
	public void fillContactForm(ContactData contact, boolean typeForm) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.firstAdress);
		type(By.name("home"), contact.homePhoneNumber);
		type(By.name("mobile"), contact.mobilePhoneNumber);
		type(By.name("work"), contact.workPhoneNumber);
		type(By.name("email"), contact.firstEmail);
		type(By.name("email2"), contact.secondEmail);
		if(typeForm == CREATION){
			if(contact.groupName != null){
				selectByText(By.name("new_group"),contact.groupName);
			}
		}
		else{
			if(driver.findElements(By.name("new_group")).size()!= 0){
				throw new Error("Group selector exist in contact modification form");
			}
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


	
	public String chooseSelectOption(String selectName){
		List<WebElement> options = driver.findElements(By.xpath("//select[@name = '" + selectName + "']/option"));
		 Random rnd = new Random();
		 int index = rnd.nextInt(options.size());
		 return options.get(index).getText();
		
	}
	
	public void initContactCreation(){
		click(By.linkText("add new"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	

}
