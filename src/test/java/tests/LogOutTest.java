package tests;

import org.testng.annotations.Test;

import pages.UserRegistrationPage;

public class LogOutTest extends TestBase{
	
	UserRegistrationPage registertionObject;

	@Test(priority = 1)
	public void RegisteredUserCanLogout()
	{
		registertionObject = new UserRegistrationPage(driver);
		registertionObject.UserLogout();
	}

}
