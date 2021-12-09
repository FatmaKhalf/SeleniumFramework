package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShopingCardPage;
import pages.UserRegistrationPage;
import pages.WishlistPage;

public class RegisteredUserCheckOutTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registertionObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishlistPage wishlistObject;
	ShopingCardPage cartObject;
	String quntity = "4";
	CheckOutPage checkoutObject;

	@Test(priority = 1)
	public void RegisteredUserCanSearchForProduct() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registertionObject = new UserRegistrationPage(driver);
		registertionObject.userRegister("fatma", "Khalf", "Fatmae@test.com", "12345678");
		searchObject = new SearchPage(driver);
		Thread.sleep(3000);
		searchObject.productSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Thread.sleep(3000);
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
	}
	@Test(priority = 2)
	public void UserCanAddProductToShopingCart() throws InterruptedException
	{
		detailsObject = new ProductDetailsPage(driver);
		Thread.sleep(3000);
		detailsObject.AddToCart();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
		cartObject = new ShopingCardPage(driver);
		Assert.assertTrue(cartObject.productNameLbl.getText().contains(productName));
		Thread.sleep(3000);
		cartObject.Checkout();
	}
	
	@Test(priority = 3)
	public void UserCanCheckOutProduct() throws InterruptedException
	{
		checkoutObject = new CheckOutPage(driver);
		checkoutObject.RegisteredUserCanCheckoutProduvt("Egypt","cairo","gsrgsdfs", "234561", "5237647123");
		Assert.assertTrue(checkoutObject.ThankLbl.isDisplayed());
	}
}
