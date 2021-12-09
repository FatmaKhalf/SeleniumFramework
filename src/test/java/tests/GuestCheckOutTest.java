package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShopingCardPage;
import pages.UserRegistrationPage;
import pages.WishlistPage;

public class GuestCheckOutTest extends TestBase {
	HomePage homeObject;
	UserRegistrationPage registertionObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishlistPage wishlistObject;
	ShopingCardPage cartObject;
	String quntity = "4";
	CheckOutPage checkoutObject;
	OrderDetailsPage orderDetailsObject;

	@Test(priority = 1)
	public void guestCanSearchForProduct() throws InterruptedException
	{
		Thread.sleep(3000);
		searchObject = new SearchPage(driver);
		searchObject.productSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Thread.sleep(3000);
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
	}
	@Test(priority = 2)
	public void UserCanAddProductToShopingCart() throws InterruptedException
	{
		Thread.sleep(3000);
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddToCart();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
		cartObject = new ShopingCardPage(driver);
		Assert.assertTrue(cartObject.productNameLbl.getText().contains(productName));
		Thread.sleep(3000);
		cartObject.Checkout();
		Thread.sleep(3000);
		cartObject.CheckOutGuestBtn.click();
	}
	
	@Test(priority = 3)
	public void UserCanCheckOutProduct() throws InterruptedException
	{
		checkoutObject = new CheckOutPage(driver);
		checkoutObject.GuestUserCanCheckoutProduvt("fatma","khalf","test@test.com","Egypt","cairo","gsrgsdfs", "234561", "5237647123");
		Assert.assertTrue(checkoutObject.ThankLbl.isDisplayed());
		Thread.sleep(3000);
		checkoutObject.orderDetailsHyberlink.click();
		Thread.sleep(3000);
		orderDetailsObject = new OrderDetailsPage(driver);
		orderDetailsObject.downloadOrderInvoice();
		Thread.sleep(3000);
		orderDetailsObject.PrintOrderInvoice();
		
	}
}
