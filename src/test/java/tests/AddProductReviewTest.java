package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.SearchResultPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registertionObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;
	String RviewTitle = "Test adding review";
	String RviewText ="Hello i am sending good reviw for this amazign product for test";
	SearchResultPage searchResultObject;
	ProductDetailsPage productDetailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	String succMess = "Product review is successfully added.";

	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registertionObject = new UserRegistrationPage(driver);
		registertionObject.userRegister("fatma", "Khalf", "Fatmaa1@test.com", "12345678");
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
	public void UserCanReviewProduct()
	{
		
		productDetailsObject.OpenAddReviewPage();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddProductReview(RviewTitle, RviewText);
		Assert.assertTrue(reviewObject.successMess.getText().contains(succMess));
	}
}
