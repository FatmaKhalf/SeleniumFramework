package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"Email\"]")
	WebElement emailTxt;
	@FindBy(xpath = "//*[@id=\"Password\"]")
	WebElement passwordTxt;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
	WebElement loginBtn;
	
	public void UserLogin(String mail, String password )
	{
		setTextElementTxt(emailTxt, mail);
		setTextElementTxt(passwordTxt, password);
		clickBtn(loginBtn);
	}
}
