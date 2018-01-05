package com.testingHRM;

import org.testng.annotations.Test;

import com.testingmasters.hrm.Pg1_LogInPage;
import com.testingmasters.hrm.Pg2_HomePage;
import com.testingmasters.hrm.Pg3_MyInfoPage;
import com.testingmasters.hrm.Pg4_QualificationPage;
import com.testingmasters.hrm.Pg5_Add_WorkExp;
import com.testingmasters.hrm.Pg6_Add_Education;
import com.testingmasters.hrm.Pg7_Add_Skills;
import com.testingmasters.hrm.Pg8_Add_Language;
import com.testingmasters.hrm.Pg9_Add_license;
import com.testingmasters.library.BaseClass;

public class Module1 extends BaseClass {
	@Test(priority = 1)
	public void TC101_AddQualificationDetails_WorkExperience() {
		Pg1_LogInPage login = new Pg1_LogInPage(driver);
		Pg2_HomePage home = new Pg2_HomePage(driver);
		Pg3_MyInfoPage myinfo = new Pg3_MyInfoPage(driver);
		Pg4_QualificationPage qualifications = new Pg4_QualificationPage(driver);
		Pg5_Add_WorkExp Workexp = new Pg5_Add_WorkExp(driver);

		login.launchapp();
		login.login();
		home.click_MyInfo();
		myinfo.Qualifications();
		qualifications.Add_Workexp();
		Workexp.AddWorkExp();
		qualifications.Dlt_Workexp();
		Workexp.verification();
		login.logout();
	}

	@Test(priority = 2)
	public void TC102_AddQualificationDetails_Education() {
		Pg1_LogInPage login = new Pg1_LogInPage(driver);
		Pg2_HomePage home = new Pg2_HomePage(driver);
		Pg3_MyInfoPage myinfo = new Pg3_MyInfoPage(driver);
		Pg4_QualificationPage qualifications = new Pg4_QualificationPage(driver);
		Pg6_Add_Education Education = new Pg6_Add_Education(driver);

		login.launchapp();
		login.login();
		home.click_MyInfo();
		myinfo.Qualifications();
		qualifications.Add_Education();
		Education.AddEdu();
		qualifications.Dlt_Education();
		Education.verify();
		login.logout();
	}

	@Test(priority = 3)
	public void TC103_AddQualificationDetails_Skills() {
		Pg1_LogInPage login = new Pg1_LogInPage(driver);
		Pg2_HomePage home = new Pg2_HomePage(driver);
		Pg3_MyInfoPage myinfo = new Pg3_MyInfoPage(driver);
		Pg4_QualificationPage qualifications = new Pg4_QualificationPage(driver);
		Pg7_Add_Skills skills = new Pg7_Add_Skills(driver);

		login.launchapp();
		login.login();
		home.click_MyInfo();
		myinfo.Qualifications();
		qualifications.Add_Skill();
		skills.Add_Skill();
		qualifications.Dlt_Skill();
		skills.verify();
		login.logout();
	}

	@Test(priority = 4)
	public void TC104_AddQualificationDetails_Languages() {
		Pg1_LogInPage login = new Pg1_LogInPage(driver);
		Pg2_HomePage home = new Pg2_HomePage(driver);
		Pg3_MyInfoPage myinfo = new Pg3_MyInfoPage(driver);
		Pg4_QualificationPage qualifications = new Pg4_QualificationPage(driver);
		Pg8_Add_Language language = new Pg8_Add_Language(driver);

		login.launchapp();
		login.login();
		home.click_MyInfo();
		myinfo.Qualifications();
		qualifications.Add_Lang();
		language.Add_lang();
		qualifications.Dlt_Lang();
		language.verify();
		login.logout();
	}

	@Test(priority = 5)
	public void TC105_AddQualificationDetails_License() {
		Pg1_LogInPage login = new Pg1_LogInPage(driver);
		Pg2_HomePage home = new Pg2_HomePage(driver);
		Pg3_MyInfoPage myinfo = new Pg3_MyInfoPage(driver);
		Pg4_QualificationPage qualifications = new Pg4_QualificationPage(driver);
		Pg9_Add_license license = new Pg9_Add_license(driver);

		login.launchapp();
		login.login();
		home.click_MyInfo();
		myinfo.Qualifications();
		qualifications.Add_License();
		license.Add_Licence();
		qualifications.Dlt_License();
		license.verify();
		login.logout();
	}

}
