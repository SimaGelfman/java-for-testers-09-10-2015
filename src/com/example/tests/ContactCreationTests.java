package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static com.example.fw.ContactHelper.CREATION;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{ 


@Test(dataProvider = "randomValidContactGenerator")
public void testContactCreationWithValidData(ContactData contact) throws Exception {
	
	//save old state
	List<ContactData> oldContactsList =  app.getContactHelper().getContactList();
	//actions
	app.getContactHelper().createContact(contact);
	
    oldContactsList.add(contact);
    Collections.sort(oldContactsList);
    //save new state
    List<ContactData> newContactsList =  app.getContactHelper().getContactList();
    //compare states
    assertEquals(newContactsList,oldContactsList);
}

}
