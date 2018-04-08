import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.mock;

public class MessageQueueTest {
	
	MessageQueue queue;
	Message mockedMessage;
	
	@Before
	public void init() {
		queue = new MessageQueue();
		mockedMessage = mock(Message.class);
	}

	@Test
	public void messageQueueTamanyoCero() {
		assertEquals(0, queue.getMessageQueueSize());
	}
	
	@Test
	public void messageQueueTamanyoUno() {
		queue.addMessage(mockedMessage);
		assertEquals(1, queue.getMessageQueueSize());
	}
	
	@Test
	public void messageQueueTamanyoDos() {
		queue.addMessage(mockedMessage);
		queue.addMessage(mockedMessage);
		assertEquals(2, queue.getMessageQueueSize());
	}
	
	@Test
	public void Eliminar1MensajeDe2MesajesDeQueueMessagesQuedaTamanyoUno() {
		queue.addMessage(mockedMessage);
		queue.addMessage(mockedMessage);
		assertEquals(2, queue.getMessageQueueSize());
		queue.removeMessage();
		assertEquals(1,queue.getMessageQueueSize());
	}
	
	@Test
	public void Eliminar1MensajeDe2MesajesDeQueueMessagesQuedaTamanyoCero() {
		queue.addMessage(mockedMessage);
		queue.addMessage(mockedMessage);
		assertEquals(2, queue.getMessageQueueSize());
		queue.removeMessage();
		queue.removeMessage();
		assertEquals(0,queue.getMessageQueueSize());
	}
	
	@Test
	public void RetornaElUltimoMensajeEliminado() {
		queue.addMessage(mockedMessage);
		queue.addMessage(mockedMessage);
		assertEquals(mockedMessage, queue.peekMessageOfMessageQueue());
		queue.removeMessage();
		assertEquals(mockedMessage,queue.peekMessageOfMessageQueue());
	}
	
	@Test
	public void metodoPeekRetornaNULL() {
		assertNull(queue.peekMessageOfMessageQueue());
	}
	
}
