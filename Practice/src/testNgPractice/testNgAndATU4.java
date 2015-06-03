package testNgPractice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class testNgAndATU4 {
	
	{
		System.setProperty("atu.reporter.config","C:\\Users\\p.l.yadav\\Desktop\\seleniumProj\\Practice\\atu.properties");
	}
	
	@BeforeTest
	
	public void beforeTest() {
		
		System.out.println("beforeTest");
		ATUReports.add("Step 1", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	}
	
@AfterTest
	
	public void afterTest() {
	//System.setProperty("atu.reporter.config","C:\\Users\\p.l.yadav\\Desktop\\seleniumProj\\Practice\\atu.properties");
	ATUReports.add("Step after", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));	
		System.out.println("AfterTest");
	}

@Test(groups = "g1")

public void test1() {
	//System.setProperty("atu.reporter.config","C:\\Users\\p.l.yadav\\Desktop\\seleniumProj\\Practice\\atu.properties");
	ATUReports.add("Step test1", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	System.out.println("Test1");
}
@Test(groups = "g1")
public void test2() {
	//System.setProperty("atu.reporter.config","C:\\Users\\p.l.yadav\\Desktop\\seleniumProj\\Practice\\atu.properties");
	ATUReports.add("Step test2", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	System.out.println("Test2");
}
@Test(groups = "g1")
public void test3() {
	//System.setProperty("atu.reporter.config","C:\\Users\\p.l.yadav\\Desktop\\seleniumProj\\Practice\\atu.properties");
	ATUReports.add("Step test3", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	System.out.println("Test3");
}

}
