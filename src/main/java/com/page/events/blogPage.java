package com.page.events;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mail.TLSEmail;
import com.utils.Base;

public class blogPage extends Base {
	
	By btncontacto = By.id("menu-item-1747");
	By blogLocator = By.cssSelector("#post-1749 > div > div > div > div.et_pb_section.et_pb_section_0.et_pb_with_background.et_section_regular.section_has_divider.et_pb_bottom_divider > div.et_pb_row.et_pb_row_0 > div > div > div > h1");
	
	private static final String ASUNTO_CORREO = "Link de pagina caido - TestGroup.cl ";
	String asuntoAdicional = "";
	
	public blogPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void BlogPage() throws InterruptedException {
		click(btncontacto);
		Thread.sleep(2000);
		
		WebElement mensaje = driver.findElement(btncontacto);
		
		if (isDisplayed(blogLocator)) {
			System.out.println("*** (6/6) La pagina Contacto esta funcionando correctamente ***");
			
		}else {
			System.out.println("*** (6/6) Hubo un error en la solicitud de la pagina Capacitaciones ***");
			
			String[] sCorreos = { "nelson.colman@testgroup.cl" }; 
			String mensajeCorreo = "<p>*********  Advertencia  *********</p>"
					+ "<p>Se ha detectado la caída del servicio web de Testgroup en el siguiente Link:"
					+ mensaje.getText() + " </b></p>";
			
			asuntoAdicional = "";
			
			TLSEmail.sendEmail(sCorreos, ASUNTO_CORREO + asuntoAdicional, mensajeCorreo);
			System.out.println("Asunto del Correo: " + ASUNTO_CORREO + asuntoAdicional);
			
		}
	}
	public String blogMessage() {	
		List<WebElement> span = findElements(blogLocator);
		return getText(span.get(0));
		
	}

}
