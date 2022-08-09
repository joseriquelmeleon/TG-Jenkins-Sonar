package com.test;

import org.testng.annotations.Test;


import com.page.events.contactoPage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class contactoTest {
	WebDriver driver;
	contactoPage testContacto;
	
	@BeforeClass
	public void beforeClass() {
		testContacto = new contactoPage(driver);
		driver = testContacto.chromeDriverConnection();
		driver.manage().window().maximize();
		testContacto.visit("https://testgroup.cl/");
	}

	@Test
	public void PruebaContacto() throws InterruptedException {
		testContacto.ContactoPage();
		assertEquals("Contacto", testContacto.nosotrosMessage());
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		driver.quit();
	}

}
