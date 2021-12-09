package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandDataProvider extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registertionObject;
	LoginPage loginObject;
	
	@DataProvider(name = "testData")
	public static Object[][] userData()
	{
		return new Object[][] {{"fatma", "Khalf", "Fat1234553@test.com", "12345678"},{"fatm", "Khalf2", "Fatm14321554@test.com", "12345678"}};	
	}
	
	@Test(priority = 1, dataProvider = "testData")
	public void UserCanRegisterSuccessfully(String fName, String lName, String mail, String pass) throws InterruptedException
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
