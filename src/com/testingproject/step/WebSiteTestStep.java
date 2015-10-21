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

}
