import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class TelephoneTest {
	
	Connection mockedConnection;
	Telephone telephone;
	
	@Before
	public void init() {
		mockedConnection = mock(Connection.class);
	}
	
	@Test
	public void shouldVerifyIfIsHangUp() {
		String data = "H" + System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new Telephone(new Scanner(System.in));
		telephone.runConnection(mockedConnection);
		verify(mockedConnection).hangUp();
	}
	
	@Test
	public void shouldVerifyIfInputIsNull() {
		String data = System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new Telephone(new Scanner(System.in));
		telephone.runConnection(mockedConnection);
	}
	
	@Test
	public void shouldVerifyIfIsDial() {
		String data = "1" +  System.getProperty("line.separator") + "#" + System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new Telephone(new Scanner(System.in));
		telephone.runConnection(mockedConnection);
		verify(mockedConnection).dial("1");
	}
	
	@Test
	public void shouldVerifyIfIsRecordOneCharacter() {
		String data = "a" + System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new Telephone(new Scanner(System.in));
		telephone.runConnection(mockedConnection);
		verify(mockedConnection).recordMessage("a");
	}
	
	@Test
	public void shouldVerifyIfIsRecordAWord() {
		String data = "ab" + System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new Telephone(new Scanner(System.in));
		telephone.runConnection(mockedConnection);
		verify(mockedConnection).recordMessage("ab");
	}

}
