package com.example.tests;

import org.testng.annotations.Test;

import com.example.fw.NavigationHelper;

public class GroupRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeGroup(){
		NavigationHelper navigationHelper = app.getNavigationHelper();
		navigationHelper.goToMainPage();
	    app.getNavigationHelper().goToGroupsPage();
	    app.getGroupHelper().deleteGroup(1);
	    app.getGroupHelper().returnToGroupsPage();
	}

}
