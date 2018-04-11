import java.util.Scanner;

public class ConsoleTelephone implements Telephone {

   private static final String QUIT_CONNECTION = "Q";
   private Scanner scanner;
   private TelephoneService telephoneService;

   public ConsoleTelephone(Scanner aScanner, TelephoneService telephoneService) {
      scanner = aScanner;
      this.telephoneService = telephoneService;
   }

   public void speak(String output) {
      System.out.println(output);
   } 
   
    public void runConnection() {
      boolean activeConnection = true;
      while (activeConnection) {
         String input = scanner.nextLine();
         if (isQuittingOfConnection(input)) {
        	 activeConnection = false;
         }
         telephoneService.processInput(input);
      }
    }

	@Override
	public void updateMessage(String message) {
		speak(message);
	}
	
	private boolean isQuittingOfConnection(String input) {
		return input.equalsIgnoreCase(QUIT_CONNECTION);
	}

}
