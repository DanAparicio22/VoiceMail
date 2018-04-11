import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;

public class UserInterfaceTelephoneTest {

	Connection mockedConnection;
	UserInterfaceTelephone userInterfaceTelephone;
	
	@Before
	public void init() {
		mockedConnection = mock(Connection.class);
		mockedConnection.attachObserver(userInterfaceTelephone);
	}
	
	@Test
	public void shouldVerifyIfIsHangUp() { 
		userInterfaceTelephone = new UserInterfaceTelephone(mockedConnection); 
		userInterfaceTelephone.processInput(mockedConnection, "h");
		verify(mockedConnection).hangUp();
	}
	
	@Test
	public void shouldVerifyIfIsDial() { 
		userInterfaceTelephone = new UserInterfaceTelephone(mockedConnection);
		userInterfaceTelephone.processInput(mockedConnection, "1");
		verify(mockedConnection).dial("1");
	}
	
	@Test
	public void shouldVerifyIfIsRecordAMessage() { 
		userInterfaceTelephone = new UserInterfaceTelephone(mockedConnection);
		userInterfaceTelephone.processInput(mockedConnection, "1");
		userInterfaceTelephone.setMessageInput("hola");
		userInterfaceTelephone.processInput(mockedConnection, "h");
		verify(mockedConnection).recordMessage("hola");
	}

}
