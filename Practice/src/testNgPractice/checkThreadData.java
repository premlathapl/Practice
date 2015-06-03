package testNgPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class checkThreadData {

	/**
	 * @param args
	 */
	@DataProvider(name="dataSet")
	public Object[][] data() {
		// TODO Auto-generated method stub
		return new Object[][]{{"data1"},{"data2"}};

	}
@Test(dataProvider="dataSet")
public void printData(String data)
{
	DisplayMessage dm = new DisplayMessage(data);
	dm.run();
}
}
