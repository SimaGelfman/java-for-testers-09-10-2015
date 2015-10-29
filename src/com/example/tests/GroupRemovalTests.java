package com.example.tests;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.fw.NavigationHelper;

public class GroupRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeGroup(){
		
		app.getNavigationHelper().goToMainPage();
	    app.getNavigationHelper().goToGroupsPage();
	    List<GroupData> oldGroupsList = app.getGroupHelper().getGroupList();
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldGroupsList.size()-1);
	    app.getGroupHelper().deleteGroup(index);
	    app.getGroupHelper().returnToGroupsPage();
	    oldGroupsList.remove(index);
	    List<GroupData> newGroupsList = app.getGroupHelper().getGroupList();
	    assertEquals(newGroupsList, oldGroupsList);
	    
	}

}
