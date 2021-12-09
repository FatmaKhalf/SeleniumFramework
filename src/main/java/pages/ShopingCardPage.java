package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopingCardPage extends PageBase {

	public ShopingCardPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[7]/button")
	WebElement removefromcartBtn;
	@FindBy(css  = "input.qty-input")
	WebElement quentityTxt;
	@FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[2]/div[1]/button[1]")
	WebElement updatecartBtn;
	@FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[6]/span")
	public WebElement totalLbl;
	@FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a")
	public WebElement productNameLbl;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div")
	public WebElement emptyCartSuccessMessge;
	@FindBy(xpath = "//*[@id=\"termsofservice\"]")
	WebElement TermsCheckboc;
	@FindBy(xpath = "//*[@id=\"checkout\"]")
	WebElement checkoutBtn;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")
	public WebElement CheckOutGuestBtn;
	
	
	public void removeProductFromCart()
	{
		clickBtn(removefromcartBtn);
	}
	
	public void UpdateProductQuantity(String quntity)
	{	
		clearTxt(quentityTxt);
		setTextElementTxt(quentityTxt, quntity);
		clickBtn(updatecartBtn);
	}
	public void Checkout() {
		clickBtn(TermsCheckboc);
		clickBtn(checkoutBtn);
	}
	
}
