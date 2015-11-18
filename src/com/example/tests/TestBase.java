package com.example.tests;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		
		List <Object[]>  list = new ArrayList<Object[]>();
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData()
					.withName(generateRandomString())
					.withFooter(generateRandomString())
					.withHeader(generateRandomString());
			list.add(new Object[]{group});
		}		
		return list.iterator();
	}
	
	
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		
		List<Object[]> list = new ArrayList<Object[]>();
		Random rnd = new Random();
		String[] months = {"-", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		for(int i = 0; i<5; i++){
			ContactData contact = new ContactData();
			contact.firstName = generateRandomString();
			contact.lastName = generateRandomString();
			contact.firstAdress = generateRandomString();
			contact.firstEmail = "mail" + rnd.nextInt() + "@" + "gmail.com";
			contact.secondEmail = "mail" + rnd.nextInt() + "@" + "yahoo.com";
			contact.homePhoneNumber = Integer.toString(rnd.nextInt(900000000) +100000000);
			contact.mobilePhoneNumber = Integer.toString(rnd.nextInt(900000000) +100000000);
			contact.workPhoneNumber = Integer.toString(rnd.nextInt(900000000) +100000000);
			contact.birthDay = Integer.toString(rnd.nextInt(31) +1);
			contact.birthMonth = months[rnd.nextInt(months.length)];
			contact.birthYear = Integer.toString(rnd.nextInt(95) +1920);;
			contact.secondAdress =  generateRandomString();
			contact.homeNumber =  Integer.toString(rnd.nextInt(50));
			list.add(new Object[]{contact});			
		}
		return list.iterator();
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
