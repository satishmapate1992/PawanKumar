package excel;

import org.testng.annotations.*;

public class DataProviderTest {

	
	@Test(dataProvider = "dp")
	public static void testRun(Object a, Object b) {
		
		System.out.println(a+"-"+b);
	}
	
/*	@DataProvider(name="dp")
	public Object[][] run(){
		
		Object[][] str= {
							{"abc@gmail.com","a23df4"},
							{"xyz@gmail.com","b23df4"},
							{"dfg@gmail.com","f23df4"},
				
						};		
		return str;	
	}
	
*/
	
	@DataProvider(name="dp",indices = {0,2})
	public Object[][] run(){
		
		Object[][] str= {
							{"abc@gmail.com","a23df4"},
							{"xyz@gmail.com","b23df4"},
							{"dfg@gmail.com","f23df4"},
				
						};		
		return str;	
	}
}
