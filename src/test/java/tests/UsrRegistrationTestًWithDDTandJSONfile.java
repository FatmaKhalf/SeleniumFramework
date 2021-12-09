package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UsrRegistrationTestًWithDDTandJSONfile extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registertionObject;
	LoginPage loginObject;


	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() throws InterruptedException, CsvValidationException, IOException, ParseException
	{
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader(); 

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		Thread.sleep(3000);
		registertionObject = new UserRegistrationPage(driver);
		registertionObject.userRegister(jsonReader.firstname, jsonReader.lastname, jsonReader.email, jsonReader.password );
		Thread.sleep(3000);
		registertionObject.UserLogout();
		Thread.sleep(3000);
		loginObject = new LoginPage(driver);
		homeObject.openLoginPage();
		Thread.sleep(3000);
		loginObject.UserLogin(jsonReader.email, jsonReader.password);		
		Thread.sleep(3000);
		registertionObject.UserLogout();
		Thread.sleep(3000);


	}


}
