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
	public void shouldReturnAFindedMailBox() {
		assertNotNull(mailSystem.findMailbox("1"));
	}
	
	@Test
	public void shouldNotReturnAFindedMailBox() {
		assertNull(mailSystem.findMailbox("0"));
		assertNull(mailSystem.findMailbox("11"));
	}
}
