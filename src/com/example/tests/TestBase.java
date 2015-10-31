package com.example.tests;


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
		
		List <Object[]>  list = new ArrayList<Object[]>();
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData();
			group.groupName = generateRandomString();
			group.footer = generateRandomString();
			group.header = generateRandomString();
			list.add(new Object[]{group});
		}		
		return list.iterator();
	}
	
	public String generateRandomString(){
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return " ";
		} else{
			return "test" + rnd.nextInt();
		}
	}
	
	@AfterTest
	public static void tearDown() throws Exception {
		app.stop();
	  }
}
