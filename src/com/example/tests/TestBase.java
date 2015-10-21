package com.example.tests;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public static void setUp() throws Exception {
		app = new ApplicationManager();
	}   
	@AfterTest
	public static void tearDown() throws Exception {
		app.stop();
	  }
}
