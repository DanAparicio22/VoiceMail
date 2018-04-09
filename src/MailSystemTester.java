import java.util.ArrayList;
import java.util.Scanner;

public class MailSystemTester {

	private static final int MAILBOX_COUNT = 20;
	   
	public static void main(String[] args) {
      MailSystem system = new MailSystem(MAILBOX_COUNT);
      Scanner console = new Scanner(System.in);
      CommunicationDevice observerConsole1 = new Telephone(console);
      CommunicationDevice observerConsole2 = new Telephone(console);
      ArrayList<CommunicationDevice> observers = new ArrayList<>();
      observers.add(observerConsole1);
      observers.add(observerConsole2);
      Connection connection = new Connection(system, observers);
      for (CommunicationDevice observer : observers) {
    	  observer.runConnection(connection);
      }
   }

}
