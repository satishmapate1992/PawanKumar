package testNG;

import org.testng.annotations.*;

public class Facbook {
	
	@Test(groups={"sanity"})
	public static void loginToFacebook() {
		
		System.out.println("Login to facebook....");
	}
	
	@Test(groups={"sanity"})
	public static void logoutToFacbook() {
		
		System.out.println("Log out from facebook....");
	}
}
