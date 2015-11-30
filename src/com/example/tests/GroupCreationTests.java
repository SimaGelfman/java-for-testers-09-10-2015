package com.example.tests;


import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static com.example.tests.GroupsDataGenerator.generateRandomGroups;
import static com.example.tests.GroupsDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupsDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase{
  	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException{
		return wrapsGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}
	

	@Test(dataProvider = "groupsFromFile")
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
