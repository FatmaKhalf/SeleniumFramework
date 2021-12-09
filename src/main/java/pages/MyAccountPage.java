package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends HomePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")
	WebElement changePasswordLink;
	@FindBy(xpath = "//*[@id=\"OldPassword\"]")
	WebElement OldPasswordTxt;
	@FindBy(xpath = "//*[@id=\"NewPassword\"]")
	WebElement newPasswordTxt;
	@FindBy(xpath = "//*[@id=\"ConfirmNewPassword\"]")
	WebElement confirmnewPasswordTxt;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button")
	WebElement changePassBtn;
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
	WebElement closeSuccessMessage;
	
	public void openChangePass()
	{
		clickBtn(changePasswordLink);
	}
	public void changepassword(String oldPass, String newPass)
	{
		setTextElementTxt(OldPasswordTxt, oldPass);
		setTextElementTxt(newPasswordTxt, newPass);
		setTextElementTxt(confirmnewPasswordTxt, newPass);
		clickBtn(changePassBtn);
		clickBtn(closeSuccessMessage);
	}

}
