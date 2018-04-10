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
	String idMailBox= "1";

	private void inputConfirm(String input) {
		  connection.dial(input);
		  connection.dial("#");
	}
 

	private Mailbox createNewMailbox() {
		  Mailbox selectedMailBox = new Mailbox(idMailBox, "Hola, como estas?");
		  return selectedMailBox;
	}
	

	private void changesPassCodeMailbox(String newPassCode) { 
		  inputConfirm(newPassCode); 
	} 
	
	private void giveInputOption(String option) { 
	      connection.dial(option); 
	}
	
	@Before
	public void init() {
		  mockedMailSystem = mock(MailSystem.class);
		  mockedTelephone = mock(ConsoleTelephone.class);
		  connection = new Connection(mockedMailSystem);
		  connection.attach(mockedTelephone);
	}
	
	@Test
    public void shouldSelectAValidMailBox() {
		  Mailbox selectedMailBox = createNewMailbox();
		  when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		  assertTrue(connection.isConnected());
		  inputConfirm(idMailBox);
		  assertTrue(connection.isRecording());
		  verify(mockedTelephone).update(selectedMailBox.getGreeting());
    }
	
	@Test
    public void shouldSelectAInvalidMailBox() {
	      idMailBox = "20";
	      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(null);
	      inputConfirm(idMailBox);
	      assertFalse(connection.isRecording());
    }
	
	@Test
    public void shouldLoginCorrectlyInMailBox() {
      
		  Mailbox selectedMailBox = createNewMailbox(); 
		  when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		  assertTrue(connection.isConnected());
		  inputConfirm(idMailBox); 
		  assertTrue(connection.isRecording());
	      inputConfirm(idMailBox); 
		  assertTrue(connection.isInMailboxMenu());
	      verify(mockedTelephone).update("Enter 1 to listen to your messages\nEnter 2 to change your passcode\nEnter 3 to change your greeting");
    }
	
	@Test
    public void shouldLoginWronglyInMailBox() {
		  Mailbox selectedMailBox = createNewMailbox();
		  when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		  assertTrue(connection.isConnected()); 
		  inputConfirm(idMailBox); 
		  assertTrue(connection.isRecording());
		  inputConfirm("2"); 
		  assertFalse(connection.isInMailboxMenu());
		  verify(mockedTelephone).update("Incorrect passcode. Try again!");
    }
	
	@Test
    public void shouldChangePasscodeOfMailBox() {
		  Mailbox selectedMailBox = createNewMailbox();
		  when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		  assertTrue(connection.isConnected());
		  inputConfirm(idMailBox); 
		  assertTrue(connection.isRecording());
		  inputConfirm(idMailBox);
		  assertTrue(connection.isInMailboxMenu());
		  giveInputOption("2");  
	      assertTrue(connection.isChangePasscode());
	      changesPassCodeMailbox("passcode");
	      giveInputOption("h");
	      assertTrue(connection.isInMailboxMenu());
	      inputConfirm(idMailBox);
	      inputConfirm("passcode");   
	      assertTrue(!connection.isChangePasscode());
    }

	@Test
    public void shouldChangeGreetingOfMailBox() {
		  Mailbox selectedMailBox = createNewMailbox();
		  when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		  assertTrue(connection.isConnected());
		  inputConfirm(idMailBox);
		  assertTrue(connection.isRecording());   
		  inputConfirm(idMailBox); 
		  giveInputOption("3");
	      assertTrue(connection.isChangeGreeting());
	      inputConfirm("Saludos, deja tu mensaje"); 
	      giveInputOption("h");
	      assertTrue(connection.isInMailboxMenu());
    }

	
	
	@Test
    public void shouldStayInMailBoxMenu() {
		  Mailbox selectedMailBox = createNewMailbox();
		  when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		  assertTrue(connection.isConnected());
	      inputConfirm(idMailBox);
	      assertTrue(connection.isRecording());
	      inputConfirm(idMailBox); 
	      giveInputOption("4");
	      assertTrue(connection.isInMailboxMenu());
    }
	
	@Test
    public void shouldStayInTextMessageMenu() { 
	      Mailbox selectedMailBox = createNewMailbox();
	      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
	      inputConfirm(idMailBox); 
	      assertTrue(connection.isRecording());
	      inputConfirm(idMailBox); 
	      giveInputOption("1");
	      assertTrue(connection.isInMessageMenu());
	      giveInputOption("5");
	      assertTrue(connection.isInMessageMenu());
    }
	
	@Test
    public void shouldDisconnectOfApplication() {
      
	      Mailbox selectedMailBox = createNewMailbox();
	      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
	      inputConfirm(idMailBox); 
	      giveInputOption("Q");
	      assertFalse(connection.isConnected());
    }
	
	@Test
    public void shouldShowNoTextMessageInMailBox() {
      
	      Mailbox selectedMailBox = createNewMailbox();
	      when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
	      inputConfirm(idMailBox); 
	      inputConfirm(idMailBox); 
	      giveInputOption("1");
	      assertTrue(connection.isInMessageMenu());
	      giveInputOption("1");
	      (verify(mockedTelephone)).update(connection.getStringOfNoMessages() + "Enter 1 to listen to the current message\nEnter 2 to save the current message\n"
    	         + "Enter 3 to delete the current message\nEnter 4 to return to the main menu");
    }
	
	@Test
    public void shouldShowInitialMessage() {
		  verify(mockedTelephone).update("Enter mailbox number followed by #");
    }
	
	@Test
	public void shouldNotDeleteLastSaveMessageAfterDeleteCurrentMessage() {
		
		Mailbox selectedMailBox = createNewMailbox();
		when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox); 
		inputConfirm(idMailBox); 
	    giveInputOption("Hola, manda un mensaje cuando escuches esto.");
		giveInputOption("h"); 
		inputConfirm(idMailBox);
		inputConfirm(idMailBox); 
 		giveInputOption("1");  
		assertTrue(connection.isInMessageMenu());
		giveInputOption("1"); 
		 giveInputOption("2"); 
		giveInputOption("h");  
		inputConfirm(idMailBox);
		giveInputOption("Hola, recuerda enviarme un mensaje cuando escuches esto.");
		giveInputOption("h");
		inputConfirm(idMailBox); 
		inputConfirm(idMailBox); 
		giveInputOption("1");
		assertTrue(connection.isInMessageMenu());
		giveInputOption("1"); 
		giveInputOption("3");
		assertTrue(connection.isInMessageMenu());
		giveInputOption("1");  
	}
	
	@Test
	public void shouldSavedMessage() {
		
		Mailbox selectedMailBox = createNewMailbox();
		when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		inputConfirm(idMailBox); 
		giveInputOption("Hola, manda un mensaje cuando escuches esto.");
		giveInputOption("h");
		inputConfirm(idMailBox); 
		inputConfirm(idMailBox); 
		giveInputOption("1");
		assertTrue(connection.isInMessageMenu());
		giveInputOption("2");
		assertTrue(connection.isInMessageMenu());
		giveInputOption("1");
	}
	
	@Test
	public void shouldReturnToMailBoxMenu() {
		
		Mailbox selectedMailBox = createNewMailbox();
		when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		inputConfirm(idMailBox); 
		inputConfirm(idMailBox); 
		giveInputOption("1");
		assertTrue(connection.isInMessageMenu());
		giveInputOption("4");
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
		
		Mailbox selectedMailBox = createNewMailbox();
		when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		inputConfirm(idMailBox); 
		assertTrue(connection.isRecording());
		connection.recordMessage("Hola\n");
		connection.hangUp();
		assertTrue(connection.isConnected());
	}
	
	@Test
	public void shouldRecordGreeting() {
		
		Mailbox selectedMailBox = createNewMailbox();
		when(mockedMailSystem.findMailbox(idMailBox)).thenReturn(selectedMailBox);
		inputConfirm(idMailBox); 
		inputConfirm(idMailBox); 
		giveInputOption("3");
		assertTrue(connection.isChangeGreeting());
		connection.recordMessage("Hola\n");
		giveInputOption("#");
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
