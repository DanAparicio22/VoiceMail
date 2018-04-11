import java.util.Scanner;

public class MailSystemTester {

	private static final int MAILBOX_COUNT = 20;
	   
	public static void main(String[] args) {

      MailSystem system = new MailSystem(MAILBOX_COUNT);      
      Scanner console = new Scanner(System.in);  
      Connection connection = new Connection(system);
      Telephone observerConsole = new ConsoleTelephone(console);
      UserInterfaceTelephoneService telephoneService = new UserInterfaceTelephoneService(connection);
      Telephone observerUI = new UserInterfaceTelephone(telephoneService);
      connection.attachObserver(observerConsole);
      connection.attachObserver(observerUI);
      ((ConsoleTelephone) observerConsole).runConnection(connection);
       
   }

}
