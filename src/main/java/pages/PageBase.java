package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
protected WebDriver driver;
public JavascriptExecutor je;
public Select select;
public Actions actions;
	
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	protected static void clickBtn(WebElement Button)
	{
		Button.click();
	}
	protected static void setTextElementTxt(WebElement txtElement, String value)
	{
		txtElement.sendKeys(value);
	}
	public void scrollBottom()
	{
		je.executeScript("window.scrollBy(0, 2500)");
	}
	public void scrollMiddle()
	{
		je.executeScript("window.scrollBy(0, 1000)");
	}
	public void clearTxt(WebElement element)
	{
		element.clear();
	}
	

}
