package com.example.tests;

import static org.testng.Assert.assertEquals;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeContact(){
		//save old state
		SortedListOf<ContactData> oldContactsList = app.getContactHelper().getContactList();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldContactsList.size());
		ContactData contact = oldContactsList.get(index);
		//actions
		app.getContactHelper().initDeletionContactByName(contact.getFirstName(), contact.getLastName());
		
		//save new states
		SortedListOf<ContactData> newContactsList = app.getContactHelper().getContactList();
		
		//compare
		assertThat(newContactsList, equalTo(oldContactsList.without(contact)));
	}

}
