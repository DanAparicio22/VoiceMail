import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MailboxTest { 
    String greeting = "You have reached mailbox 1. \nPlease leave a message now.";
    String passcode = "1";
    Mailbox mailBox;
    
    @Before
	public void init() { 
    	mailBox = new Mailbox(passcode, greeting);
	}
    
	@Test
	public void deberiaVerificarElPassCodeComoCorrecto() {
		assertTrue(mailBox.checkPasscode("1"));
	}
	
	@Test
	public void deberiaVerificarElPassCodeComoIncorrecto() {
		assertFalse(mailBox.checkPasscode("2"));
	}
	
	@Test
	public void deberiaCambiarPassCodeAsignadoAlPrincipio(){
		mailBox.setPasscode("11\n#");
		assertFalse(mailBox.checkPasscode("11"));
	}
	 
	
	@Test
	public void deberiaMostrarGreetingAsignadoAlPrincipio() {
		assertEquals("You have reached mailbox 1. \nPlease leave a message now.",mailBox.getGreeting());
	}
	
	@Test
	public void deberiaCambiarElGreetingAsignadoAlPrincipio() {
		mailBox.setGreeting("No me encuentro por ahora, \ndeja tu mensaje.");
		assertEquals("No me encuentro por ahora, \ndeja tu mensaje.",mailBox.getGreeting());
	}
	
	@Test
	public void deberiaNoDevolverNingunMensajeAñadido(){
		assertEquals(null,mailBox.getCurrentMessage());
	}
	
	@Test
	public void deberiaDevolverUnNuevoMensajeAñadido(){
		Message newMessage = new Message("Habla Carlos, devuelveme la llamada.");
		mailBox.addMessage(newMessage);
		assertEquals(newMessage,mailBox.getCurrentMessage());
	}

	@Test
	public void deberiaBorrarElMensajeCorriente(){
		Message newMessage = new Message("Habla Carlos, devuelveme la llamada.");
		mailBox.addMessage(newMessage);
		mailBox.removeCurrentMessage();
		assertEquals(null,mailBox.getCurrentMessage());
	}
	
	@Test
	public void deberiaDevolverElMensajeCorrienteQueSeGuardo(){
		Message newMessage = new Message("Habla Carlos, devuelveme la llamada.");
		mailBox.addMessage(newMessage);
		mailBox.saveCurrentMessage();
		assertEquals(newMessage,mailBox.getCurrentMessage());
	}
	
	@Test
	public void deberiaDevolverElAnteriorMensajeGuardadoAlBorrarElNuevo(){
		Message firstMessage = new Message("Habla Carlos, devuelveme la llamada.");
		Message secondMessage = new Message("Donde estas?, te llame hace una hora!!!");
		mailBox.addMessage(firstMessage);
		mailBox.saveCurrentMessage();
		mailBox.addMessage(secondMessage);
		mailBox.removeCurrentMessage();
		assertEquals(firstMessage,mailBox.getCurrentMessage());
	}
	 
	
}
