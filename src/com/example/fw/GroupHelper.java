package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		}
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
    	fillGroupFormFields(group);
    	submitGroupCreation();
    	returnToGroupsPage();
    	return this;
	}

	public List<GroupData> getGroupList() {
		manager.navigateTo().groupsPage();
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@name='selected[]']"));
		String title;
		for(WebElement checkbox: checkboxes){
			title = checkbox.getAttribute("title");
			String groupName = title.substring(title.indexOf("(") + 1, title.indexOf(")"));
			groups.add(new GroupData().withName(groupName));
		}
		return groups;
	}
	
		
	public GroupHelper deleteGroup(int i) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(i);
		submitGroupDeletion();
		returnToGroupsPage();
		return this;
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
    	fillGroupFormFields(group);
    	submitGroupModification();
    	returnToGroupsPage();
    	return this;
	}

	
	
	//--------------------------------------
	
	
	public void submitGroupDeletion() {
		click(By.name("delete"));
	}
	

	public GroupHelper initGroupCreation(){
		click(By.name("new"));
		return this;
	}
	
	public GroupHelper fillGroupFormFields(GroupData group) {
		type(By.name("group_name"), group.getGroupName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
	}

	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name = 'selected[]'][" + (index + 1) + "]"));
		return this;
	}
	

	
	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
	}
	
	

	
	
	

}
