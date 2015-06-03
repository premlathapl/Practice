package testNgPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class beforeSuite {
	
	@BeforeGroups("test")
	public void befGroups()
	{
		System.out.println("BeforeGroups.befGroups()");
	}
	
	@AfterGroups("test")
	public void aftGroups()
	{
		System.out.println("AfterGroups.aftGroups()");
	}
	
	@BeforeSuite(inheritGroups=true)
	public void befSuite()
	{
		System.out.println("beforeSuite.befSuite()");
	}
	
	@BeforeClass(groups="before")
	public void befClass()
	{
		System.out.println("BeforeClass.befClass()");
	}
	
	@AfterClass(groups="after")
	public void aftClass()
	{
		System.out.println("AfterClass.aftClass()");
	}
	
	@BeforeTest(groups="before")
	public void befTest()
	{
		System.out.println("BeforeTest.befTest()");
	}
	
	@AfterTest(inheritGroups=true)
	public void aftTest()
	{
		System.out.println("AfterTest.aftTest()");
	}	
	
	@BeforeMethod(groups="before")
	public void befMethod()
	{
		System.out.println("@BeforeMethod.befMethod()");
	}
	
	@AfterMethod(groups="after")
	public void aftMethod()
	{
		System.out.println("@AfterMethod.aftMethod()");
	}
	//@DataProvider("testdata")
	@Test(groups="test",dataProvider = "testdata")
	public void runRandom(String data)
	{
		System.out.println("randomw before "+data);
	}
	@DataProvider(name="testdata",parallel=true)
	public static Object[][] dataProvider()
	{
		return new Object[][]{{"data1"},{"data2"},{"data3"}};
	}
	
	@Parameters("dataval")
	@Test
	public void runRandom2(String data)
	{
		System.out.println("check parametr "+data);
	}
	
}
