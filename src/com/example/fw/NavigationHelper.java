package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		if(!onMainPage()){
<<<<<<< HEAD
			click(By.linkText("home"));
=======
			click(By.name("home"));
>>>>>>> c12f6b54905a8444a5ad1d6755b56a7853a2ff23
		}
	}

	private boolean onMainPage() {
		return driver.findElements(By.id("maintable")).size()>0;
	}

	public void groupsPage() {
		if(!onGroupsPage()){
			click(By.linkText("groups"));	
		}
	}

	private boolean onGroupsPage() {
		if(driver.getCurrentUrl().contains("/group.php")
			&& driver.findElements(By.name("new")).size()>0){
			return true;
		}
		else{
		return false;
		}
	}
	

}
