package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddToWishlistTest extends TestBase{

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishlistPage wishlistObject;

	@Test(priority = 1)
	public void UserCanSearchForProduct()
	{
		searchObject = new SearchPage(driver);
		searchObject.productSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
	}

	@Test(priority = 2)
	public void UserCanAddProductWishlist()
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddToWishlist();
		driver.navigate().to("https://demo.nopcommerce.com"+"/wishlist");
		wishlistObject = new WishlistPage(driver);
	//	Assert.assertTrue(wishlistObject.wishlistHeader.isDisplayed());
		Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));
	}
	@Test(priority = 3)
	public void UserCanRemoveProductFromWishlist()
	{
		wishlistObject = new WishlistPage(driver);
		wishlistObject.removeProductFromWishlist();
		Assert.assertTrue(wishlistObject.emptyCartLbl.getText().contains("The wishlist is empty!"));

	}

}
