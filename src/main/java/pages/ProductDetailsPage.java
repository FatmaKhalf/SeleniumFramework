package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		je = (JavascriptExecutor) driver;
	}

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/ul/li[4]/strong")
	public WebElement productNameBreadCrumb;
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[10]/div[3]/button")
	WebElement emailFrindBtn;
	@FindBy(xpath = "//*[@id=\"price-value-4\"]")
	public WebElement productPriceLbl;
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[3]/div[2]/a[2]")
	WebElement addReviewLink;
	@FindBy(xpath = "//*[@id=\"add-to-wishlist-button-4\"]")
	WebElement addToWishlistBtn;
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p/a")
	WebElement wishlistLink;
	@FindBy(xpath  = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[10]/div[2]")
	public WebElement addToCompareBtn;
	@FindBy(xpath  = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[9]/div[2]/button")
	public WebElement addToCompareBtn2;
	@FindBy(xpath = "//*[@id=\"add-to-cart-button-4\"]")
	WebElement addToCartBtn;
	

	public void OpenMailFrindPage()
	{
		scrollMiddle();
		clickBtn(emailFrindBtn);
	}
	public void OpenAddReviewPage()
	{
		scrollMiddle();
		clickBtn(addReviewLink);
	}

	public void AddToWishlist()
	{
		scrollMiddle();
		clickBtn(addToWishlistBtn);  
	}
	
	public void AddToCart()
	{
		clickBtn(addToCartBtn);
	}
	

}
