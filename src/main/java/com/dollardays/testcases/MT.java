package com.dollardays.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MT {
	public static Logger APPLICATION_LOGS = Logger.getLogger(MT.class);

	@BeforeClass
	public void beforeClass() {
		long id = Thread.currentThread().getId();
		APPLICATION_LOGS.info("Before test-class. Thread id is: " + id);
	}

	//@Test
	public void testMethodOne() {
		long id = Thread.currentThread().getId();
		APPLICATION_LOGS.info("Executing test-method-one. Thread id is: " + id);
	}

	//@Test
	public void testMethodTwo() {
		long id = Thread.currentThread().getId();
		APPLICATION_LOGS.info("Executing test-method-two. Thread id is: " + id);
	}

	@AfterClass
	public void afterClass() {
		long id = Thread.currentThread().getId();
		APPLICATION_LOGS.info("After test-method-class. Thread id is: " + id);
	}


}
