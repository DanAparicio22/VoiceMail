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
		assertEquals(0, queue.size());
	}
	
	@Test
	public void messageQueueTamanyoUno() {
		queue.add(mockedMessage);
		assertEquals(1, queue.size());
	}
	
	@Test
	public void messageQueueTamanyoDos() {
		queue.add(mockedMessage);
		queue.add(mockedMessage);
		assertEquals(2, queue.size());
	}
	
	@Test
	public void Eliminar1MensajeDe2MesajesDeQueueMessagesQuedaTamanyoUno() {
		queue.add(mockedMessage);
		queue.add(mockedMessage);
		assertEquals(2, queue.size());
		queue.remove();
		assertEquals(1,queue.size());
	}
	
	@Test
	public void Eliminar1MensajeDe2MesajesDeQueueMessagesQuedaTamanyoCero() {
		queue.add(mockedMessage);
		queue.add(mockedMessage);
		assertEquals(2, queue.size());
		queue.remove();
		queue.remove();
		assertEquals(0,queue.size());
	}
	
	@Test
	public void RetornaElUltimoMensajeEliminado() {
		queue.add(mockedMessage);
		queue.add(mockedMessage);
		assertEquals(mockedMessage, queue.peek());
		queue.remove();
		assertEquals(mockedMessage,queue.peek());
	}
	
	@Test
	public void metodoPeekRetornaNULL() {
		assertNull(queue.peek());
	}
	
}
