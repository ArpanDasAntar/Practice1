package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CrickInfoTest extends BaseTest {
	SoftAssert sa = new SoftAssert();
	
	@Test
	public void firstIndianPlayer() throws InterruptedException {
		
		cp.hoverOnTeams();
		cp.openIndianTeamlist();
		//cp.closeAdvert();
		cp.goToPlayrsTab();
		String expPlayerName="Ahuja, KS";
		String actPlayerName = cp.getFirstPlayerName();
		System.out.println(actPlayerName);
		sa.assertEquals(actPlayerName, expPlayerName);
		
	}
	@Test
	public void firstNZPlayer() throws InterruptedException {
		cp.closenoti();
		cp.goToHomePage();
		cp.hoverOnTeams();
		cp.openNZTeamlist();
		//cp.closeAdvert();
		cp.goToPlayrsTab();
		String expPlayerName="Allen, FH";
		String actPlayerName = cp.getFirstPlayerName();
		System.out.println(actPlayerName);
		sa.assertEquals(actPlayerName, expPlayerName);
		
	}
}
