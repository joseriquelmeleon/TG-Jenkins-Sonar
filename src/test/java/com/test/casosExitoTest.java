package com.test;

import org.testng.annotations.Test;

import com.page.events.casosExitoPage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class casosExitoTest {
	WebDriver driver;
	casosExitoPage testCasos;
	
	@BeforeClass
	public void beforeClass() {
		testCasos = new casosExitoPage(driver);
		driver = testCasos.chromeDriverConnection();
		driver.manage().window().maximize();
		testCasos.visit("https://testgroup.cl/");
	}

	@Test
	public void PruebaCasos() throws InterruptedException {
		testCasos.casosPage();
		assertEquals("Cliente", testCasos.nosotrosMessage());
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		driver.quit();
	}
}
