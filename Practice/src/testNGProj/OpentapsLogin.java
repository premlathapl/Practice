package testNGProj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class OpentapsLogin {
	WebDriver driver;
@BeforeClass

	public void beforeclass() {
		
		System.out.println("beforeclass");
	}
	
		@BeforeTest
		
	public void beforetest() {
		
		System.out.println("beforetest");
	}
	
	@Test
		public void test() {
				
		driver = new FirefoxDriver();
		driver.get("http://demo1.opentaps.org/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.close();
	}
		
		@Test
		
		public void test1() {
			
			System.out.println("test1");
		}
@Test
		
		public void test2() {
			
			System.out.println("test2");
		}
@AfterTest

public void Aftertest() {
	
	System.out.println("aftertest");
}

@AfterClass

public void Afterclass() {
	
	System.out.println("Afterclass");
}


	}
 class Open {
	
@Test
	
	void testclass2() {
		
		System.out.println("testclass2");
	}
	
	
}
