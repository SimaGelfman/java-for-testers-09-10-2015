package com.example.tests;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import static com.example.fw.ContactHelper.MODIFICATION;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ContactModifyTests extends TestBase{

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		app.navigateTo().mainPage();
		List<ContactData> oldContactsList = app.getContactHelper().getContactList();
		Random rnd = new Random();
	    int index = rnd.nextInt(oldContactsList.size()-1);
		app.getContactHelper().initContactModification(index);
		app.getContactHelper().fillContactForm(contact, MODIFICATION);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().goToHomePage();
		oldContactsList.remove(index);
		oldContactsList.add(contact);
		Collections.sort(oldContactsList);
		List<ContactData> newContactsList = app.getContactHelper().getContactList();
		assertEquals(newContactsList, oldContactsList);
	}
	
}
