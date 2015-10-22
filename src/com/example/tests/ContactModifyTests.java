package com.example.tests;

import org.testng.annotations.Test;

public class ContactModifyTests extends TestBase{

	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().goToMainPage();
		app.getContactHelper().initContactModification(1);
		ContactData contact = new ContactData();
		contact.firstName = "ModifyFirstName";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().goToHomePage();
	}
	
}
