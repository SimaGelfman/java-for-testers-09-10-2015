package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static com.example.fw.ContactHelper.CREATION;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{ 


@Test(dataProvider = "randomValidContactGenerator")
public void testContactCreationWithValidData(ContactData contact) throws Exception {
	app.navigateTo().mainPage();
	//save old state
	List<ContactData> oldContactsList =  app.getContactHelper().getContactList();
	app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact, CREATION);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().goToHomePage();
    oldContactsList.add(contact);
    Collections.sort(oldContactsList);
    List<ContactData> newContactsList =  app.getContactHelper().getContactList();
    assertEquals(newContactsList,oldContactsList);
}

}
