package com.example.tests;

import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().goToMainPage();
		List<ContactData> oldContactsList = app.getContactHelper().getContactList();
		app.getContactHelper().deleteContact(0);
		app.getContactHelper().goToHomePage();
		oldContactsList.remove(0);
		List<ContactData> newContactsList = app.getContactHelper().getContactList();
		assertEquals(newContactsList, oldContactsList);
	}

}
