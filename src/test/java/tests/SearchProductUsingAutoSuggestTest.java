package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggestTest extends TestBase{
	
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
	public void UserCanSearchForProduct() throws InterruptedException
	{
		Thread.sleep(3000);
		searchObject = new SearchPage(driver);
		Thread.sleep(3000);
		searchObject.productSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Thread.sleep(3000);
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));

	}
}
