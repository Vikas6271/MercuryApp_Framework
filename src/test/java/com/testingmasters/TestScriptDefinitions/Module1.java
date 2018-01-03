package com.testingmasters.TestScriptDefinitions;

import org.testng.annotations.Test;
import com.testingmasters.MercuryPages.Pg001_LoginPage;
import com.testingmasters.MercuryPages.Pg002_FLightFinderPage;
import com.testingmasters.MercuryPages.Pg003_PrefarancePage;
import com.testingmasters.MercuryPages.Pg004_SelectFlight;
import com.testingmasters.MercuryPages.Pg005_BookAFlight;
import com.testingmasters.library.BaseClass;

public class Module1 extends BaseClass
{
  @Test
  public void TC_101() 
  {
	  Pg001_LoginPage objLoginPage = new Pg001_LoginPage(driver);
	  Pg002_FLightFinderPage objFLightFinderPage = new Pg002_FLightFinderPage(driver);
	  Pg003_PrefarancePage objPrefarancePage = new Pg003_PrefarancePage(driver);
	  Pg004_SelectFlight objSelectFlight = new Pg004_SelectFlight(driver);
	  Pg005_BookAFlight objBookAFlight = new Pg005_BookAFlight(driver);
	  
	  
	  objLoginPage.launchApplication();
	  objLoginPage.login();
	  objFLightFinderPage.TripDetails();
	  objPrefarancePage.Prefarance();
	  objSelectFlight.SelectFlight();
	  objBookAFlight.PassDetails();
	  objBookAFlight.CardDetails();
	  objBookAFlight.BillingAdress();
  }
}
