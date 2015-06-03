package projectTestNG;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
//import com

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TC07 {
	@Test
	public void testOne()
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
		FirefoxDriver driver = new FirefoxDriver();
		System.out.println("inside test1");
		driver.close();
	}
	@Test
	public void zzestTwo()
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));		
		FirefoxDriver driver = new FirefoxDriver();
		System.out.println("inside test2");
		driver.close();
	}
	@Test
	public void sestThree()
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));		
		FirefoxDriver driver = new FirefoxDriver();
		System.out.println("inside test3");
		driver.close();
	}
}
