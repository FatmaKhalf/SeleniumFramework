package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends HomePage {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"gender-female\"]")
	WebElement genderCheck;
	@FindBy(xpath = "//*[@id=\"FirstName\"]")
	WebElement firstNameTxt;
	@FindBy(xpath = "//*[@id=\"LastName\"]")
	WebElement lastNameTxt;
	@FindBy(xpath = "//*[@id=\"Email\"]")
	WebElement emailTxt;
	@FindBy(xpath = "//*[@id=\"Password\"]")
	WebElement passwordTxt;
	@FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
	WebElement confirmPasswordTxt;
	@FindBy(xpath = "//*[@id=\"register-button\"]")
	WebElement RegisterBtn;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a")
	WebElement continueBtn;
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	WebElement LogOutBtn;
	
	public void userRegister(String fname , String lname, String mail, String password)
	{
		genderCheck.click();
		firstNameTxt.sendKeys(fname);
		lastNameTxt.sendKeys(lname);
		emailTxt.sendKeys(mail);
		passwordTxt.sendKeys(password);
		confirmPasswordTxt.sendKeys(password);
		RegisterBtn.click();
		clickBtn(continueBtn);
		
	}
	public void UserLogout()
	{
		clickBtn(LogOutBtn);
	}

}
