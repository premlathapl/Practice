package projectTestNG;

import java.io.File;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.ClassUtils;
import org.openqa.selenium.remote.server.handler.html5.GetLocationContext;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.GetLocation;


public class tryingToDoReport {
	
	//String classname = "TC04";
	String classname = ClassUtils.getSimpleName(getClass());
	public String foldPath = "";
	public String resPath = "";
	public String foldName = "";
	public String tCFold = ""; 
	public String screenShotPath = "";
	public String excelPath = "";
	@Test
	public void doit() throws UnknownHostException
	{
		String machineName = InetAddress.getLocalHost().getHostName();
		String directoryDiv = "";
		if(machineName.contains("MacBook"))
			directoryDiv = "//";
		else
			directoryDiv = "\\";
		
		String classPath = "";
		//Get the classpath of the selenium files
        ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)sysClassLoader).getURLs();

        for(int i=0; i< urls.length; i++)
        {
        	if(urls[i].getFile().contains("bin"))
        		classPath = urls[i].getFile();
        } 
        String[] arrFoldPath = classPath.split("bin");
        foldPath = arrFoldPath[0];
		//Creating Results Path
		resPath = foldPath+"Results";
		File f = new File(resPath);
		if (f.exists() && f.isDirectory()) {
		}
		else
		{
			new File(resPath).mkdir();
		}
		
		//Creating TC Folder
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		System.out.println(dateFormat.format(cal.getTime())); //2014/08/06 16:00:22
		System.out.println(classname+"_"+date.toString());
		
		foldName = classname+"_"+date.toString();
		foldName = foldName.replaceAll(" ", "");
		foldName = foldName.replaceAll(":", "");
		foldName = foldName.replaceAll("/", "");
		tCFold = resPath+directoryDiv+foldName;
		f = new File(tCFold);
		if (f.exists() && f.isDirectory()) {
		}
		else
		{
			new File(tCFold).mkdir();
		}
		
		//Creating Screenshots folder
		
		screenShotPath = tCFold+directoryDiv+"Screenshots";
		f = new File(screenShotPath);
		if (f.exists() && f.isDirectory()) {
		}
		else
		{
			new File(screenShotPath).mkdir();
		}
		
		//Creating Excel folder
		
		excelPath = tCFold+directoryDiv+"ExcelReport";
		f = new File(excelPath);
		if (f.exists() && f.isDirectory()) {
		}
		else
		{
			new File(excelPath).mkdir();
		}
	}

}
