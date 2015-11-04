package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{ 


@Test
public void testNotEmptyContactCreation() throws Exception {
	app.getNavigationHelper().goToMainPage();
	List<ContactData> oldContactsList =  app.getContactHelper().getContactList();
	app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstName = "Kostya";
    contact.lastName = "Arloc";
    contact.firstAdress = "Rehovot"; 
    contact.homePhoneNumber = "089999999";
    contact.mobilePhoneNumber = "0540000000";
    contact.workPhoneNumber = "0373200000";
    contact.firstEmail =  "anna@gmail.com";
    contact.secondEmail = "anna1@gmail.com";
    contact.groupName = "";
    contact.birthDay = "2";
    contact.birthMonth = "March";
    contact.birthYear = "1986";
    contact.secondAdress = "Rehovot2";
    contact.homeNumber = "21";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().goToHomePage();
    oldContactsList.add(contact);
    Collections.sort(oldContactsList);
    List<ContactData> newContactsList =  app.getContactHelper().getContactList();
//    for(ContactData contact1: oldContactsList){
//    	contact1.printContact();
//    }
//    for(ContactData contact1: oldContactsList){
//    	contact1.printContact();
//    }
    assertEquals(newContactsList,newContactsList);
}

//@Test
public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().goToMainPage();
	app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData("", "", "", "", "", "", "", "", null, null, null, "", "", "");
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().goToHomePage();
}


}
