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
	public void shouldReturnZeroOfMessageQueueSize() {
		assertEquals(0, queue.getMessageQueueSize());
	}
	
	@Test
	public void shouldReturnTwoOfMessageQueueSize() {
		queue.addMessage(mockedMessage);
		queue.addMessage(mockedMessage);
		assertEquals(2, queue.getMessageQueueSize());
	}
	
	@Test
	public void shouldDeleteOneMessageOfTwoMessagesInMessageQueue() {
		queue.addMessage(mockedMessage);
		queue.addMessage(mockedMessage);
		assertEquals(2, queue.getMessageQueueSize());
		queue.removeMessage();
		assertEquals(1,queue.getMessageQueueSize());
	}
	
	@Test
	public void shouldDeleteOnlyTwoMessagesInMessageQueue() {
		queue.addMessage(mockedMessage);
		queue.addMessage(mockedMessage);
		assertEquals(2, queue.getMessageQueueSize());
		queue.removeMessage();
		queue.removeMessage();
		queue.removeMessage();
		assertEquals(0,queue.getMessageQueueSize());
	}
	
	@Test
	public void ShouldReturnTheLastMessage() {
		queue.addMessage(mockedMessage);
		queue.addMessage(mockedMessage);
		assertEquals(mockedMessage, queue.peekMessageOfMessageQueue());
		queue.removeMessage();
		assertEquals(mockedMessage,queue.peekMessageOfMessageQueue());
	}
	
	@Test
	public void shouldReturnNullIfMessageQueueDoesNotHaveAMessage() {
		assertNull(queue.peekMessageOfMessageQueue());
	}
	
	@Test
	public void shouldReturnTrueIfMessageQueueIsGreaterThanZero() {
		queue.addMessage(mockedMessage);
		assertTrue(queue.isMessageQueueSizeGreaterThan(0));
	}
	
	@Test
	public void shouldReturnFalseIfMessageQueueIsNotGreaterThanZero() {
		assertFalse(queue.isMessageQueueSizeGreaterThan(0));
	}
	
}

