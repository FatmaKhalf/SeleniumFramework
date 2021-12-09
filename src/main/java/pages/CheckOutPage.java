package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"BillingNewAddress_FirstName\"]")
	WebElement firstnameTxt;
	@FindBy(xpath  = "//*[@id=\"BillingNewAddress_LastName\"]")
	WebElement lastnameTxt;
	@FindBy(xpath = "//*[@id=\"BillingNewAddress_Email\"]")
	WebElement mailTxt;
	@FindBy(xpath = "//*[@id=\"BillingNewAddress_CountryId\"]\r\n")
	WebElement countryList;
	@FindBy(xpath  = "//*[@id=\"BillingNewAddress_City\"]")
	WebElement cityTxt;
	@FindBy(xpath = "//*[@id=\"BillingNewAddress_Address1\"]")
	WebElement addressTxt;
	@FindBy(xpath = "//*[@id=\"BillingNewAddress_ZipPostalCode\"]")
	WebElement ZipPostalCodeTxt;
	@FindBy(xpath = "//*[@id=\"BillingNewAddress_PhoneNumber\"]")
	WebElement PhoneNumberTxt;
	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button[4]")
	WebElement countinuBtn;
	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
	WebElement countinuShippingMethodBtn;
	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
	WebElement countinuPaymentMethodBtn;
	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
	WebElement countinuPaymentInfoBtn;
	@FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/button")
	WebElement confirmBtn;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
	public WebElement ThankLbl;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")
	public WebElement orderDetailsHyberlink;
	
	public void RegisteredUserCanCheckoutProduvt(String countryName, String city, String address, String postCode, String phone) throws InterruptedException
	{
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		Thread.sleep(3000);
		setTextElementTxt(cityTxt, city);
		Thread.sleep(3000);
		setTextElementTxt(addressTxt, address);
		Thread.sleep(3000);
		setTextElementTxt(ZipPostalCodeTxt, postCode);
		Thread.sleep(3000);
		setTextElementTxt(PhoneNumberTxt, phone);
		Thread.sleep(3000);
		clickBtn(countinuBtn);
		Thread.sleep(3000);
		clickBtn(countinuShippingMethodBtn);
		Thread.sleep(3000);
		clickBtn(countinuPaymentMethodBtn);
		Thread.sleep(3000);
		clickBtn(countinuPaymentInfoBtn);
		Thread.sleep(3000);
		clickBtn(confirmBtn);
	}
	public void GuestUserCanCheckoutProduvt(String firstName,String lastName,String email,String countryName, String city, String address, String postCode, String phone) throws InterruptedException
	{
		setTextElementTxt(firstnameTxt, firstName);
		setTextElementTxt(lastnameTxt, lastName);
		setTextElementTxt(mailTxt, email);
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		Thread.sleep(3000);
		setTextElementTxt(cityTxt, city);
		Thread.sleep(3000);
		setTextElementTxt(addressTxt, address);
		Thread.sleep(3000);
		setTextElementTxt(ZipPostalCodeTxt, postCode);
		Thread.sleep(3000);
		setTextElementTxt(PhoneNumberTxt, phone);
		Thread.sleep(3000);
		clickBtn(countinuBtn);
		Thread.sleep(3000);
		clickBtn(countinuShippingMethodBtn);
		Thread.sleep(3000);
		clickBtn(countinuPaymentMethodBtn);
		Thread.sleep(3000);
		clickBtn(countinuPaymentInfoBtn);
		Thread.sleep(3000);
		clickBtn(confirmBtn);
	}
	
}
