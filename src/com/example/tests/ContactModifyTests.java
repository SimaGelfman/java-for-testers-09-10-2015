package com.example.tests;

import java.util.Collections;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;
import java.util.Random;
import static com.example.fw.ContactHelper.MODIFICATION;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModifyTests extends TestBase{

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		//save old states
		SortedListOf<ContactData> oldContactsList = app.getContactHelper().getContactList();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldContactsList.size()-1);
	    ContactData modifiedContact = oldContactsList.get(index);
		//actions
	    app.getContactHelper().modifyContactByName(modifiedContact.getFirstName(), modifiedContact.getLastName(), contact);
		
		
		//save new states
		SortedListOf<ContactData> newContactsList = app.getContactHelper().getContactList();
		//compare
		assertThat(newContactsList, equalTo(oldContactsList.without(modifiedContact).withAdded(contact)));
	}
	
}
