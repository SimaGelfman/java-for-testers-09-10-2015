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
			ContactData contact = new ContactData()
								.withFirstName(generateRandomString())
								.withLastName(generateRandomString())
								.withFirstAdress(generateRandomString())
								.withFirstEmail("mail" + rnd.nextInt() + "@" + "gmail.com")
								.withSecondEmail("mail" + rnd.nextInt() + "@" + "yahoo.com")
								.withHomePhoneNumber(Integer.toString(rnd.nextInt(900000000) +100000000))
								.withMobilePhoneNumber(Integer.toString(rnd.nextInt(900000000) +100000000))
								.withWorkPhoneNumber(Integer.toString(rnd.nextInt(900000000) +100000000))
								.withBirthDay(Integer.toString(rnd.nextInt(31) +1))
								.withBirthMonth(months[rnd.nextInt(months.length)])
								.withBirthYear(Integer.toString(rnd.nextInt(95) +1920))
								.withSecondAdress(generateRandomString())
								.withHomeNumber(Integer.toString(rnd.nextInt(50)));
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
