package projectTestNG;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class WrapperMethods {

		
		public static WebDriver driver;
		ExcelUtility eu = new ExcelUtility();
		//Launch the browser
		public void launchBrowser(String browser,String URL)	
		{
			try 
			{
				eu = new ExcelUtility();	
				eu.createReport();	
				//Validate and launch the browser
				if(browser.equalsIgnoreCase("Firefox"))
				{
					driver = new FirefoxDriver();
					System.out.println("Launching Firefox");
				}
				else 
				{
					//System.setProperty("webdriver.chrome.driver","//Users//premlathayadav//Documents//SeleTraining//SeleTraining//driver//chromedriver");			
					System.setProperty("webdriver.chrome.driver","C:\\Users\\p.l.yadav\\Desktop\\seleniumProj\\Practice\\driver\\chromedriver.exe");
					//Launching the Chrome driver
					driver = new ChromeDriver();				
				}			
				
				//Maximize the browser
				driver.manage().window().maximize();
				
				//Wait for the page to load
				driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);	
				
				//Launch the URL
				driver.get(URL);
				
				eu.addstep("Open the browser","Pass");
				
			}catch(WebDriverException e) 
			{
				eu.addstep("Open the browser","Fail");
			}	
			catch(Exception e1) 
			{
				eu.addstep("Unknown exception","Fail");
			}	
			finally
			{
				takeScreenshotAndSave();
			}
			
		}
		
	
		//Enter the value by id
		public void enterValueById(String value,String data)
		//ExcelUtility eu = new ExcelUtility();
		{
			try {
				driver.findElement(By.id(value)).clear();
				driver.findElement(By.id(value)).sendKeys(data);
				eu.addstep("Enter in the value", "Pass");
				
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}			
			finally
			{
				takeScreenshotAndSave();
			}
		}
		
		//Method to enter the value to field by name
		public void enterValueByName(String value,String data)
		//ExcelUtility eu = new ExcelUtility();
		{
			
			try {
				driver.findElement(By.name(value)).clear();
				driver.findElement(By.name(value)).sendKeys(data);
				eu.addstep("Enter in the value", "Pass");
				
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}			
			finally
			{
				takeScreenshotAndSave();
			}
		}

		//Verify text by class name(sa.verifyTextClass("loginError", "Your login attempt has failed.")
		public void verifyTextClass(String value, String msg)	
		{
		
			try {
				String text=driver.findElement(By.className(value)).getText();
				
				if(text.equals(msg))
				{
					eu.addstep("Verify the text present matched", "Pass");
				}else
					
				{
					eu.addstep("Verify the text present not matched", "Pass");
				}
				
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}		
			finally
			{
				takeScreenshotAndSave();
			}
		}
		
		//Verify the text by id(sa.verifyTextClass("loginError", "Your login attempt has failed.")
		public void verifyText(String value, String msg) 
		{
			
			try {
				String text1=driver.findElement(By.id(value)).getText();
				
				if(text1.equals(msg))
				{	
					eu.addstep("Element matched", "Pass");
					
				}else
				{
					eu.addstep("Element not matched", "Pass");
				}
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}
			finally
			{
				takeScreenshotAndSave();
			}
		}		       
		
		//Verify the text by id(sa.verifyTextClass("loginError", "Your login attempt has failed.")
		public void verifyTextByXpath(String value, String msg) 
		{
			
			try {
				String text1=driver.findElement(By.xpath(value)).getText();
				
				if(text1.equals(msg))
				{
					eu.addstep("Element matched", "Pass");
					
				}else
					
				{
					eu.addstep("Element not matched", "Pass");
				}
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}
			finally
			{
				takeScreenshotAndSave();
			}
		}		       
		
		
		//Method to select checbox
		public void selectCheckbox(String strChekbox) 
		{
			
			try{			
				driver.findElement(By.id(strChekbox)).click();
				waitForPgLoad();
			}catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			finally
			{
				takeScreenshotAndSave();
			}
			
		/*	Thread.sleep(5000);
			if (!driver.findElement(By.id(strChekbox)).isSelected())
			{
				driver.findElement(By.id(strChekbox)).click();
			}
			else
			{
				System.out.println("I am already selected....");
			}*/			
		}
		
		//Click by ID
		public void clickById(String value) 	
		{
			
			try {
				driver.findElement(By.id(value)).click();
				waitForPgLoad();
				eu.addstep("Click successful", "Pass");
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			finally
			{
				takeScreenshotAndSave();
			}
		}
		
		
		//Method to click Login using xpath	
		public void clickByxpath(String strXpath)	
		{
			
			try {
				driver.findElement(By.xpath(strXpath)).click();	
				waitForPgLoad();
				eu.addstep("Click successful", "Pass");
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Element not found..with foloowing message: "+e.getMessage());
				//eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				//eu.addstep("Driver is being closed", "Fail");
				System.out.println("Driver is being closed..with foloowing message: "+e.getMessage());
			}catch (Exception e) {
				// TODO Auto-generated catch block
				//eu.addstep("Unkmown exception thrown", "Fail");
				System.out.println("Unkmown exception thrown..with foloowing message: "+e.getMessage());
			}	
			finally
			{
				takeScreenshotAndSave();
			}
		}
		
		
		//Method to click by name	
		public void clickByName(String strName) 	
		{
			
			try {
				driver.findElement(By.name(strName)).click();
				waitForPgLoad();
				eu.addstep("Click successful", "Pass");
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			finally
			{
				takeScreenshotAndSave();
			}
		}
		
		//Method to click logout(Link)	
		public void clickBylink(String strLink)	
		{
			
			try {
				driver.findElement(By.linkText(strLink)).click();
				waitForPgLoad();
				eu.addstep("Click successful", "Pass");
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			finally
			{
				takeScreenshotAndSave();
			}
		}
		
		
		//Method to click by class
		public void clickByClass(String strClass)	
		{
			
			try {
				driver.findElement(By.className(strClass)).click();
				waitForPgLoad();
				eu.addstep("Click successful", "Pass");
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			finally
			{
				takeScreenshotAndSave();
			}
		}
		
		
		//Method to selectValueByText
		public void selectValueByText(String strItem)
		{			 
			try
			{
				Select objText = new Select(driver.findElement(By.name(strItem)));
				objText.selectByVisibleText(strItem);
			}
			catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			finally
			{
				takeScreenshotAndSave();
			}
		}
		
		 //Method to selectValueByText
        public void selectValueByIndex(String strItem)
        {                  
        	try
        	{
                        int strIndex = Integer.parseInt(strItem);
                        Select objText = new Select(driver.findElement(By.name(strItem)));
                        objText.selectByIndex(strIndex);    
        	}
        	catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			finally
			{
				takeScreenshotAndSave();
			}
        }
       
        //Closing all the browsers
   		public void quit()
   		{
   			
   			try{
   				driver.quit();	
   			}catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			/*finally
			{
				takeScreenshotAndSave();
			}*/
   								
   		}	
       
		 //Close the particular browser)
		public void closeDriver() 
		{
			
			try{
				driver.close();	
			}catch(WebDriverException e){
				eu.addstep("Driver is being closed", "Fail");
			}
			finally
			{
				takeScreenshotAndSave();
			}
								
		}	
		
        //switchToPrimaryWindow
        public String switchToPrimaryWindow() 
        {        	
        	return  driver.getWindowHandle();   	
        	  		
    		//System.out.println("The parent handler of the window is "+ parenthandler);
    		//driver.switchTo().window(parenthandler);
        }
        
        public void switchWindow(String handle) {
        	try{
        		driver.switchTo().window(handle);
        	}catch(NoSuchWindowException e)
        	{
        		eu.addstep("No such window", "Fail");
        	}
        	
        }
        
        //switchtoLastwindow
        public void switchtoLastwindow()
        {
        	Set<String> allwindows = driver.getWindowHandles();
        	for(String object:allwindows)
        	{
        		System.out.println("The current window handler is "+ object);
        		driver.switchTo().window(object);
        	}
        }        
        
        //switchToFrameByElement
        public void switchToFrameByElement(String frameElement)
        {    	
        		driver.switchTo().frame(frameElement);
        		System.out.println("Navigated to frame with element "+frameElement);     
        }
        
        //Switch to first frame
        public void switchtoDefaultFrame()
        {
        	driver.switchTo().defaultContent();
			System.out.println("Navigated back to webpage from frame");
        }
        
        //Switch to alert
        public void acceptAlert()
        {
        	//Take the control of the alert
        	Alert alert = driver.switchTo().alert();
        	
        	//Get and print the text on the alert box
        	System.out.println(alert.getText());
        	
        	//okay button
        	alert.accept();
        }
        
        //switch to dismiss alert
        public void dismissAlert()
        {
        	driver.switchTo().alert().dismiss();
        }
        

        //get the Title
        public void verifyTitle(String strInpTxt)
        {
        	String strGetTxt = driver.getTitle();
        	Assert.assertEquals(strGetTxt, strInpTxt);
        	if(strGetTxt.contains(strInpTxt))
        		eu.addstep("Browser title is as expected which is:"+strInpTxt, "Pass");
        	else
        		eu.addstep("Browser title is not as expected which is:"+strInpTxt+" The current title is:"+strGetTxt, "Fail");
        }
        
        //get the URL
        public void verifyURL(String strURL)
        {
        	try
        	{
	        	String strGetCurUrl = driver.getCurrentUrl();
	        	Assert.assertEquals(strGetCurUrl, strURL);
        	}
        	catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			finally
			{
				takeScreenshotAndSave();
			}
   			
        }
        

        
        //Click the Month followed by clicking of dropdown. To Enter the DOB. Collect the list items
        public void dropdown(String strClass, String strdropdownIndex, String strValue)
        {
        	try
        	{
	        	List<WebElement> dobLst =  driver.findElements(By.className(strClass));
	        	System.out.println("Total dropdown for the class - "+ strClass + " is "+dobLst.size());
	        	
	        	int strIntIndex = Integer.parseInt(strdropdownIndex);
	        	
	        	//click the dropdown
	        	dobLst.get(strIntIndex).click();        	
	        	//select value 
	        	driver.findElement(By.linkText(strValue)).click();   
        	}
			catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			finally
			{
				takeScreenshotAndSave();
			}
        	
        }
        

    	@SuppressWarnings("finally")
    	public By locBy(String loc, String locVal)
    	{
    		By by = null;
    		try
    		{
    			switch(loc.toUpperCase()){
    			
    			case "ID": 			by = By.id(locVal);
    								break;
    			case "XPATH": 		by = By.xpath(locVal);
    								break;	
    			case "LINKTEXT":	by = By.linkText(locVal);
    								break;
    			case "CSS": 		by = By.cssSelector(locVal);
    								break;
    			case "CLASSNAME":	by = By.className(locVal);
    								break;
    			case "TAGNAME":		by = By.tagName(locVal);
    								break;
    			case "NAME":		by = By.name(locVal);
    			break;
    			
    			}
    		}
			catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			finally
			{
				return by;
			}
    	}
    	
    	@SuppressWarnings("finally")
    	public WebElement createWebElement(String loc, String locVal)
    	{
    		WebElement ele = null;
    		try
    		{
    			By by = locBy(loc, locVal);
    			ele = driver.findElement(by);
    		}
    		catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Element not found..with foloowing message: "+e.getMessage());
				//eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				//eu.addstep("Driver is being closed", "Fail");
				System.out.println("Driver is being closed..with foloowing message: "+e.getMessage());
			}catch (Exception e) {
				// TODO Auto-generated catch block
				//eu.addstep("Unkmown exception thrown", "Fail");
				System.out.println("Unkmown exception thrown..with foloowing message: "+e.getMessage());
			}
			finally
			{
				return ele;
			}
    	}
    	
    	public List<WebElement> createWebElementList(String loc, String locVal)
    	{
    		List<WebElement> lst = null;
    		try
    		{
    			By by = locBy(loc, locVal);
    			lst = driver.findElements(by);
    		}
    		catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Element not found..with foloowing message: "+e.getMessage());
				//eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				//eu.addstep("Driver is being closed", "Fail");
				System.out.println("Driver is being closed..with foloowing message: "+e.getMessage());
			}catch (Exception e) {
				// TODO Auto-generated catch block
				//eu.addstep("Unkmown exception thrown", "Fail");
				System.out.println("Unkmown exception thrown..with foloowing message: "+e.getMessage());
			}
    		finally
    		{
    			return lst;
    		}
    	}
    	
    	
    	
    	public List<WebElement> createWebElementList(WebElement ele, String loc, String locVal)
    	{
    		List<WebElement> lst = null;
    		try
    		{
    			By by = locBy(loc, locVal);
    			lst = ele.findElements(by);
    		}
			catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			finally
			{
				return lst;
			}
    	}
    	
    	@SuppressWarnings("finally")
    	public WebElement createWebElement(WebElement ele, String loc, String locVal)
    	{
    		WebElement eleM = null;
    		try
    		{
    			By by = locBy(loc, locVal);
    			eleM = ele.findElement(by);
    		}
			catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				eu.addstep("Driver is being closed", "Fail");
			}catch (Exception e) {
				// TODO Auto-generated catch block
				eu.addstep("Unkmown exception thrown", "Fail");
			}	
			finally
			{
				return eleM;
			}
    	}
    	
    	public String getTextByXpath(String value) 
    	{
    		String text1=null;
			
			try {
				text1=driver.findElement(By.xpath(value)).getText();
				
				eu.addstep("Value Retrieved", text1);
				
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Element not found..with foloowing message: "+e.getMessage());
				//eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				//eu.addstep("Driver is being closed", "Fail");
				System.out.println("Driver is being closed..with foloowing message: "+e.getMessage());
			}catch (Exception e) {
				// TODO Auto-generated catch block
				//eu.addstep("Unkmown exception thrown", "Fail");
				System.out.println("Unkmown exception thrown..with foloowing message: "+e.getMessage());
			}	
			return text1;
		}
    	
    	public int stringtoint (String value)
    	{
    		 int num = Integer.parseInt(value);
    		 eu.addstep("Value Converted from String to Integer", value);
    		 return num;
    		 
    	}
    	
    	public void takeScreenshotAndSave()
    	{
    		try
    		{
    			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    			Calendar cal = Calendar.getInstance();
    			String date = dateFormat.format(cal.getTime());
    			String snapTime = date.toString();
    			snapTime = snapTime.replaceAll(" ", "");
    			snapTime = snapTime.replaceAll(":", "");
    			snapTime = snapTime.replaceAll("/", "");
    			File screenShotSrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    			FileUtils.copyFile(screenShotSrcFile, new File(eu.screenShotPath+eu.directoryDiv+eu.classname+"_"+eu.browser+"_"+snapTime+".png"));
    		}
    		catch(IOException e)
    		{
    			eu.addstep("Unable to take screenshot", "Fail");
    		}
    	}
    	
    	public void move2Ele(WebElement ele){
    		Actions action = new Actions(driver);
    		action.moveToElement(ele).build().perform();
    	}
    	
    	public void selectValFromDropDown(String loc, String locVal,String selBy, String val) throws IOException
    	{
    		try
    		{
    			WebElement ele = createWebElement(loc, locVal);
    			Select sel = new Select(ele);
    			
    			switch(selBy.toUpperCase())
    			{
    				case "INDEX": 
    					int intVal = Integer.parseInt(val);
    					sel.selectByIndex(intVal);
    					break;
    				case "VISIBLETEXT":
    					sel.selectByVisibleText(val);
    				case "VALUE":
    					sel.selectByValue(val);
    			}			
    			eu.addstep("Value "+val+" selectd successfully", "Pass");
    		}
    		catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Element not found..with foloowing message: "+e.getMessage());
				//eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				//eu.addstep("Driver is being closed", "Fail");
				System.out.println("Driver is being closed..with foloowing message: "+e.getMessage());
			}catch (Exception e) {
				// TODO Auto-generated catch block
				//eu.addstep("Unkmown exception thrown", "Fail");
				System.out.println("Unkmown exception thrown..with foloowing message: "+e.getMessage());
			}	
    		finally
    		{
    			takeScreenshotAndSave();
    		}
    		
    	}
    	
    	public WebElement createWebElementwithFluentWait(String loc, String locVal)
    	{
    		WebElement eleM = null;
    		try
    		{
    			By by = locBy(loc, locVal);
    			FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(15L, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
    			eleM= wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    		}
    		catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("Element not found..with foloowing message: "+e.getMessage());
				//eu.addstep("Element not found", "Fail");
			}
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
				//eu.addstep("Driver is being closed", "Fail");
				System.out.println("Driver is being closed..with foloowing message: "+e.getMessage());
			}catch (Exception e) {
				// TODO Auto-generated catch block
				//eu.addstep("Unkmown exception thrown", "Fail");
				System.out.println("Unkmown exception thrown..with foloowing message: "+e.getMessage());
			}	
			finally
			{
				return eleM;
			}
    	}
    	
    	public void waitForPgLoad() {
    	    ExpectedCondition<Boolean> pageLoadCondition = new
    	        ExpectedCondition<Boolean>() {
    	            public Boolean apply(WebDriver driver) {
    	                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
    	            }
    	        };
    	    WebDriverWait wait = new WebDriverWait(driver, 30);
    	    wait.until(pageLoadCondition);
    	}
    	

    	
}