package com.page.events;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mail.TLSEmail;
import com.utils.Base;

public class capacitacionesPage extends Base {

	By btncapacitaciones = By.id("menu-item-1491");
	By capacitacionesLocator = By.cssSelector("#post-1479 > div > div > div > div.et_pb_section.et_pb_section_0.et_section_regular > div > div > div > div > h1 > strong");
	By messageLocator = By.cssSelector("#post-1479 > div > div > div > div.et_pb_section.et_pb_section_1.et_section_specialty > div > div.et_pb_column.et_pb_column_1_2.et_pb_column_1.et_pb_css_mix_blend_mode_passthrough.et_pb_column_single > div.et_pb_module.et_pb_text.et_pb_text_1.et_pb_text_align_justified.et_pb_bg_layout_light > div > h4 > strong");
	
	private static final String ASUNTO_CORREO = "Link de pagina caido - TestGroup.cl ";
	String asuntoAdicional = "";
	
	public capacitacionesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void CapacitacionesPage() throws InterruptedException {
		click(btncapacitaciones);
		Thread.sleep(2000);
		
		WebElement mensaje = driver.findElement(btncapacitaciones);
		
		if (isDisplayed(capacitacionesLocator)) {
			System.out.println("*** (4/6) La pagina Capacitaciones esta funcionando correctamente ***");
			
		}else {
		
			System.out.println("*** (4/6) Hubo un error en la solicitud de la pagina Capacitaciones ***");
			String[] sCorreos = { "nelson.colman@testgroup.cl" }; 
			String mensajeCorreo = "<p>*********  Advertencia  *********</p>"
					+ "<p>Se ha detectado la caída del servicio web de Testgroup en el siguiente Link:"
					+ mensaje.getText() + " </b></p>";
			
			asuntoAdicional = "";
			
			TLSEmail.sendEmail(sCorreos, ASUNTO_CORREO + asuntoAdicional, mensajeCorreo);
			System.out.println("Asunto del Correo: " + ASUNTO_CORREO + asuntoAdicional);
		}
	}
	public String capacitacionesMessage() {	
		List<WebElement> span = findElements(messageLocator);
		return getText(span.get(0));
		
	}
}
