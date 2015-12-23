package com.example.fw;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase{

public static boolean CREATION = true;
public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;

	
	public SortedListOf<ContactData> getContactList() {
		if(cachedContacts == null){
			rebuildCach();
		}
		return cachedContacts;
	}
	
	private void rebuildCach() {
		manager.navigateTo().mainPage();
		cachedContacts = new SortedListOf<ContactData>();
		List<WebElement> trs = driver.findElements(By.xpath("//tr[@name='entry']"));
		String fname = "", lname = "";
		for(WebElement tr: trs){
			ContactData contact = new ContactData();
			lname = tr.findElement(By.xpath(".//td[2]")).getText();
			fname = tr.findElement(By.xpath(".//td[3]")).getText();
			contact.withFirstName(fname);
			contact.withLastName(lname);
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
	
	public ContactHelper modifyContact(int index, ContactData contact, boolean mODIFICATION2) {
		manager.navigateTo().mainPage();
		initContactModification(index);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		goToHomePage();
		return this;
	}
	
	public ContactHelper modifyContactByName(String firstName, String lastName, ContactData contact) {
		manager.navigateTo().mainPage();
		openContactEditPageByName(firstName,lastName);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		goToHomePage();
		return this;
	}
	
	public ContactHelper deleteContactByIndex(int index) {
		manager.navigateTo().mainPage();
		deleteContact(index);
		goToHomePage();
		rebuildCach();
		return this;
	}
	
	public ContactHelper deleteContactByName(String firstName, String lastName) {
		manager.navigateTo().mainPage();
		initDeletionContactByName(firstName, lastName);
		goToHomePage();
		rebuildCach();
		return this;
	}

	
	
	//----------------------------------
	
	public ContactHelper fillContactForm(ContactData contact, boolean typeForm) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getLastName());
		type(By.name("address"), contact.getFirstAdress());
		type(By.name("home"), contact.getHomePhoneNumber());
		type(By.name("mobile"), contact.getMobilePhoneNumber());
		type(By.name("work"), contact.getWorkPhoneNumber());
		type(By.name("email"), contact.getFirstEmail());
		type(By.name("email2"), contact.getSecondEmail());
		if(typeForm == CREATION){
			if(contact.getGroupName() != null){
				selectByText(By.name("new_group"),contact.getGroupName());
			}
		}
		else{
			if(driver.findElements(By.name("new_group")).size()!= 0){
				throw new Error("Group selector exist in contact modification form");
			}
		}
		if(contact.getBirthDay() != null){
			selectByText(By.name("bday"), contact.getBirthDay());
		}
		if(contact.getBirthMonth() != null){
			selectByText(By.name("bmonth"),contact.getBirthMonth());
		}
		type(By.name("byear"), contact.getBirthYear());
		type(By.name("address2"), contact.getSecondAdress());
		type(By.name("phone2"), contact.getHomeNumber());
		System.out.println(contact);
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
	
	public ContactHelper initDeletionContactByName(String firstName, String lastName){
		openContactEditPageByName(firstName, lastName);
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

	
	public ContactHelper openContactEditPageByName(String firstName, String lastName){
		click(By.xpath("//table//tr[contains(./td[2], '" + lastName + "') and contains(./td[3], '" + firstName +"')][1]//img[@alt='Edit']"));		
		return this;
	}
	
}
