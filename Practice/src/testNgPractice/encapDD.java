package testNgPractice;

import org.testng.annotations.Test;

public class encapDD {
	
	@Test
	public void enCaped()
	{
		encap en = new encap();
		en.setVar("hey hi man!!");
		System.out.println(en.getVar());
	}
	


}
