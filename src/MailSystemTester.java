import java.util.Scanner;

public class MailSystemTester {

	private static final int MAILBOX_COUNT = 20;
	   
	public static void main(String[] args) {

      MailSystem system = new MailSystem(MAILBOX_COUNT);      
      Scanner console = new Scanner(System.in);  
      Connection connection = new Connection(system);
      TelephoneService telephoneService = new TelephoneService(connection);
      Telephone observerConsole = new ConsoleTelephone(console, telephoneService);
      Telephone observerUI = new UserInterfaceTelephone(telephoneService);
      connection.attachObserver(observerConsole);
      connection.attachObserver(observerUI);
      connection.runApplications();
   }

}
