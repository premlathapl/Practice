package projectTestNG;

//import interactionsExerGrid.excelExercise;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class LinkedInMethods {
	
	WebDriver driver;
	WrapperMethods wM = new WrapperMethods();
	ExcelUtility eu = new ExcelUtility();

	public String getFirstLinkText(String loc, String locVal)
	 {
		 String firstLnkTxt = "";
		 try
		 {
			 //wM = new WrapperMethods(browser,pathToXcel1,tcName,fileInput,Report);
			 WebElement  ele = wM.createWebElement(loc, locVal);
			 
			 //WebElement  lnks = driver.findElement(By.className("bd"));
			 List<WebElement> lnks = wM.createWebElementList(ele, "tagname", "a");
			 firstLnkTxt = lnks.get(0).getText();
		 }
		 catch(WebDriverException e) 
			{
				eu.addstep("Open the browser","Fail");
			}	
		 catch(Exception e) 
			{
				eu.addstep("Open the browser","Fail");
			}	
			finally
			{
				wM.takeScreenshotAndSave();
			}
		 return firstLnkTxt;

	 }
	 
	 
	 public String getFirstConnectionName(String loc, String locVal)
	 {
		 String firstConnectionTxt = "";
		 try
		 {
			// wM = new WrapperMethods(browser,pathToXcel1,tcName,fileInput,Report);
			 WebElement  ele = wM.createWebElement(loc, locVal);
			 
			 //WebElement  lnks = driver.findElement(By.className("bd"));
			 List<WebElement> lnks = wM.createWebElementList(ele, "classname", "badges");
			 firstConnectionTxt = lnks.get(0).getText();
		 }
		 catch(WebDriverException e) 
			{
				eu.addstep("Open the browser","Fail");
			}	
		 catch(Exception e) 
			{
				eu.addstep("Open the browser","Fail");
			}	
			finally
			{
				wM.takeScreenshotAndSave();
			}
		 return firstConnectionTxt;
	 }
	 
	 public void removeConnections(String connections)
	 {
		 try {
		 		wM.clickByxpath("//ul[@class='pivots']/li[2]/button");
		 }catch(WebDriverException e)
		 {
			 System.out.println("not found");
		 }
		 try{
			
				wM.clickByxpath("//ul[@class='pivots']/li[3]/button");
			}	
		 catch(WebDriverException e)
		 {
			 System.out.println("not found");
		 }
			finally
			{
				wM.takeScreenshotAndSave();
			}
	 }
	 
	 public String getResCntForElem(String connections)
	 {
			String resCnt = "";
			try
			{
				//wM = new WrapperMethods(browser,pathToXcel1,tcName,fileInput,Report);
				WebElement ele = wM.createWebElement("xpath", "//*[@id='facet-N']/fieldset/div/ol");
				List<WebElement> lst = wM.createWebElementList(ele, "tagname", "li");
				for(WebElement eleOptions: lst)
				{
					if(eleOptions.getText().contains(connections))
					{
						WebElement eleResCnt = wM.createWebElement(eleOptions, "classname", "facet-count");
						resCnt = eleResCnt.getText();
						break;
					}
				}
			}
			catch(WebDriverException e) 
			{
				eu.addstep("Open the browser","Fail");
			}	
		 catch(Exception e) 
			{
				eu.addstep("Open the browser","Fail");
			}	
			finally
			{
				wM.takeScreenshotAndSave();
			}
			return resCnt;
	 }

	 
	 public void Logout() {

			// Create the actions
		 
		 WebElement ele = wM.createWebElement("classname", "nav-profile-photo");
		 wM.move2Ele(ele);
		 wM.clickBylink("Sign Out");
		}
	 
	 public void navigateToLastPg() throws InterruptedException
	 {
			boolean blnFlag = true;
			while(blnFlag)
			{
/*				FluentWait<WebDriver> wait= new FluentWait<WebDriver>(wM.driver).withTimeout(15L, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
				WebElement ele= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next >")));*/
				WebElement ele = wM.createWebElementwithFluentWait("linktext", "Next >");
				Thread.sleep(3000);
				List<WebElement> lst = wM.createWebElementList("classname", "page-link");
				int totLnks = lst.size();
				if(ele != null)
				{ 
					lst.get(totLnks-2).click();
					Thread.sleep(3000);
				}
				else
				{
					blnFlag = false;
					break;
				}
			}
	 }
	 
		
	 public void clickOnLastLink()
	 {
		 try
		 {
			 //wM = new WrapperMethods(browser,pathToXcel1,tcName,fileInput,Report);
			 /*FluentWait<WebDriver> wait= new FluentWait<WebDriver>(wM.driver).withTimeout(15L, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
			 WebElement eleRes= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results-container")));*/
			 WebElement  eleRes = wM.createWebElementwithFluentWait("id", "results-container");

			 List<WebElement>  resLst = wM.createWebElementList(eleRes,"classname", "bd");//driver.findElement(By.className("bd"));
			 int resCnt = resLst.size()-1;
			 WebElement ele = resLst.get(resCnt);
			 List<WebElement> lnks = wM.createWebElementList(ele, "tagname", "a");
			 lnks.get(0).click();
		 }
		 catch(WebDriverException e) 
			{
				eu.addstep("Open the browser","Fail");
			}	
		 catch(Exception e) 
			{
				eu.addstep("Open the browser","Fail");
			}	
			finally
			{
				wM.takeScreenshotAndSave();
			}

	 }
	 
	 
	 public String returnTextForConnection(WebElement ele, String connections)
	 {
		 String linkTxt = "";
		 WebElement eleLnkTxt = null;
		 try
		 {
			 WebElement eleCnnt = wM.createWebElement(ele,"classname", "badges");
			 String firstConnectionTxt = eleCnnt.getText();
			 if(firstConnectionTxt.contains(connections))
			 {
				 eleLnkTxt = wM.createWebElement(ele, "tagname", "a");
				 linkTxt = eleLnkTxt.getText();
			 }
		 }
		 catch(WebDriverException e) 
			{
				eu.addstep("Open the browser","Fail");
			}	
		 catch(Exception e) 
			{
				eu.addstep("Open the browser","Fail");
			}	
			finally
			{
				wM.takeScreenshotAndSave();
			}
		 return linkTxt;
	 }
	
}
