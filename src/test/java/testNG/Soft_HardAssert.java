package testNG;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.*;

public class Soft_HardAssert {

	@Test
	void hardAssert() {
		
		Assert.assertEquals(1, 2);		
		System.out.println("Hard Assert");
	}
	
	@Test
	void softAssert() {
		
		SoftAssert as= new SoftAssert();
		as.assertEquals(1, 2);
		System.out.println("soft Assert");
		as.assertAll();
	}

}
