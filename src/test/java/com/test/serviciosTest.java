package com.test;

import org.testng.annotations.Test;

import com.page.events.serviciosPage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class serviciosTest {
	WebDriver driver;
	serviciosPage serviciosTest;

	@BeforeClass
	public void beforeClass() {
		serviciosTest = new serviciosPage(driver);
		driver = serviciosTest.chromeDriverConnection();
		driver.manage().window().maximize();
		serviciosTest.visit("https://testgroup.cl/");
	}

	@Test
	public void PruebaServicios() throws InterruptedException {
		serviciosTest.serviciosP();
		assertEquals("Nuestros Servicios", serviciosTest.serviciosMessage());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
