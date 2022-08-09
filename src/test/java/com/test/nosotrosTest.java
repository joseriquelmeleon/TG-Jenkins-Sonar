package com.test;

import org.testng.annotations.Test;

import com.page.events.nosotrosPage;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class nosotrosTest {
	WebDriver driver;
	nosotrosPage testNosotros;
	
	@BeforeClass
	public void beforeClass() {
		testNosotros = new nosotrosPage(driver);
		driver = testNosotros.chromeDriverConnection();
		driver.manage().window().maximize();
		testNosotros.visit("https://testgroup.cl/");
	}

	@Test
	public void PruebaNosotros() throws InterruptedException {
		testNosotros.nosotrosGroup();
		assertEquals("Nosotros", testNosotros.nosotrosMessage());
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		driver.quit();
	}

}
 
