package testNG;

import org.testng.annotations.Test;

public class Twitter {

	@Test(groups={"sanity","regression"})
	public static void loginToInstagram() {
		
		System.out.println("Login to twitter....");
	}
	
	@Test(groups={"sanity","regression"})
	public static void logoutFromInstgram() {
		
		System.out.println("Log out from twitter....");
	}
}
