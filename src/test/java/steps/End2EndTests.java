package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.OrderDetailsPage;
import pages.PageBase;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultPage;
import pages.ShopingCardPage;
import tests.TestBase;

public class End2EndTests extends TestBase{
	
	SearchPage searchPage;
	SearchResultPage searchResultObject;
	ProductDetailsPage productDetails;
	PageBase baseObject;
	OrderDetailsPage orderPage;
	CheckOutPage checkoutPage;
	ShopingCardPage shopingCartPage;
	String productName ="Apple MacBook Pro 13-inch";
	
	@Given("user is on Home page")
	public void user_is_on_home_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	}
	@When("he search for {string}")
	public void he_search_for(String productName) throws InterruptedException {
	    Thread.sleep(3000);
	    searchPage = new SearchPage(driver);
	    searchPage.productSearchUsingAutoSuggest(productName);
	    Thread.sleep(3000);
	    productDetails = new ProductDetailsPage(driver);
	    Assert.assertTrue(productDetails.productNameBreadCrumb.getText().contains(productName));
	    Thread.sleep(3000);
	}
	@When("choose to buy two items")
	public void choose_to_buy_two_items() throws InterruptedException {
	    Thread.sleep(3000);
		shopingCartPage = new ShopingCardPage(driver);
	    Thread.sleep(3000);
		productDetails.AddToCart();
	    Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");	   
	}
	@When("moves to checkout cart and enter personal details on checkout page and place the order")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
	    Thread.sleep(3000);
		checkoutPage = new CheckOutPage(driver);
	    shopingCartPage.Checkout();
	    Thread.sleep(3000);
	    shopingCartPage.CheckOutGuestBtn.click();
	    Thread.sleep(3000);
	    checkoutPage.GuestUserCanCheckoutProduvt("fatma","khalf","test@test.com","Egypt","cairo","gsrgsdfs", "234561", "5237647123");   
	    Thread.sleep(3000);
		Assert.assertTrue(checkoutPage.ThankLbl.isDisplayed());
	    Thread.sleep(3000);
	}
	@Then("he can view the order and download the invoice")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
	    Thread.sleep(3000);
		orderPage = new OrderDetailsPage(driver);
	    checkoutPage.orderDetailsHyberlink.click();
	    orderPage = new OrderDetailsPage(driver);
	    Thread.sleep(3000);
		orderPage.downloadOrderInvoice();
		Thread.sleep(3000);
		orderPage.PrintOrderInvoice();
	    Thread.sleep(3000);

	}

}
