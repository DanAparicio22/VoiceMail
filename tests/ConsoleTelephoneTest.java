import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class ConsoleTelephoneTest {
	
	Connection mockedConnection;
	ConsoleTelephone telephone;
	String data;
	
	@Before
	public void init() {
		mockedConnection = mock(Connection.class);
	}
	
	@Test
	public void shouldVerifyIfIsHangUp() {
		data = "H" + System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new ConsoleTelephone(new Scanner(System.in));
		telephone.runConnection(mockedConnection);
		verify(mockedConnection).hangUp();
	}
	
	@Test
	public void shouldVerifyIfInputIsNull() {
		data = System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new ConsoleTelephone(new Scanner(System.in));
		telephone.runConnection(mockedConnection);
	}
	
	@Test
	public void shouldVerifyIfIsDial() {
		data = "1" +  System.getProperty("line.separator") + "#" + System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new ConsoleTelephone(new Scanner(System.in));
		telephone.runConnection(mockedConnection);
		verify(mockedConnection).dial("1");
	}
	
	@Test
	public void shouldVerifyIfIsRecordOneCharacter() {
		data = "a" + System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new ConsoleTelephone(new Scanner(System.in));
		telephone.runConnection(mockedConnection);
		verify(mockedConnection).recordMessage("a");
	}
	
	@Test
	public void shouldVerifyIfIsRecordAWord() {
		data = "ab" + System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new ConsoleTelephone(new Scanner(System.in));
		telephone.runConnection(mockedConnection);
		verify(mockedConnection).recordMessage("ab");
	}

}
