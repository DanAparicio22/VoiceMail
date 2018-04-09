import java.util.Scanner;

public class MailSystemTester {

	private static final int MAILBOX_COUNT = 20;
	   
	public static void main(String[] args) {
      MailSystem system = new MailSystem(MAILBOX_COUNT);
      Scanner console = new Scanner(System.in);
      Telephone phone = new Telephone(console);
      Connection connection = new Connection(system, phone);
      phone.run(connection);
   }

}
