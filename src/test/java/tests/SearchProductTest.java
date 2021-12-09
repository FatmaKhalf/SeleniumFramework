package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.PageBase;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultPage;

public class SearchProductTest extends TestBase {
	
	SearchPage searchObject;
	SearchResultPage searchResultObject;
	ProductDetailsPage productDetailsObject;
	PageBase baseObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test
	public void UserCanSearchForProduct() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearch(productName);
		searchResultObject = new SearchResultPage(driver);
		searchResultObject.openProductDetail();
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
	//  Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), productName);
		Thread.sleep(5000);
		baseObject = new PageBase(driver);
	//	baseObject.scrollBottom();
	}

}
