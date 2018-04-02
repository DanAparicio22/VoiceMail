import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;

public class TelephoneTest {
	Telephone mockedTelephone;
	Connection mockedConnection;
	
	@Before
	public void init() {
		mockedTelephone = mock(Telephone.class);
		mockedConnection = mock(Connection.class);
	}
	
	@Test
	public void deberiaVerificarElTextoHablado() {
		mockedTelephone.speak("Hola, como estas?");
		verify(mockedTelephone).speak("Hola, como estas?");
	}
	
	@Test
	public void deberiaVerificarSiEstaContestando() {
		mockedConnection.hangup();
		verify(mockedConnection).hangup();
	}
	
	@Test
	public void deberiaVerificarSiEstaGrabando() {
		mockedConnection.record("Hola");
		verify(mockedConnection).record("Hola");
	}
	
	@Test
	public void deberiaVerificarSiEstaMarcando() {
		mockedConnection.dial("1");
		verify(mockedConnection).dial("1");
	}

}
