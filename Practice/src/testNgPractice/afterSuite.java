package testNgPractice;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class afterSuite {
	
	@AfterSuite
	public void aftSuite()
	{
		System.out.println("afterSuite.aftSuite()");
	}
	
	@Test
	public void runRandom()
	{
		System.out.println("random after");
		
	}

}
