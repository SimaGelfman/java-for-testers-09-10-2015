package com.example.tests;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase{
  	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreaetionWithValidData(GroupData group) throws Exception {
		
		//save old state
		SortedListOf<GroupData> oldGroupsList = app.getGroupHelper().getGroupList();
		//action
		app.getGroupHelper().createGroup(group);
		//save new state
		SortedListOf<GroupData> newGroupsList = app.getGroupHelper().getGroupList();
		//compare states
		 assertThat(newGroupsList, equalTo(oldGroupsList.withAdded(group)));
		
  }
}
