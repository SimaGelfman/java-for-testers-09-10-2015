package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.fw.ContactHelper.MODIFICATION;

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
		manager.navigateTo().mainPage();
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
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initContactCreation();
	    fillContactForm(contact, CREATION);
	    submitContactCreation();
	    goToHomePage();
	    rebuildCach();
	    return this;
		
	}
	
	public ContactHelper modifyContact(ContactData contact, boolean mODIFICATION2) {
		initContactModification(index);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		goToHomePage();// TODO Auto-generated method stub
		return null;
	}

	
	
	//----------------------------------
	
	public ContactHelper fillContactForm(ContactData contact, boolean typeForm) {
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
		return this;
	}

	public ContactHelper goToHomePage() {
		click(By.linkText("home page"));
		return this;
	}
	
	
	
	public ContactHelper selectContactByIndex(int index){
		click(By.xpath("//table/descendant::input[@name= 'selected[]'][" + (index + 1) + "]"));
		return this;
	}
	
	public ContactHelper openContactEditPage(int index){
		click(By.xpath("//table/descendant::img[@alt= 'Edit'][" + (index + 1) + "]"));
		return this;
	}

	public ContactHelper deleteContact(int index){
		openContactEditPage(index);
		click(By.xpath("//form/descendant::input[@value='Delete']"));
		cachedContacts = null;
		return this;
	}
	
	

	public ContactHelper initContactModification(int index) {
		openContactEditPage(index);
		return this;
	}
	
	

	public ContactHelper submitContactModification() {
		click(By.xpath("//form/descendant::input[@value='Update']"));
		cachedContacts = null;
		return this;
	}


	
	public String chooseSelectOption(String selectName){
		List<WebElement> options = driver.findElements(By.xpath("//select[@name = '" + selectName + "']/option"));
		 Random rnd = new Random();
		 int index = rnd.nextInt(options.size());
		 return options.get(index).getText();		
	}
	
	public ContactHelper initContactCreation(){
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}




	

}
