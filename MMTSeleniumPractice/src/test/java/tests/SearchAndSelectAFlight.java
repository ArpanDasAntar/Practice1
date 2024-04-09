package tests;

import org.testng.annotations.Test;

public class SearchAndSelectAFlight extends BaseTest {
	
	@Test
	public void checkLandingPage() throws InterruptedException {
		hp.checkMMTLogo();
		//hp.closeAdvert();
		hp.selectFlightPath();
	}	
}
