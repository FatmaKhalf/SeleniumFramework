package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UsrRegistrationTestًWithDDTandCSVfile extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registertionObject;
	LoginPage loginObject;
	
	CSVReader reader;
	
	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() throws InterruptedException, CsvValidationException, IOException
	{
		String CSV_file = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		
		String[] csvCell;
		while ((csvCell = reader.readNext()) != null) {
			String firstName = csvCell[0];
			String lastName = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
			
			homeObject = new HomePage(driver);
			homeObject.openRegistrationPage();
			Thread.sleep(3000);
			registertionObject = new UserRegistrationPage(driver);
			registertionObject.userRegister(firstName, lastName, email, password);
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
	

}
