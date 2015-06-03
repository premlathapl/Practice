package projectTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtility {

	
	public static String fileInput;
	public static String Report;
	public static String foldPath = "";
	public static String resPath = "";
	public static String foldName = "";
	public static String tCFold = ""; 
	public static String screenShotPath = "";
	public static String excelPath = "";	
	/*public static String classname = "";*/
	public static String directoryDiv = "";
	public static String machineName = "";
	public static String classname = "";
	public static String browser = "";
	public static String classPath = "";
		/*String fileInput = "D:\\TLSELENIUM\\Learning Doc\\Week3_Feb2015\\Book1.xlsx";
		String Report = "D:\\TLSELENIUM\\Learning Doc\\Week3_Feb2015\\Book2.xlsx";*/
	
	public static void definePathAndExcelPath() throws UnknownHostException
	{
		classname = runAll.classname;
		machineName = InetAddress.getLocalHost().getHostName();
		
		if(machineName.contains("MacBook"))
			directoryDiv = "//";
		else
			directoryDiv = "/";
		
		
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
        fileInput = foldPath+directoryDiv+"data"+directoryDiv+"dataSheet.xls";
	}
	
	public static void createFolds() throws UnknownHostException
	{
		
		browser = runAll.browser;
		

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
	
		
	public static void createReport ()
	{
		try {
			//Create Workbook and worksheet
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet xs = wb.createSheet("Report");
			
			//Creating a row
			HSSFRow xr = xs.createRow(0);
			
			//Creating a columns/headers
			xr.createCell(0).setCellValue("Step_No");
			xr.createCell(1).setCellValue("Description");
			xr.createCell(2).setCellValue("Status");
			
			Report = excelPath+directoryDiv+"excelReport.xls";
			
			//Moving the file from Virtual ram to physical ram
			FileOutputStream fo = new FileOutputStream(new File(Report));
			
			wb.write(fo);
			fo.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("File not found..IO Exception");				
		}	catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unknown exception");
			e.printStackTrace();
		}
	}
	
		
		public void addstep(String desc, String status)
		{
			try {
				System.out.println(Report);
				FileInputStream is = new FileInputStream(new File(Report));
				
				HSSFWorkbook wb = new HSSFWorkbook(is);
				HSSFSheet sheet = wb.getSheet("Report");
				
				int rowCount = sheet.getLastRowNum();
				HSSFRow rw= sheet.createRow(rowCount+1);
				
				rw.createCell(0).setCellValue(rowCount+1);
				rw.createCell(1).setCellValue(desc);
				rw.createCell(2).setCellValue(status);
				
				FileOutputStream fo = new FileOutputStream(new File(Report));
				wb.write(fo);
				
				fo.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("File not found..IO Exception");				
			}	catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Unknown exception");
			}		
			
		}
	
		/*public String readFromCell(int row, int col)
		{
			String str = "";
			fileInput = foldPath+directoryDiv+"data"+directoryDiv+"dataSheet.xls";
			try
			{
				FileInputStream  fis=new FileInputStream(new File(fileInput));
				
				HSSFWorkbook wb = new HSSFWorkbook(fis);
				
				HSSFSheet sheet = wb.getSheet("input");
				
				HSSFRow rw = sheet.getRow(row);
				
				str = rw.getCell(col).getStringCellValue();
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("File not found..IO Exception");				
			}	catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Unknown exception");
			}	
			return str;
		}*/
		
		
		public String readFromCell(String header,String iterations) throws IOException
		{
			String val = "";
			try
			{
				fileInput = foldPath+directoryDiv+"data"+directoryDiv+"dataSheet.xls";
				int headCell = 0;
				FileInputStream  fis=new FileInputStream(new File(fileInput));
				
				HSSFWorkbook wb = new HSSFWorkbook(fis);
				
				HSSFSheet sheet = wb.getSheet("input");
				HSSFRow headRw = sheet.getRow(0);
				int intCols = headRw.getLastCellNum();
				for(int i=0;i<intCols;i++)
				{
					if(headRw.getCell(i).getStringCellValue().equalsIgnoreCase(header))
					{
						headCell = i;
						break;
					}
				}
				HSSFRow row;
				int inttotRw = sheet.getLastRowNum();
				int intTestRw =0 ;
				for(int i=1;i<=inttotRw;i++)
				{
					if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(classname))
					{
						if(sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(iterations))
						{
							intTestRw = i;
						}
					}
				}
				
				val = sheet.getRow(intTestRw).getCell(headCell).getStringCellValue();
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("File not found..IO Exception");				
			}	catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Unknown exception");
			}
			
			return val;
		}
		
		public int getIterationsForTestCase() throws IOException
		{
			String val = "";
			int headCell = 0;
			FileInputStream  fis=new FileInputStream(new File(fileInput));
			
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			
			HSSFSheet sheet = wb.getSheet("input");;
			HSSFRow rw;
			int inttotRw = sheet.getLastRowNum();
			int intTestRw =0 ;
			int counter = 0;
			for(int i=1;i<=inttotRw;i++)
			{
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(classname))
				{
					counter = counter+1;
				}
			}
			
			val = sheet.getRow(intTestRw).getCell(headCell).getStringCellValue();
			
			return counter;
		}
		

}