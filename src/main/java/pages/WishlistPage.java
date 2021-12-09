package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase {

	public WishlistPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[4]/a")
	public WebElement productCell;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
	public WebElement wishlistHeader;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[2]/button[1]")
	public WebElement updateWishlistBtn;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[8]/button")
	WebElement removeFromWishlist;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div")
	public WebElement emptyCartLbl;
	
	public void removeProductFromWishlist()
	{
		clickBtn(removeFromWishlist);
	}

}
