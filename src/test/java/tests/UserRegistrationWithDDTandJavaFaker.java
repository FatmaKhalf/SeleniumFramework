package tests;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandJavaFaker extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registertionObject;
	LoginPage loginObject;
	
	Faker fakeData = new Faker();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();
	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		Thread.sleep(3000);
		registertionObject = new UserRegistrationPage(driver);
		registertionObject.userRegister(firstname, lastname, email, password);
		Thread.sleep(3000);
		registertionObject.UserLogout();
		Thread.sleep(3000);
		loginObject = new LoginPage(driver);
		homeObject.openLoginPage();
		Thread.sleep(3000);
		loginObject.UserLogin(email, password);		
		Thread.sleep(3000);
		registertionObject.UserLogout();
		Thread.sleep(3000);
	}
	
	

}
