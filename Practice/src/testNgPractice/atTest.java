package testNgPractice;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import testNgPractice.*;


public class atTest {
	@Parameters("dataval")
	@Test(dependsOnGroups={"test"})
	public void runRandom1232(String data) throws FileNotFoundException,ElementNotFoundException
	{
		System.out.println("random at test "+data);
		Reporter.log("it is passed");
		
	}
	@Parameters("dataval")
	@Test(groups={"test"}, dependsOnMethods={"runRandomOneAtTesthuh","runRandomOneAtTesth"})
	public void runRandomOneAtTest(String data) throws FileNotFoundException,ElementNotFoundException
	{
		System.out.println("random at test "+data);
		Reporter.log("it is passed");
		//ATUReports.add("data chckc report", LogAs.PASSED,CaptureScreen.ScreenshotOf.BROWSER_PAGE);
	}
	
	@Parameters("dataval")
	@Test
	public void runRandomOneAtTesthuh(String data) throws FileNotFoundException,ElementNotFoundException
	{
		System.out.println("random at test "+data);
		Reporter.log("it is passed");
		
	}
	@Parameters("dataval")
	@Test
	public void runRandomOneAtTesth(String data) throws FileNotFoundException,ElementNotFoundException
	{
		System.out.println("random at test "+data);
		Reporter.log("it is passed");
		
	}
	
}
