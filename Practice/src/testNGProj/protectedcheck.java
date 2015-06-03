package testNGProj;

import org.testng.annotations.Test;

import testNgPractice.encap;

public class protectedcheck {
	@Test
	public void checkcheck()
	{
		encap en = new encap();
		en.setVar("sdsd");
		System.out.println(en.getVar());
	}

}
