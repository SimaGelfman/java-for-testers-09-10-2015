package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void goToMainPage() {
		driver.get(manager.baseUrl + "/addressbook/");
	}

	public void goToGroupsPage() {
		click(By.linkText("groups"));
	}
	

}
