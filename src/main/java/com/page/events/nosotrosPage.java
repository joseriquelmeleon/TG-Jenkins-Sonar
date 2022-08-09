package com.page.events;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.Base;

import com.mail.TLSEmail;

public class nosotrosPage extends Base{
	
	By nosotrosbtn = By.cssSelector("ul[id='menu-menu-tg']>li[id='menu-item-1494']>a[href='https://testgroup.cl/nosotros/']");
	By nosotros2Locator = By.cssSelector("div[class='et_pb_text_inner']>h1[style='text-align: center;']>strong");
	By messageLocator = By.cssSelector("#post-1195 > div > div > div > div.et_pb_section.et_pb_section_0.et_section_regular > div > div > div > div > h1 > strong");

	private static final String ASUNTO_CORREO = "Link de pagina caido - TestGroup.cl ";
	String asuntoAdicional = "";
	
	public nosotrosPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void nosotrosGroup() throws InterruptedException {
		click(nosotrosbtn);
		Thread.sleep(2000);
	
		WebElement mensaje = driver.findElement(nosotrosbtn);
		
		if (isDisplayed(nosotros2Locator)) {	
			System.out.println("*** (1/6) La pagina nosotros esta funcionando correctamente ***");
			
		}else {
			System.out.println("*** (1/6) Hubo un problema con la pagina Nosotros ***");
			String[] sCorreos = { "nelson.colman@testgroup.cl" }; 
			String mensajeCorreo = "<p>*********  Advertencia  *********</p>"
					+ "<p>Se ha detectado la caída del servicio web de Testgroup en el siguiente Link:"
					+ mensaje.getText() + " </b></p>";
			
			asuntoAdicional = "";
			
			TLSEmail.sendEmail(sCorreos, ASUNTO_CORREO + asuntoAdicional, mensajeCorreo);
			System.out.println("Asunto del Correo: " + ASUNTO_CORREO + asuntoAdicional);
		}
		
	}
	
	public String nosotrosMessage() {	
		List<WebElement> span = findElements(messageLocator);
		return getText(span.get(0));
		
	}

}
