package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{
  @Test
  public void testNotEmptyGroupCreaetion() throws Exception {
    app.getNavigationHelper().goToMainPage();
    app.getNavigationHelper().goToGroupsPage();
    List<GroupData> oldGroupsList = app.getGroupHelper().getGroupList();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.groupName = "Grou ala";
    group.header = "Header";
    group.footer = "Footer";
	app.getGroupHelper().fillGroupFormFields(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();  
    List<GroupData> newGroupsList = app.getGroupHelper().getGroupList();
    oldGroupsList.add(group);
	Collections.sort(oldGroupsList);
	assertEquals(newGroupsList, oldGroupsList);
							
  }
  
  @Test
  public void testEmptyGroupCreaetion() throws Exception {
    app.getNavigationHelper().goToMainPage();
    app.getNavigationHelper().goToGroupsPage();
    List<GroupData> oldGroupsList = app.getGroupHelper().getGroupList();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData("", "", "");
	app.getGroupHelper().fillGroupFormFields(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    List<GroupData> newGroupsList = app.getGroupHelper().getGroupList();
    oldGroupsList.add(group);
	Collections.sort(oldGroupsList);
	assertEquals(newGroupsList, oldGroupsList);
  }
}
