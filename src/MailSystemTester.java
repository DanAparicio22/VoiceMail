import java.util.ArrayList;
import java.util.Scanner;

public class MailSystemTester {

	private static final int MAILBOX_COUNT = 20;
	   
	public static void main(String[] args) {
      MailSystem system = new MailSystem(MAILBOX_COUNT);
      Scanner console = new Scanner(System.in);
      CommunicationDevice observerConsole = new Telephone(console);
      Connection c = new Connection(system);
      CommunicationDevice observerConsole2 = new UITelephone(c);
      ArrayList<CommunicationDevice> observers = new ArrayList<>();
      //observers.add(observerConsole);
      observers.add(observerConsole2);
      Connection connection = new Connection(system, observers);
      for (CommunicationDevice observer : observers) {
    	  observer.runConnection(connection);
      }
   }

}
