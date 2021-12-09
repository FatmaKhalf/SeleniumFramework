package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"FriendEmail\"]")
	WebElement friedMailTxt;
	@FindBy(xpath = "//*[@id=\"YourEmailAddress\"]")
	WebElement yourMailTxt;
	@FindBy(xpath = "//*[@id=\"PersonalMessage\"]")
	WebElement messageTxt;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button")
	WebElement sendBtn;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]")
	public WebElement successMessage;
	
	public void SendEmailToFriend(String frindMail, String message)
	{
		setTextElementTxt(friedMailTxt, frindMail);
		setTextElementTxt(messageTxt, message);
		clickBtn(sendBtn);
	}

}
