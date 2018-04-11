import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class ConsoleTelephoneTest {
	
	ConsoleTelephone telephone;
	TelephoneService mockedTelephoneService;
	String data;
	
	@Before
	public void init() {
		mockedTelephoneService = mock(TelephoneService.class);
	}

	@Test
	public void shouldVerifyIfIsHangUp() {
		data = "H" + System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new ConsoleTelephone(new Scanner(System.in), mockedTelephoneService);
		telephone.runConnection();
		verify(mockedTelephoneService).processInput("H");
	}
	
	@Test
	public void shouldVerifyIfIsDial() {
		data = "1" + System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new ConsoleTelephone(new Scanner(System.in), mockedTelephoneService);
		telephone.runConnection();
		verify(mockedTelephoneService).processInput("1");
	}
	
	@Test
	public void shouldVerifyIfIsRecordAWord() {
		data = "ab" + System.getProperty("line.separator") + "Q";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		telephone = new ConsoleTelephone(new Scanner(System.in), mockedTelephoneService);
		telephone.runConnection();
		verify(mockedTelephoneService).processInput("ab");
	}
	
}
