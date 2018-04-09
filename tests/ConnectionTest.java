import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class ConnectionTest {
	Connection connection;
	MailSystem mockedMailSystem;
	Telephone mockedTelephone;
	Mailbox mockedCurrentMailbox;
	@Before
	public void init() {
		mockedMailSystem = mock(MailSystem.class);
		mockedTelephone = mock(Telephone.class);
		mockedCurrentMailbox = mock(Mailbox.class);
		connection = new Connection(mockedMailSystem);
		connection.attach(mockedTelephone);
	}
	
	@Test
    public void deberiaPoderElegirMailBoxValido() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");

      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");

      assertTrue(connection.isRecording());
      //verify(mockedTelephone).speak(selectedMailBox.getGreeting());
    }
	
	@Test
    public void deberiaPoderNoElegirMailBoxInvalido() {
      String idMailBox = "20";
      
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(null);
      connection.dial(idMailBox);
      connection.dial("#");
      
      assertFalse(connection.isRecording());
    }
	
	@Test
    public void deberiaPoderEntrarAlMailBox() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial(idMailBox);
      connection.dial("#");
      assertTrue(connection.isLogging()); 
    }
	
	@Test
    public void deberiaNoPoderEntrarAlMailBox() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial("2");
      connection.dial("#");
      assertFalse(connection.isLogging()); 
    }
	
	@Test
    public void deberiaPoderCambiarCodigoDeAcceso() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial("2");   

      assertTrue(connection.isChangingPassCode()); 
      connection.dial("#");
    }
	
	@Test
    public void deberiaPoderCambiarSaludo() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial("3"); 

      assertTrue(connection.isChangingGreeting());  
      connection.dial("#");
    }
	
	@Test
    public void deberiaPoderEntrarAlMenuDeMensajes() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial("3"); 
      connection.dial("#");
      connection.dial("1"); 
      connection.dial("#");
      assertTrue(connection.isEnteringOptionOfMessageMenu());  
      
    }
	
	@Test
    public void deberiaEstarEnEstadoConectado() {
        assertTrue(connection.isConnected());
    }
	
	@Test
    public void deberiaMostrarElMesajeInicial() {
		//verify(mockedTelephone).speak("Enter mailbox number followed by #");
    }
	 
}
