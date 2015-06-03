package testNGProj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Week2Hidden {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", arg1)
		WebDriver d=new FirefoxDriver();
		d.get("http://layout.jquery-dev.com/demos/iframe_local.html");
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		d.manage().window().maximize();

		d.switchTo().frame(d.findElement(By.xpath("//iframe[@class='ui-layout-center ui-layout-pane ui-layout-pane-center']")));
		//d.switchTo().frame("childIframe");
		//d.switchTo().frame(d.findElement(By.xpath("//iframe[@class='ui-layout-center ui-layout-pane ui-layout-pane-center']")));
		//
		
		//d.switchTo().frame(d.findElement(By.xpath("class="ui-layout-center ui-layout-pane ui-layout-pane-center"")));
       // d.switchTo().frame(d.findElement(By.cssSelector("body > div.ui-layout-center.ui-layout-pane.ui-layout-pane-center")));
        //d.switchTo().frame(d.findElement(By.xpath("/html/body/div[1]")));
        
        		
		
		//d.findElement(By.xpath("//div[@class='ui-layout-center ui-layout-pane ui-layout-pane-center']/p/button")).click();
       // d.findElement(By.cssSelector("body > div.ui-layout-center.ui-layout-pane.ui-layout-pane-center > p:nth-child(3) > button")).click();
        d.findElement(By.xpath("/html/body/div[1]/p[2]/button")).click();
        		
		d.switchTo().defaultContent();
		if (d.findElement(By.cssSelector("div[class='ui-layout-west ui-layout-pane ui-layout-pane-west']")).isDisplayed())
			System.out.println("Fail");
		else
			System.out.println("Pass");
		
		d.quit();
	/*	if(d.findElement(By.xpath("//div[@class='ui-layout-west ui-layout-pane ui-layout-pane-west']")).isDisplayed())
			System.out.println("Fail");
		else
			System.out.println("Pass");*/
				
	}

}
