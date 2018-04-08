import java.util.ArrayList;
import java.util.Scanner;

/**
   This program tests the mail system. A single phone
   communicates with the program through System.in/System.out.
*/
public class MailSystemTester
{
   public static void main(String[] args)
   {
      MailSystem system = new MailSystem(MAILBOX_COUNT);
      
      Scanner console = new Scanner(System.in);  
    
      Observer observerConsole = new Telephone(console);
      Observer observerUI = new UITelephone();
      
      ArrayList<Observer> observers = new ArrayList<>();
      observers.add(observerConsole);
      observers.add(observerUI);
      
      Connection c = new Connection(system, observers);
      for(Observer observer : observers)
    	  observer.run(c);
   }

   private static final int MAILBOX_COUNT = 20;
}
