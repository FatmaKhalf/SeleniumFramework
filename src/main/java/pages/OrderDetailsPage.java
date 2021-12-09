package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/a[1]")
	WebElement printBtn;
	@FindBy(xpath  = "/html/body/div[6]/div[3]/div/div/div/div[1]/a[2]")
	WebElement PDFInvoiceBtn;
	
	public void PrintOrderInvoice()
	{
		clickBtn(printBtn);
	}
	public void downloadOrderInvoice()
	{
		clickBtn(PDFInvoiceBtn);
	}

}
