package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{
  	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreaetionWithValidData(GroupData group) throws Exception {
   
    List<GroupData> oldGroupsList = app.getGroupHelper().getGroupList();
   
    app.getGroupHelper().createGroup(group);
   
    List<GroupData> newGroupsList = app.getGroupHelper().getGroupList();
    oldGroupsList.add(group);
	Collections.sort(oldGroupsList);
	assertEquals(newGroupsList, oldGroupsList);
							
  }
}
