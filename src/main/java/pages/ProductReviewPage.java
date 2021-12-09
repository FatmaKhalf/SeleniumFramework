package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//*[@id=\"AddProductReview_Title\"]")
    WebElement reviewTitleTxt;
	@FindBy(xpath = "//*[@id=\"AddProductReview_ReviewText\"]")
	WebElement reviewText;
	@FindBy(xpath = "//*[@id=\"addproductrating_4\"]")
	WebElement raing4radioBtns;
	@FindBy(xpath = "//*[@id=\"review-form\"]/form/div[2]/button")
	WebElement submitReviewBtn;
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")
	public WebElement successMess;
	
	public void AddProductReview(String reviewTitle, String reviewTxt)
	{
		setTextElementTxt(reviewTitleTxt, reviewTitle);
		setTextElementTxt(reviewText, reviewTxt);
		clickBtn(raing4radioBtns);
		clickBtn(submitReviewBtn);
	}
}
