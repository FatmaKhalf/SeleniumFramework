package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		je = (JavascriptExecutor) driver;
		actions = new Actions(driver);
	}

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement RegistrationLink;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	WebElement LogInBtn;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement myAccountLink;

	@FindBy(xpath = "/html/body/div[6]/div[4]/div[1]/div[1]/ul/li[6]/a")
	WebElement contactUsLink;

	@FindBy(xpath = "//*[@id=\"customerCurrency\"]")
	WebElement currencyList;

	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement computerMenu;

	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement noteBook;


	public void openRegistrationPage()
	{
		clickBtn(RegistrationLink);
	}

	public void openLoginPage()
	{
		clickBtn(LogInBtn);
	}

	public void openMyAccountPage()
	{
		clickBtn(myAccountLink);
	}

	public void openContactUsPage()
	{
		scrollBottom();
		clickBtn(contactUsLink);
	}

	public void changeCurrency()
	{
		Select currencymenue = new Select(currencyList);
		currencymenue.selectByVisibleText("US Dollar");
		currencymenue.selectByIndex(1);

		//Select select = new Select(currencyList);
		//	select.selectByVisibleText("Euro");
	}

	public void SelectNotebookFromMenu()
	{
		actions.moveToElement(computerMenu).moveToElement(noteBook).click().build().perform();
	}
}
