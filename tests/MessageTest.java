import static org.junit.Assert.*;
import org.junit.Test;

public class MessageTest {

	@Test
	public void estoRetornaElMensaje() {
		Message message = new Message("Hola como estas");
		assertEquals("Hola como estas", message.getText());
	}

}
