import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;

public class UserInterfaceTelephoneServiceTest {

	Connection mockedConnection;
	UserInterfaceTelephoneService telephoneService;
	
	@Before
	public void init() {
		mockedConnection = mock(Connection.class);
		telephoneService = new UserInterfaceTelephoneService(mockedConnection);
	}
	
	@Test
	public void shouldVerifyIfIsHangUp() {
		telephoneService.hangUp();
		verify(mockedConnection).hangUp();
	}
	
	@Test
	public void shouldVerifyIfIsDial() { 
		telephoneService.dial("1");
		verify(mockedConnection).dial("1");
	}
	
	@Test
	public void shouldVerifyIfIsRecordAMessage() {
		telephoneService.recordMessage("hola");
		verify(mockedConnection).recordMessage("hola");
	}

}
