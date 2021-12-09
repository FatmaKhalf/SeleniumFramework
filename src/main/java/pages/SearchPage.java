package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//*[@id=\"small-searchterms\"]")
	WebElement searchTxt;
	
	@FindBy(xpath = "//*[@id=\"ui-id-1\"]") 
	
	List<WebElement> productList;
	@FindBy(xpath = "//*[@id=\"small-search-box-form\"]/button")
	public WebElement searchBtn;
	
	public void ProductSearch(String productName)
	{
		setTextElementTxt(searchTxt, productName);
		clickBtn(searchBtn);
	}
	
	public void productSearchUsingAutoSuggest(String searchingTxt)
	{
		setTextElementTxt(searchTxt, searchingTxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productList.get(0).click();
	}

}
