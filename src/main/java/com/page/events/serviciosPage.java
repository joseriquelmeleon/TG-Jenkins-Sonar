package com.page.events;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mail.TLSEmail;
import com.utils.Base;

public class serviciosPage extends Base {
	
	By serviciosbtn = By.id("menu-item-1493");
	By serviciosLocator = By.cssSelector("#post-1424 > div > div > div > div.et_pb_section.et_pb_section_0.et_pb_with_background.et_section_regular > div.et_pb_row.et_pb_row_0 > div > div > div > h1 > strong");
	By messageLocator = By.cssSelector("#post-1424 > div > div > div > div.et_pb_section.et_pb_section_0.et_pb_with_background.et_section_regular > div.et_pb_row.et_pb_row_0 > div > div > div > h1 > strong");

	private static final String ASUNTO_CORREO = "Link de pagina caido - TestGroup.cl ";
	String asuntoAdicional = "";
	
	public serviciosPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void serviciosP() throws InterruptedException {
		
		click(serviciosbtn);
		Thread.sleep(2000);
		
		WebElement mensaje = driver.findElement(serviciosbtn);
		
		if (isDisplayed(serviciosLocator)) {
			System.out.println("*** (2/6) La pagina Servicios esta funcionando correctamente *** ");
			
		}else {
			System.out.println("*** (2/6) Hubo un problema con la pagina Servicios ***");
			String[] sCorreos = { "nelson.colman@testgroup.cl" }; 
			String mensajeCorreo = "<p>*********  Advertencia  *********</p>"
					+ "<p>Se ha detectado la caída del servicio web de Testgroup en el siguiente Link:"
					+ mensaje.getText() + " </b></p>";
			
			asuntoAdicional = "";
			
			TLSEmail.sendEmail(sCorreos, ASUNTO_CORREO + asuntoAdicional, mensajeCorreo);
			System.out.println("Asunto del Correo: " + ASUNTO_CORREO + asuntoAdicional);
		}
	}
	
	public String serviciosMessage() {	
		List<WebElement> span = findElements(messageLocator);
		return getText(span.get(0));
		
	}

}
