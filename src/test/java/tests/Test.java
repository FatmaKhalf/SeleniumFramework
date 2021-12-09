package tests;

import pages.HomePage;

public class Test extends TestBase{
	

	HomePage homeobject;
	
	@org.testng.annotations.Test
	public void UserCanchangecurrency()
	{
		
		homeobject = new HomePage(driver);
		homeobject.changeCurrency();

	}


}
