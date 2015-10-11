package com.example.tests;

import java.util.regex.Pattern;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{
  @Test
  public void testNotEmptyGroupCreaetion() throws Exception {
    goToMainPage();
    goToGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.groupName = "Group_09_10";
    group.header = "Header";
    group.footer = "Footer";
	fillGroupFormFields(group);
    submitGroupCreation();
    returnToGroupsPage();   
  }
  
  @Test
  public void testEmptyGroupCreaetion() throws Exception {
    goToMainPage();
    goToGroupsPage();
    initGroupCreation();
    fillGroupFormFields(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();   
  }
}
