package com.example.tests;

import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeContact(){
		//save old state
		List<ContactData> oldContactsList = app.getContactHelper().getContactList();
		//actions
		app.getContactHelper().deleteContactByIndex(0);
		oldContactsList.remove(0);
		//save new states
		List<ContactData> newContactsList = app.getContactHelper().getContactList();
		//compare
		assertEquals(newContactsList, oldContactsList);
	}

}
