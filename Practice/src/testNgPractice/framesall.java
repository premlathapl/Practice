package testNgPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class framesall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://layout.jquery-dev.com/demos/iframe_local.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int si = driver.findElementsByTagName("iframe").size();
		System.out.println(si);

	}

}
