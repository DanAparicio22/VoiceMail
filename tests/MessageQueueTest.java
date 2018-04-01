import static org.junit.Assert.*;
import org.junit.Test;

public class MessageQueueTest {

	@Test
	public void messageQueueTamanyoCero() {
		MessageQueue queue = new MessageQueue();
		assertEquals(0, queue.size());
	}
	
	@Test
	public void messageQueueTamanyoUno() {
		MessageQueue queue = new MessageQueue();
		queue.add(new Message("hola"));
		assertEquals(1, queue.size());
	}
	
	@Test
	public void messageQueueTamanyoDos() {
		MessageQueue queue = new MessageQueue();
		queue.add(new Message("hola"));
		queue.add(new Message("hola"));
		assertEquals(2, queue.size());
	}
	
	@Test
	public void Eliminar1MensajeDe2MesajesDeQueueMessagesQuedaTamanyoUno() {
		MessageQueue queue = new MessageQueue();
		queue.add(new Message("hola soy luis"));
		queue.add(new Message("hay clases hoy?"));
		assertEquals(2, queue.size());
		queue.remove();
		assertEquals(1,queue.size());
	}
	
	@Test
	public void Eliminar1MensajeDe2MesajesDeQueueMessagesQuedaTamanyoCero() {
		MessageQueue queue = new MessageQueue();
		queue.add(new Message("hola soy luis"));
		queue.add(new Message("hay clases hoy?"));
		assertEquals(2, queue.size());
		queue.remove();
		queue.remove();
		assertEquals(0,queue.size());
	}
	
	@Test
	public void RetornaElUltimoMensajeEliminado() {
		MessageQueue queue = new MessageQueue();
		Message message1= new Message("hola soy luis");
		queue.add(message1);
		Message message2 = new Message("hay class hoy?");
		queue.add(message2);
		assertEquals(message1, queue.peek());
		queue.remove();
		assertEquals(message2,queue.peek());
	}
	
	@Test
	public void metodoPeekRetornaNULL() {
		MessageQueue queue = new MessageQueue();
		assertNull(queue.peek());
	}
	
}
