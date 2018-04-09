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

      Connection c = new Connection(system);
      
      Observer observerConsole = new Telephone(console);
      Observer observerUI = new UITelephone(c);
     
      c.attach(observerConsole);
      c.attach(observerUI);
       
      ((Telephone) observerConsole).run(c);
       
   }

   private static final int MAILBOX_COUNT = 20;
}
