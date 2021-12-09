package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase{
	
	HomePage homeObject;
	UserRegistrationPage registertionObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	String frienMail = "fatmakhalf63@gmail.com";
	String message ="Hello i am sending you amazign product for test";
	SearchResultPage searchResultObject;
	ProductDetailsPage productDetailsObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registertionObject = new UserRegistrationPage(driver);
		registertionObject.userRegister("fatma", "Khalf", "Fatmaa1111@test.com", "12345678");
	}


	@org.testng.annotations.Test(priority = 2)
	public void UserCanSearchForProduct()
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearch(productName);
		searchResultObject = new SearchResultPage(driver);
		searchResultObject.openProductDetail();
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
	//  Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), productName);
		
	}
	
	@Test(priority = 3)
	public void UserCanSendMailToFriend()
	{
		
		productDetailsObject.OpenMailFrindPage();
		emailObject = new EmailPage(driver);
		emailObject.SendEmailToFriend(frienMail, message);
	}
	
	/*	@Test(priority = 2)
	public void UserCanSearchForProduct() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		searchObject.productSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Thread.sleep(3000);

	}
	
	@Test(priority = 3)
	public void UserCanSendMailToFriend(String frienMail, String message) throws InterruptedException
	{
		detailsObject.OpenMailFrindPage();
		Thread.sleep(3000);
		emailObject = new EmailPage(driver);
		emailObject.SendEmailToFriend(frienMail, message);
		Assert.assertTrue(emailObject.successMessage.getText().contains("Your message has been sent."));

	}*/
}
