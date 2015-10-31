package com.example.tests;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class GroupModifyTests extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group){
		
		app.getNavigationHelper().goToMainPage();
		app.getNavigationHelper().goToGroupsPage();
		List<GroupData> oldGroupsList = app.getGroupHelper().getGroupList();
		Random rnd = new Random();
	    int index = rnd.nextInt(oldGroupsList.size()-1);
	    app.getGroupHelper().initGroupModification(index);
		app.getGroupHelper().fillGroupFormFields(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
		
		oldGroupsList.remove(index);
		oldGroupsList.add(group);
		Collections.sort(oldGroupsList);
		List<GroupData> newGroupsList = app.getGroupHelper().getGroupList();
		assertEquals(newGroupsList, oldGroupsList);
	}

}
