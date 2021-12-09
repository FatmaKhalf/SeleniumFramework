package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShopingCardPage;
import pages.WishlistPage;

public class AddProductToShopingCartTest extends TestBase{
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishlistPage wishlistObject;
	ShopingCardPage cartObject;
	String quntity = "4";

	@Test(priority = 1)
	public void UserCanSearchForProduct()
	{
		searchObject = new SearchPage(driver);
		searchObject.productSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
	}
	@Test(priority = 2)
	public void UserCanAddProductToShopingCart() throws InterruptedException
	{
		detailsObject = new ProductDetailsPage(driver);
		Thread.sleep(2000);
		detailsObject.AddToCart();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
		cartObject = new ShopingCardPage(driver);
		Assert.assertTrue(cartObject.productNameLbl.getText().contains(productName));
		Thread.sleep(3000);
	}
	@Test(priority = 3, enabled = false)
	public void UserCanRemoveProductFromCart()
	{
		cartObject = new ShopingCardPage(driver);
		cartObject.removeProductFromCart();
		Assert.assertTrue(cartObject.emptyCartSuccessMessge.getText().contains("Your Shopping Cart is empty!"));
	}
	@Test(priority = 4)
	public void UserCanUpdateQuantity() throws InterruptedException
	{
		cartObject = new ShopingCardPage(driver);
		Thread.sleep(2000);
		cartObject.UpdateProductQuantity(quntity);
		Thread.sleep(3000);
	//	Assert.assertTrue(cartObject.totalLbl.getText().equals("$7,200.00"));

	}


}
