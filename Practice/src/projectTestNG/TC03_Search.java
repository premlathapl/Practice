package projectTestNG;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.ClassUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC03_Search  {
	
	ExcelUtility eu = new ExcelUtility();	
	WrapperMethods wM = new WrapperMethods();
	LinkedInMethods lnkdIn = new LinkedInMethods();

	
	@BeforeTest
	@Parameters({"browser"})
	public void init(String browser) throws IOException {
		String classname = ClassUtils.getSimpleName(getClass());
		//String browser = "Firefox";
		runAll rA = new runAll(classname, browser);
		rA.startExe();
	}
	
	@Test
	@Parameters({"browser"})
	public void search(String browser) throws IOException
	{
		wM.launchBrowser(browser, "https://in.linkedin.com/");
		String userName = eu.readFromCell("UserName","1");
		String password = eu.readFromCell("Password","1");
		wM.enterValueById("session_key-login", userName);

		wM.enterValueById("session_password-login",password);

		wM.clickById("signin");

		wM.verifyTitle("Welcome! | LinkedIn");
		
		wM.clickById("advanced-search");
		
		wM.clickByxpath("//*[@id='advs']/div[1]/button");
		
		lnkdIn.removeConnections("2nd Connections");
		lnkdIn.removeConnections("Group Members");
		
		String number = wM.getTextByXpath("//*[@id='facet-N']/fieldset/div/ol/li[2]/div/span");
		
		String S = number.replace("(", "");
		String S2 = S.replace(")", "");
		System.out.println(S2);
		String n1=wM.getTextByXpath("//*[@id='results_count']/div/p/strong");
		System.out.println(n1);
		if(S2.equals(n1))
		{
			eu.addstep("Both the Result of the First connection is Equal", "pass");
		}
		else
		{
			eu.addstep("not equal", "fail");
		}
			
		lnkdIn.Logout();
		wM.quit();
		
		
	}

}
