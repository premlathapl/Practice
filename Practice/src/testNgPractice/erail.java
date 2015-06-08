package testNgPractice;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.TestListenerAdapter;

public class erail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://erail.in");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.id("cmbQuota"));
		Select dd = new Select(ele);
		dd.selectByVisibleText("Defence");
		//File screenbshot = (TakesScreenshot)driver.getScreenshotAs(OutputType.FILE);
		driver.close();
	}

}
