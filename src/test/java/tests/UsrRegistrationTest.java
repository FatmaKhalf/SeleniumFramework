package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UsrRegistrationTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registertionObject;
	LoginPage loginObject;
	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registertionObject = new UserRegistrationPage(driver);
		registertionObject.userRegister("fatma", "Khalf", "Fatm11@test.com", "12345678");
	}
	
	@Test(priority = 2)
	public void RegisteredUserCanLogout()
	{
		registertionObject.UserLogout();
	}
	
	@Test(priority = 3)
	public void RegisteredUserCanLogin()
	{
		loginObject = new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.UserLogin("Fatm11@test.com", "12345678");
	}
	

}
