import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class MailSystemTest {

	MailSystem mailSystem;
	
	@Before
	public void init() {
		mailSystem = new MailSystem(10);
	}
	
	@Test
	public void deberiaDevolverUnMailBoxBuscado() {
		assertNotNull(mailSystem.findMailbox("1"));
	}
	
	@Test
	public void deberiaNoDevolverUnMailBoxBuscado() {
		assertNull(mailSystem.findMailbox("15"));
	}
}
