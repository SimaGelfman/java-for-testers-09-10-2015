package com.example.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeContact(){
		//save old state
		SortedListOf<ContactData> oldContactsList = app.getContactHelper().getContactList();
		//actions
		app.getContactHelper().deleteContactByIndex(0);
		oldContactsList.remove(0);
		//save new states
		SortedListOf<ContactData> newContactsList = app.getContactHelper().getContactList();
		//compare
		assertEquals(newContactsList, oldContactsList);
	}

}
