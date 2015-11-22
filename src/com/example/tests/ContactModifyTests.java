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
		//save old states
		List<ContactData> oldContactsList = app.getContactHelper().getContactList();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldContactsList.size()-1);
		//actions
	    app.getContactHelper().modifyContact(index, contact, MODIFICATION);
		
		oldContactsList.remove(index);
		oldContactsList.add(contact);
		Collections.sort(oldContactsList);
		//save new states
		List<ContactData> newContactsList = app.getContactHelper().getContactList();
		//compare
		assertEquals(newContactsList, oldContactsList);
	}
	
}
