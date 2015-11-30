package com.example.tests;


import static com.example.tests.GroupsDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public static void setUp() throws Exception {
		app = new ApplicationManager();
	} 
	

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		return wrapsGroupsForDataProvider(generateRandomGroups(5)).iterator();
	}
	
	
	
	public static List<Object[]> wrapsGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		return wrapsContactsForDataProvider(generateRandomContacts(5)).iterator();
	}
	
	public static List<Object[]> wrapsContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}
	
	@DataProvider
	public Iterator<Object[]> selectGroupNameFromList(){
		Random rnd = new Random();
		List<Object[]> list = new ArrayList<Object[]>();
		for(int i = 0; i < 5; i++)
		{
			String groupName = new String();
			if(rnd.nextInt(3) == 0){
				groupName = "Select ()";
			} else{
				groupName = "test";
			}
			list.add(new Object[]{groupName});
		}
	 return	list.iterator();
	}
	
	
	public String generateRandomString(){
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return "";
		} else{
			return "test" + rnd.nextInt();
		}
	}
	
	
	
	
	
	@AfterTest
	public static void tearDown() throws Exception {
		app.stop();
	  }
}
