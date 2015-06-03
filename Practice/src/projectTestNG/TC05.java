package projectTestNG;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.ClassUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC05 {


	ExcelUtility eu = new ExcelUtility();	
	WrapperMethods wM = new WrapperMethods();
	LinkedInMethods lnkdIn = new LinkedInMethods();

	//@Parameters({"browser"})	
	
/*	@BeforeTest
	public void init() throws IOException {
		String classname = ClassUtils.getSimpleName(getClass());
		String browser = "";
		runAll rA = new runAll(classname, browser);
		rA.startExe();
	}*/
	
	@Test
	public void searchPeople() throws IOException, InterruptedException
	{
		String classname = ClassUtils.getSimpleName(getClass());
		String browser = "";
		runAll rA = new runAll(classname, browser);
		eu.definePathAndExcelPath();
		int iterations = eu.getIterationsForTestCase();
		for(int i=1;i<iterations+1;i++)
		{
			String it = Integer.toString(i);
			browser = eu.readFromCell("Browser",it);
			System.out.println(browser);
			rA = new runAll(classname, browser);
			rA.startExe();
			wM.launchBrowser(browser, "https://in.linkedin.com/");
			String userName = eu.readFromCell("UserName",it);
			String password = eu.readFromCell("Password",it);
			String searchTerm = eu.readFromCell("searchTerm",it);
			wM.enterValueById("session_key-login", userName);
	
			wM.enterValueById("session_password-login",password);
	
			wM.clickById("signin");
	
			wM.verifyTitle("Welcome! | LinkedIn");
			
			wM.clickByClass("styled-dropdown-select-all");
			Thread.sleep(3000);
			wM.selectValFromDropDown("id","main-search-category","visibletext","People");
			wM.enterValueById("main-search-box", searchTerm);
			wM.clickByClass("search-button");
			String n1=wM.getTextByXpath("//*[@id='results_count']/div/p/strong");
			System.out.println(n1);
			eu.addstep("The total results for the group name Selenium is: "+n1,"Pass");
			String lnkTxt = "";
			List<WebElement>  resLst = wM.createWebElementList("classname", "bd");
			for(WebElement ele: resLst)
			{
				String randTxt = lnkdIn.returnTextForConnection(ele, "2");
				if(randTxt != "")
					lnkTxt = randTxt+";"+lnkTxt;
			}
			eu.addstep("The names with conections 2 are "+lnkTxt,"Pass");
			lnkdIn.Logout();
			wM.quit();
		}
		
	}
}
