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
	public void shouldVerifyThePasswordAsCorrect() {
		assertTrue(mailBox.checkPasscodeOfMailBox("1"));
	}
	
	@Test
	public void shouldVerifyThePasswordAsIncorrect() {
		assertFalse(mailBox.checkPasscodeOfMailBox("2"));
	}
	
	@Test
	public void shouldChangeOldPasscode(){
		mailBox.changePasscode("11\n#");
		assertFalse(mailBox.checkPasscodeOfMailBox("11"));
	}
	 
	
	@Test
	public void shouldShowGreeting() {
		assertEquals("You have reached mailbox 1. \nPlease leave a message now.",mailBox.getGreeting());
	}
	
	@Test
	public void shouldChangeOldGreeting() {
		mailBox.changeGreeting("No me encuentro por ahora, \ndeja tu mensaje.");
		assertEquals("No me encuentro por ahora, \ndeja tu mensaje.",mailBox.getGreeting());
	}
	
	@Test
	public void shouldNotReturnAMessage() {
		assertEquals(null,mailBox.getCurrentMessage());
	}
	
	@Test
	public void shouldReturnANewMessage() {
		mailBox.addMessageInMailBox(mockedMessage);
		assertEquals(mockedMessage,mailBox.getCurrentMessage());
	}

	@Test
	public void shouldDeleteTheCurrentMessage(){
		mailBox.addMessageInMailBox(mockedMessage);
		mailBox.removeCurrentMessage();
		assertNull(mailBox.getCurrentMessage());
	}
	
	@Test
	public void shouldReturnTheCurrentMessageThatWasSaved() {
		mailBox.addMessageInMailBox(mockedMessage);
		mailBox.saveCurrentMessage();
		assertEquals(mockedMessage,mailBox.getCurrentMessage());
	}
	
	@Test
	public void shouldReturnNullWhenSaveAInvalidMessage() {
		mailBox.saveCurrentMessage();
		assertNull(mailBox.getCurrentMessage());
	}
	
	@Test
	public void shouldReturnTheLastSavedMessageWhenDeleteTheNewMessage() {
		mailBox.addMessageInMailBox(mockedMessage);
		mailBox.saveCurrentMessage();
		mailBox.addMessageInMailBox(mockedMessage);
		mailBox.removeCurrentMessage();
		assertEquals(mockedMessage,mailBox.getCurrentMessage());
	}
	
}
