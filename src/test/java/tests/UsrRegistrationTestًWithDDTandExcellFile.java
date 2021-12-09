package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcellReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UsrRegistrationTestًWithDDTandExcellFile extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registertionObject;
	LoginPage loginObject;
	
	@DataProvider(name = "ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		ExcellReader ER = new ExcellReader();
		return ER.getExcelData();
	}
	
	@Test(priority = 1, dataProvider = "ExcelData")
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
