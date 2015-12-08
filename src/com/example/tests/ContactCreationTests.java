package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase{ 

@DataProvider 
public Iterator<Object[]> contactsFromFile() throws IOException{
	return wrapsContactsForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
}

	



@Test(dataProvider = "contactsFromFile")
public void testContactCreationWithValidData(ContactData contact) throws Exception {
	
	//save old state
	SortedListOf<ContactData> oldContactsList =  app.getContactHelper().getContactList();
	//actions
	app.getContactHelper().createContact(contact);
	//save new state
    SortedListOf<ContactData> newContactsList =  app.getContactHelper().getContactList();
    //compare states
    assertThat(newContactsList,equalTo(oldContactsList.withAdded(contact)));
}

}
