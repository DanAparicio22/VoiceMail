import static org.junit.Assert.*;
import org.junit.Test;

public class MessageTest {
	
	Message message;
	
	@Test
	public void shouldReturnTheMessageText() {
		message = new Message("Hola, como estas?");
		assertEquals("Hola, como estas?", message.getMessageText());
	}

}
