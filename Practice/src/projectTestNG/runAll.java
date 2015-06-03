package projectTestNG;

import java.net.UnknownHostException;

public class runAll {
	public static String classname = "";
	public static String browser = "";
	runAll(String tcName,String browserName) {
		classname=tcName;
		browser=browserName;
		 
	 }
	ExcelUtility eu = new ExcelUtility();
	public void startExe() throws UnknownHostException
	{
		eu.createFolds();
		eu.createReport();
	}
	
	

}
