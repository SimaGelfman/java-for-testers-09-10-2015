package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase{
	
	
	@Test
	public void deleteSomeGroup(){
		
		//save old state
		SortedListOf<GroupData> oldGroupsList = app.getGroupHelper().getGroupList();
	    
		Random rnd = new Random();
	    int index = rnd.nextInt(oldGroupsList.size());
	    GroupData group = oldGroupsList.get(index);
	   //action
	    app.getGroupHelper().deleteGroupByGroupName(group.getGroupName());
	    	
	   //save new state
	    SortedListOf<GroupData> newGroupsList = app.getGroupHelper().getGroupList();
	    //compare states
	    assertThat(newGroupsList, equalTo(oldGroupsList.without(group)));
	    
	}

}
