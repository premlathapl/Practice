package projectTestNG;

import org.testng.annotations.DataProvider;

public class dataProvider {
	
	@DataProvider(name="dataGmail")
	public static Object[][] createData()
	{
		  Object[][] result = {{"premlathapl@gmail.com","lifestyle!29","Jeevansathi"},{"premlathapl@gmail.com","lifestyle!29","BharatMatrimony"}};
		  return result;		
	}

}
