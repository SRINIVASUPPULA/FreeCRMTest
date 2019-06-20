package com.crm.qa.util;

import java.io.IOException;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public TestUtil() throws IOException {
		super();
	}

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public void switchToMainFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
}
