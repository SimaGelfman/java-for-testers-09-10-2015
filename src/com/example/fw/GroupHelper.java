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

	public void initGroupCreation(){
		click(By.name("new"));
	}

	public void fillGroupFormFields(GroupData group) {
		type(By.name("group_name"), group.groupName);
		type(By.name("group_header"), group.header);
		type(By.name("group_footer"), group.footer);
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	public void returnToGroupsPage() {
		click(By.linkText("group page"));
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name = 'selected[]'][" + index + "]"));
	}
	
	public void deleteGroup(int i) {
		selectGroupByIndex(i);
		click(By.name("delete"));
	}
	
	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));		
	}

	public void submitGroupModification() {
		click(By.name("update"));
	}

	public List<GroupData> getGroupList() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@name='selected[]']"));
		String title;
		for(WebElement checkbox: checkboxes){
			GroupData group = new GroupData();
			title = checkbox.getAttribute("title");
			String namegr = title.substring(title.indexOf("(") + 1, title.indexOf(")"));
			
			group.groupName = title.substring(title.indexOf("(") + 1, title.indexOf(")"));
			System.out.print(namegr);
			groups.add(group);
		}
		return groups;
	}
	
	

}
