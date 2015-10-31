package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{
  	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreaetionWithValidData(GroupData group) throws Exception {
    app.getNavigationHelper().goToMainPage();
    app.getNavigationHelper().goToGroupsPage();
    List<GroupData> oldGroupsList = app.getGroupHelper().getGroupList();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupFormFields(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();  
    List<GroupData> newGroupsList = app.getGroupHelper().getGroupList();
    oldGroupsList.add(group);
	Collections.sort(oldGroupsList);
	assertEquals(newGroupsList, oldGroupsList);
							
  }
}
