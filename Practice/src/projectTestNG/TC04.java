package projectTestNG;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.ClassUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC04 {

	ExcelUtility eu = new ExcelUtility();	
	WrapperMethods wM = new WrapperMethods();
	LinkedInMethods lnkdIn = new LinkedInMethods();

	//@Parameters({"browser"})	
	
	@BeforeTest
	public void init() throws IOException {
		String classname = ClassUtils.getSimpleName(getClass());
		String browser = "Firefox";
		runAll rA = new runAll(classname, browser);
		rA.startExe();
	}
	
	@Test
	public void searchGroups() throws IOException, InterruptedException
	{
		wM.launchBrowser("Firefox", "https://in.linkedin.com/");
		String userName = eu.readFromCell("UserName","1");
		String password = eu.readFromCell("Password","1");
		wM.enterValueById("session_key-login", userName);

		wM.enterValueById("session_password-login",password);

		wM.clickById("signin");

		wM.verifyTitle("Welcome! | LinkedIn");
		
		wM.clickByClass("styled-dropdown-select-all");
		Thread.sleep(3000);
		wM.selectValFromDropDown("id","main-search-category","visibletext","Groups");
		wM.enterValueById("main-search-box", "Selenium");
		wM.clickByClass("search-button");
		String n1=wM.getTextByXpath("//*[@id='results_count']/div/p/strong");
		System.out.println(n1);
		eu.addstep("The total results for the group name Selenium is: "+n1,"Pass");
		lnkdIn.navigateToLastPg();
		lnkdIn.clickOnLastLink();
		WebElement eleStat = wM.createWebElement("classname", "member-status");
		if(eleStat == null)
			wM.clickBylink("Join");
		else
			eu.addstep("Already join action performed for this group","Pass");
			
		lnkdIn.Logout();
		wM.quit();
		
		
	}

}
