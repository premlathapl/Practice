package testNgPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class checkGrid {
	
	@Test
	public void launchBrowser() throws MalformedURLException
	{
		//System.out.println(checkGrid.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\p.l.yadav\\Desktop\\seleniumProj\\seleniumProj\\driver\\chromedriver.exe");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hub"),dc);
		
		driver.get("http://gmail.com");
		
	}

}
