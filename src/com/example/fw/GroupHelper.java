package com.example.fw;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		}
	
	private SortedListOf<GroupData> cachedGroups;
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
    	fillGroupFormFields(group);
    	submitGroupCreation();
    	returnToGroupsPage();
    	rebuildCach();
    	return this;
	}

	public SortedListOf<GroupData> getGroupList() {
		if(cachedGroups == null){
			rebuildCach();
		}
		return cachedGroups;
	}
	
		
	private void rebuildCach() {

		manager.navigateTo().groupsPage();
		cachedGroups = new SortedListOf<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@name='selected[]']"));
		String title;
		for(WebElement checkbox: checkboxes){
			title = checkbox.getAttribute("title");
			String groupName = title.substring(title.indexOf("(") + 1, title.indexOf(")"));
			cachedGroups.add(new GroupData().withName(groupName));
		}	
	}

	public GroupHelper deleteGroup(int i) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(i);
		submitGroupDeletion();
		returnToGroupsPage();
		rebuildCach();
		return this;
	}
	
	public GroupHelper deleteGroupByGroupName(String groupName) {
		manager.navigateTo().groupsPage();
		selectGroupByName(groupName);
		submitGroupDeletion();
		returnToGroupsPage();
		rebuildCach();
		return this;
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
    	fillGroupFormFields(group);
    	submitGroupModification();
    	returnToGroupsPage();
    	rebuildCach();
    	return this;
	}
	
	public GroupHelper modifyGroupGroupName(String groupName, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModificationByGroupName(groupName);
    	fillGroupFormFields(group);
    	submitGroupModification();
    	returnToGroupsPage();
    	rebuildCach();
    	return this;
	}

	
	
	//--------------------------------------
	
	
	public GroupHelper submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
		return this;
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
		cachedGroups = null;
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

	public GroupHelper initGroupModificationByGroupName(String groupName) {
		selectGroupByName(groupName);
		click(By.name("edit"));
		return this;
	}
	 
	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
		return this;
	}
	

	private GroupHelper selectGroupByName(String groupName) {
		click(By.xpath("//input[@type = 'checkbox' and @name = 'selected[]' and contains(@title, '" + groupName + "')][1]")); 
		return this;
	}

	

	
	
	

}
