import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelephoneServiceTest {

	Connection mockedConnection;
	TelephoneService telephoneService;
	
	@Before
	public void init() {
		mockedConnection = mock(Connection.class);
		telephoneService = new TelephoneService(mockedConnection);
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
	
	@Test
	public void shouldVerifyIfProcessInputWhenRecordMessage() {
		telephoneService.processInput("hola");
		verify(mockedConnection).recordMessage("hola");
	}
	
	@Test
	public void shouldVerifyIfProcessInputWhenDial() {
		telephoneService.processInput("1");
		verify(mockedConnection).dial("1");
	}
	
	@Test
	public void shouldVerifyIfProcessInputWhenhangUp() {
		telephoneService.processInput("H");
		verify(mockedConnection).hangUp();
	}
	
	@Test
	public void shouldVerifyIfProcessInputWhenQuitApplication() {
		telephoneService.processInput("Q");
		verify(mockedConnection).quit();
	}

}
