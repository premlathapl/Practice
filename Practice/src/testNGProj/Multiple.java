package testNGProj;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Multiple {
	
	@BeforeTest
	
	public void beforeTest() {
		
		System.out.println("beforeTest");
	}
	
@AfterTest
	
	public void afterTest() {
		
		System.out.println("AfterTest");
	}

@Test(groups = "g1")

public void test1() {
	
	System.out.println("Test1");
}
@Test(groups = "g1")
public void test2() {
	
	System.out.println("Test2");
}
@Test(groups = "g1")
public void test3() {
	
	System.out.println("Test3");
}

}

