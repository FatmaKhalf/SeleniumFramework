package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrancyTest extends TestBase{
	
HomePage homeobject;
String productName = "Apple MacBook Pro 13-inch";
SearchPage searchObject;
ProductDetailsPage detailsObject;
	
	@org.testng.annotations.Test(priority = 1)
	public void UserCanchangecurrency()
	{
		
		homeobject = new HomePage(driver);
		homeobject.changeCurrency();

	}
	
	
	@Test(priority = 2)
	public void UserCanSearchForProduct()
	{
		searchObject = new SearchPage(driver);
		searchObject.productSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(detailsObject.productPriceLbl.getText().contains("€"));
		System.out.println(detailsObject.productPriceLbl.getText());

	}

}
