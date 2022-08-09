package com.page.events;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mail.TLSEmail;
import com.utils.Base;

public class casosExitoPage extends Base {
	
	By casosbtn = By.id("menu-item-1492");
	By estrategiaLocator = By.cssSelector("#post-1468 > div > div > div > div.et_pb_section.et_pb_section_0.et_pb_with_background.et_section_regular > div.et_pb_row.et_pb_row_0 > div > div > div > h1 > strong");
	By messageLocator = By.cssSelector("#post-1468 > div > div > div > div.et_pb_section.et_pb_section_0.et_pb_with_background.et_section_regular > div.et_pb_row.et_pb_row_1 > div > div > div > div.et_pb_tab.et_pb_tab_0.clearfix.et_pb_active_content.et-pb-active-slide > div > table > tbody > tr:nth-child(1) > td:nth-child(1) > strong");
	
	private static final String ASUNTO_CORREO = "Link de pagina caido - TestGroup.cl ";
	String asuntoAdicional = "";
	
	public casosExitoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void casosPage() throws InterruptedException {
		click(casosbtn);
		Thread.sleep(2000);
		
		WebElement mensaje = driver.findElement(casosbtn);
		
		if (isDisplayed(estrategiaLocator)) {
			System.out.println("*** (3/6) La pagina Casos de Exito esta funcionando correctamente ***");
			
		}else {
			
			System.out.println("*** (3/6) Hubo un problema con la pagina Casos de Exito ***");
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
