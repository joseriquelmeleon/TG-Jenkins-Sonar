package com.test;

import org.testng.annotations.Test;

import com.page.events.capacitacionesPage;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class capacitacionesTest {
	WebDriver driver;
	capacitacionesPage capacitacionesTest;

	@BeforeClass
	public void beforeClass() {
		capacitacionesTest = new capacitacionesPage(driver);
		driver = capacitacionesTest.chromeDriverConnection();
		driver.manage().window().maximize();
		capacitacionesTest.visit("https://testgroup.cl/");
	}

	@Test
	public void PruebaCapacitaciones() throws InterruptedException {
		capacitacionesTest.CapacitacionesPage();
		assertEquals("Capacitaciones", capacitacionesTest.capacitacionesMessage());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
