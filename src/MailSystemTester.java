import java.util.Scanner;

public class MailSystemTester {

	private static final int MAILBOX_COUNT = 20;
	   
	public static void main(String[] args) {
      MailSystem system = new MailSystem(MAILBOX_COUNT);
      
      Scanner console = new Scanner(System.in);  

      Connection c = new Connection(system);
      
      Observer observerConsole = new Telephone(console);
      Observer observerUI = new UITelephone(c);
     
      c.attach(observerConsole);
      c.attach(observerUI);
       
      ((Telephone) observerConsole).run(c);
       
   }

}
