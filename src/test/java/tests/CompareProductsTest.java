package tests;

//import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class CompareProductsTest extends TestBase{

	String productName = "Apple MacBook Pro 13-inch";
	String productName2 = "Asus N551JK-XO076H Laptop";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishlistPage wishlistObject;
	ComparePage compareObject;

	//@SuppressWarnings("deprecation")
	@Test(priority = 1)
	public void UserCanSearchForProduct() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		searchObject.productSearchUsingAutoSuggest("Mac");
	//	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		detailsObject.addToCompareBtn.click();

		searchObject.productSearchUsingAutoSuggest("Asus");
		
		//	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName2));
		detailsObject.addToCompareBtn2.click();

		//	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com"+"/compareproducts");
		compareObject = new ComparePage(driver);
		compareObject.compareProducts();

	}
	
	@Test(priority = 2)
	public void UserCanClearCompareList()
	{
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare"));

	}


}
