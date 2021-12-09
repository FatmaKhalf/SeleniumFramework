package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(xpath = "//*[@id=\"FullName\"]")
	WebElement nameTxt;
	@FindBy(xpath = "//*[@id=\"Email\"]")
	WebElement emailTxt;
	@FindBy(xpath = "//*[@id=\"Enquiry\"]")
	WebElement enquiryTxt;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button")
	WebElement submitBtn;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]")
	public WebElement successMessge;
	
	public void contactUs(String name, String mail, String enquiry)
	{
		setTextElementTxt(nameTxt, name);
		setTextElementTxt(emailTxt, mail);
		setTextElementTxt(enquiryTxt, enquiry);
		clickBtn(submitBtn);
	}

}
