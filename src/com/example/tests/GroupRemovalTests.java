package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeGroup(){
		
		List<GroupData> oldGroupsList = app.getGroupHelper().getGroupList();
	    
		Random rnd = new Random();
	    int index = rnd.nextInt(oldGroupsList.size()-1);
	    app.getGroupHelper().deleteGroup(index);
	    	
	    oldGroupsList.remove(index);
	    List<GroupData> newGroupsList = app.getGroupHelper().getGroupList();
	    assertEquals(newGroupsList, oldGroupsList);
	    
	}

}
