package testNgPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class checkThreadPOI {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("C:\\Users\\p.l.yadav\\Desktop\\seleniumProj\\Practice\\data\\dataSheet.xls");
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row = sheet.getRow(1);
		System.out.println("check");
		DisplayMessage dm = new DisplayMessage(row.getCell(0).getStringCellValue());
		dm.run();
		DisplayMessage dm1 = new DisplayMessage(row.getCell(1).getStringCellValue());
		dm1.run();

	}

}
