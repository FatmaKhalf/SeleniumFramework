package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class HoverMenuTest extends TestBase {
	
	HomePage homeObject;
	
	@Test
	public void UserCanSelectFromMenuUsingHoverOnIt()
	{
		homeObject = new HomePage(driver);
		homeObject.SelectNotebookFromMenu();
//		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
