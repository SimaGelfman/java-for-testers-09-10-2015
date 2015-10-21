package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{
  @Test
  public void testNotEmptyGroupCreaetion() throws Exception {
    app.getNavigationHelper().goToMainPage();
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.groupName = "Group_09_10";
    group.header = "Header";
    group.footer = "Footer";
	app.getGroupHelper().fillGroupFormFields(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();   
  }
  
  @Test
  public void testEmptyGroupCreaetion() throws Exception {
    app.getNavigationHelper().goToMainPage();
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupFormFields(new GroupData("", "", ""));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();   
  }
}
