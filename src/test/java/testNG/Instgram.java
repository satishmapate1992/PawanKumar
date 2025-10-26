package testNG;

import org.testng.annotations.Test;

public class Instgram {

	@Test(groups={"regression"})
	public static void loginToInstagram() {
		
		System.out.println("Login to Instagram....");
	}
	
	@Test(groups={"regression"})
	public static void logoutFromInstgram() {
		
		System.out.println("Log out from Instagram....");
	}
}
