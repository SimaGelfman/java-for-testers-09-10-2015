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
			return "";
		} else{
			return "test" + rnd.nextInt();
		}
	}
	
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
