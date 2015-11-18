package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModifyTests extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group){
		//save old state		
		SortedListOf<GroupData> oldGroupsList = app.getGroupHelper().getGroupList();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldGroupsList.size()-1);
	    GroupData selectedGroup = oldGroupsList.get(index); 
	    //action
	    app.getGroupHelper().modifyGroupGroupName(selectedGroup.getGroupName(), group);
	    //save new state
		SortedListOf<GroupData> newGroupsList = app.getGroupHelper().getGroupList();
		//compare states
		assertThat(newGroupsList, equalTo(oldGroupsList.without(selectedGroup).withAdded(group)));
	}

}
