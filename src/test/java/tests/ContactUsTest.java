package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	
	HomePage homeobject;
	ContactUsPage contactUsObject;
	
	String fullName = "Fatma Saber";
	String mail = "fs@tes.com";
	String enquiry = "tets";
	
	@Test
	public void UseContactUs()
	{
		homeobject = new HomePage(driver);
		contactUsObject = new ContactUsPage(driver);
		homeobject.openContactUsPage();
		contactUsObject.contactUs(fullName, mail, enquiry);
		Assert.assertTrue(contactUsObject.successMessge.getText().contains("Your enquiry has been successfully sent to the store owner."));

	}

}
