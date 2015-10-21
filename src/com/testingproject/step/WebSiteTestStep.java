package com.testingproject.step;

import com.infostretch.automation.step.QAFTestStep;

public class WebSiteTestStep {

	@QAFTestStep(description = "customer open google home page")
	public void openPage() {
		System.out.println("customer launch home page of website");
	}

	@QAFTestStep(description = "verify customer is on home page")
	public void verifyHomePage() {
		System.out.println("verification logic goes here");
	}

	@QAFTestStep(description = "verify customer is on home page1")
	public void verifyHomePage1() {
		System.out.println("verification logic goes here");
	}

	@QAFTestStep(description = "verify customer is on home page2")
	public void verifyHomePage2() {
		System.out.println("verification logic goes here");
	}

	@QAFTestStep(description = "verify customer is on home page3")
	public void verifyHomePage3() {
		System.out.println("verification logic goes here");
	}

	@QAFTestStep(description = "Committed AppHomePage for Sprint5_QA-001")
	public void test() {
		System.out.println("This is temp chagnes");
	}

}
