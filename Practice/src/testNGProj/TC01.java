package testNGProj;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC01 {
	@BeforeTest
	public void testCaseOneBef()
	{
		System.out.println("testcase one before test");
	}
	@Test
	public void testCaseOne()
	{
		System.out.println("testcase one test");
	}
	@AfterTest
	public void testCaseOneAft()
	{
		System.out.println("testcase one after test");
	}

}
