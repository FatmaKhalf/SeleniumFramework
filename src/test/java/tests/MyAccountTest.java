package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	
	String oldpass="12345678";
	String newpass = "123456789";
	HomePage homeObject;
	UserRegistrationPage registertionObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registertionObject = new UserRegistrationPage(driver);
		registertionObject.userRegister("fatma", "Khalf", "Fatmaa1a@test.com", oldpass);
	}
	
	@Test(priority = 2)
	public void RegisteredUserCanChangePass() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		Thread.sleep(3000);
		homeObject.openMyAccountPage();
		myAccountObject = new MyAccountPage(driver);
		Thread.sleep(3000);
		myAccountObject.openChangePass();
		Thread.sleep(3000);
		myAccountObject.changepassword(oldpass, newpass);	
		Thread.sleep(3000);

	}
	@Test(priority = 3)
	public void RegisteredUserCanLogout() throws InterruptedException
	{
		registertionObject = new UserRegistrationPage(driver);
		Thread.sleep(3000);
		registertionObject.UserLogout();
		Thread.sleep(3000);

	}
	
	@Test(priority = 4)
	public void RegisteredUserCanLogin() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		Thread.sleep(3000);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(3000);
		loginObject.UserLogin("Fatm11@test.com", newpass);
	}
	

}
