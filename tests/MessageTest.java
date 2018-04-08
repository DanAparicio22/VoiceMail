import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class MessageTest {
	
	Message message;
	
	@Test
	public void estoRetornaElMensaje() {
		message = new Message("Hola, como estas?");
		assertEquals("Hola, como estas?", message.getMessageText());
	}

}
