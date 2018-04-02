import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

public class MailboxTest { 
    String greeting = "You have reached mailbox 1. \nPlease leave a message now.";
    String passcode = "1";
    Mailbox mailBox;
    Message mockedMessage;
    
    @Before
	public void init() { 
    	mailBox = new Mailbox(passcode, greeting);
    	mockedMessage = mock(Message.class);
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
		mailBox.addMessage(mockedMessage);
		assertEquals(mockedMessage,mailBox.getCurrentMessage());
	}

	@Test
	public void deberiaBorrarElMensajeCorriente(){
		mailBox.addMessage(mockedMessage);
		mailBox.removeCurrentMessage();
		assertEquals(null,mailBox.getCurrentMessage());
	}
	
	@Test
	public void deberiaDevolverElMensajeCorrienteQueSeGuardo(){
		mailBox.addMessage(mockedMessage);
		mailBox.saveCurrentMessage();
		assertEquals(mockedMessage,mailBox.getCurrentMessage());
	}
	
	@Test
	public void deberiaDevolverElAnteriorMensajeGuardadoAlBorrarElNuevo(){
		mailBox.addMessage(mockedMessage);
		mailBox.saveCurrentMessage();
		mailBox.addMessage(mockedMessage);
		mailBox.removeCurrentMessage();
		assertEquals(mockedMessage,mailBox.getCurrentMessage());
	}
	 
	
}
