package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ContactModifyTests extends TestBase{

	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().goToMainPage();
		List<ContactData> oldContactsList = app.getContactHelper().getContactList();
		app.getContactHelper().initContactModification(0);
		ContactData contact = new ContactData();
		contact.firstName = "ModifyFirstName";
		contact.lastName = "Antonovich";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().goToHomePage();
		oldContactsList.remove(0);
		oldContactsList.add(contact);
		Collections.sort(oldContactsList);
		List<ContactData> newContactsList = app.getContactHelper().getContactList();
		assertEquals(newContactsList, oldContactsList);
	}
	
}
