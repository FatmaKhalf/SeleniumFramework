package tests;

import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandPropertiesFile extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registertionObject;
	LoginPage loginObject;
	String fName = LoadProperties.userData.getProperty("firstname");
	String lName = LoadProperties.userData.getProperty("lastname");
	String mail = LoadProperties.userData.getProperty("email");
	String pass = LoadProperties.userData.getProperty("password");

	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		Thread.sleep(3000);
		registertionObject = new UserRegistrationPage(driver);
		registertionObject.userRegister(fName, lName, mail, pass);
		Thread.sleep(3000);
		registertionObject.UserLogout();
		Thread.sleep(3000);
		loginObject = new LoginPage(driver);
		homeObject.openLoginPage();
		Thread.sleep(3000);
		loginObject.UserLogin(mail, pass);		
		Thread.sleep(3000);
		registertionObject.UserLogout();
		Thread.sleep(3000);
	}
}
