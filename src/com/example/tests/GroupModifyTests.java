package com.example.tests;

import java.util.List;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class GroupModifyTests extends TestBase{
	
	@Test
	public void modifySomeGroup(){
		app.getNavigationHelper().goToMainPage();
		app.getNavigationHelper().goToGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.groupName = "modify Name";
		app.getGroupHelper().fillGroupFormFields(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
	}

}
