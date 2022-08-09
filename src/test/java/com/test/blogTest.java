package com.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.page.events.blogPage;

public class blogTest {
	WebDriver driver;
	blogPage testBlog;
	
	@BeforeClass
	public void beforeClass() {
		testBlog = new blogPage(driver);
		driver = testBlog.chromeDriverConnection();
		driver.manage().window().maximize();
		testBlog.visit("https://testgroup.cl/");
	}

	@Test
	public void PruebaBlog() throws InterruptedException {
		testBlog.BlogPage();
		assertEquals("Blog", testBlog.blogMessage());
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		driver.quit();
	}
}
