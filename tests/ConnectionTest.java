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
	
	@Before
	public void init() {
		mockedMailSystem = mock(MailSystem.class);
		mockedTelephone = mock(Telephone.class);
		connection = new Connection(mockedMailSystem, mockedTelephone);
	}
	
	@Test
    public void shouldSelectAValidMailBox() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      assertTrue(connection.isConnected());
      connection.dial(idMailBox);
      connection.dial("#");
      assertTrue(connection.isRecording());
      verify(mockedTelephone).speak(selectedMailBox.getGreeting());
    }
	
	@Test
    public void shouldSelectAInvalidMailBox() {
      String idMailBox = "20";
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(null);
      connection.dial(idMailBox);
      connection.dial("#");
      assertFalse(connection.isRecording());
    }
	
	@Test
    public void shouldLoginCorrectlyInMailBox() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      assertTrue(connection.isRecording());
      connection.dial(idMailBox);
      connection.dial("#");
      assertTrue(connection.isInMailboxMenu());
      verify(mockedTelephone).speak("Enter 1 to listen to your messages\nEnter 2 to change your passcode\nEnter 3 to change your greeting");
    }
	
	@Test
    public void shouldLoginWronglyInMailBox() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial("2");
      connection.dial("#");
      assertFalse(connection.isInMailboxMenu());
      verify(mockedTelephone).speak("Incorrect passcode. Try again!");
    }
	
	@Test
    public void shouldChangePasscodeOfMailBox() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      assertTrue(connection.isRecording());
      connection.dial(idMailBox);
      connection.dial("#");
      assertTrue(connection.isInMailboxMenu());
      connection.dial("2");
      assertTrue(connection.isChangePasscode());
      assertFalse(connection.isInMailboxMenu());
      connection.dial("passcode");
      connection.dial("#");
      connection.dial("H");
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial("passcode");
      connection.dial("#");
      assertFalse(connection.isChangePasscode());
    }
	
	@Test
    public void shouldChangeGreetingOfMailBox() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      assertTrue(connection.isRecording());
      connection.dial(idMailBox);
      connection.dial("#");
      assertTrue(connection.isInMailboxMenu());
      connection.dial("3");
      assertTrue(connection.isChangeGreeting());
      assertFalse(connection.isInMailboxMenu());
      connection.dial("Saludos, deja tu mensaje");
      connection.dial("#");
      connection.dial("H");
      assertFalse(connection.isChangeGreeting());
    }
	
	@Test
    public void shouldStayInMailBoxMenu() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      assertTrue(connection.isRecording());
      connection.dial(idMailBox);
      connection.dial("#");
      assertTrue(connection.isInMailboxMenu());
      connection.dial("4");
      assertTrue(connection.isInMailboxMenu());
    }
	
	@Test
    public void shouldStayInTextMessageMenu() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      assertTrue(connection.isRecording());
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial("1");
      assertTrue(connection.isInMessageMenu());
      connection.dial("5");
      assertTrue(connection.isInMessageMenu());
    }
	
	@Test
    public void shouldDisconnectOfApplication() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial("Q");
      assertFalse(connection.isConnected());
    }
	
	@Test
    public void shouldShowTextMessageInMailBox() {
      String idMailBox = "1";
      Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial(idMailBox);
      connection.dial("#");
      connection.dial("1");
      assertTrue(connection.isInMessageMenu());
      connection.dial("1");
      verify(mockedTelephone).speak(connection.getStringOfNoMessages() + "Enter 1 to listen to the current message\nEnter 2 to save the current message\n"
    	         + "Enter 3 to delete the current message\nEnter 4 to return to the main menu");
    }
	
	@Test
    public void shouldShowInitialMessage() {
      verify(mockedTelephone).speak("Enter mailbox number followed by #");
    }
	
	@Test
	public void shouldShowLastMessageAfterDeleteMessage() {
		String idMailBox = "1";
		Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
		when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		connection.dial(idMailBox);
		connection.dial("#");
		connection.dial("Hola, manda un mensaje cuando escuches esto.");
		connection.dial("H");
		connection.dial(idMailBox);
		connection.dial("#");
		connection.dial("Hola, recuerda enviarme un mensaje cuando escuches esto.");
		connection.dial("H");
		connection.dial(idMailBox);
		connection.dial("#");
		connection.dial(idMailBox);
		connection.dial("#");
		connection.dial("1");
		assertTrue(connection.isInMessageMenu());
		connection.dial("3");
		assertTrue(connection.isInMessageMenu());
		connection.dial("1");
	}
	
	@Test
	public void shouldShowSavedMessage() {
		String idMailBox = "1";
		Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
		when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		connection.dial(idMailBox);
		connection.dial("#");
		connection.dial("Hola, manda un mensaje cuando escuches esto.");
		connection.dial("H");
		connection.dial(idMailBox);
		connection.dial("#");
		connection.dial(idMailBox);
		connection.dial("#");
		connection.dial("1");
		assertTrue(connection.isInMessageMenu());
		connection.dial("2");
		assertTrue(connection.isInMessageMenu());
		connection.dial("1");
	}
	
	@Test
	public void shouldReturnToMailBoxMenu() {
		String idMailBox = "1";
		Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
		when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		connection.dial(idMailBox);
		connection.dial("#");
		connection.dial(idMailBox);
		connection.dial("#");
		connection.dial("1");
		assertTrue(connection.isInMessageMenu());
		connection.dial("4");
		assertTrue(connection.isInMailboxMenu());
	}
	
	@Test
	public void shouldNotRecordMessage() {
		connection.recordMessage("Hola");
		assertFalse(connection.isRecording());
		assertFalse(connection.isChangeGreeting());
	}
	
	@Test
	public void shouldRecordMessage() {
		String idMailBox = "1";
		Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
		when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		connection.dial(idMailBox);
		connection.dial("#");
		assertTrue(connection.isRecording());
		connection.recordMessage("Hola\n");
		connection.hangUp();
		assertTrue(connection.isConnected());
	}
	
	@Test
	public void shouldRecordGreeting() {
		String idMailBox = "1";
		Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
		when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		connection.dial(idMailBox);
		connection.dial("#");
		connection.dial(idMailBox);
		connection.dial("#");
		connection.dial("3");
		assertTrue(connection.isChangeGreeting());
		connection.recordMessage("Hola\n");
		connection.dial("#");
		assertFalse(connection.isChangeGreeting());
	}
	
	@Test
	public void shouldHangUp() {
		connection.hangUp();
		assertTrue(connection.isConnected());
	}
	
	@Test
	public void shouldShowMessageText() {
		assertEquals("hola\n",connection.showMessageText(new Message("hola")));
	}
	
	@Test
	public void shouldShowAMessageString() {
		assertEquals("hola\n",connection.getMessageStringOfGotMessage("", new Message("hola")));
	}
	
}
