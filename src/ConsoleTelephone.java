import java.util.Scanner;

public class ConsoleTelephone implements Telephone {

   private static final String HANG_UP = "H";
private static final String QUIT_CONNECTION = "Q";
private static final int ZERO_COINCIDENCES = 0;
   private static final int LENGTH_ONE = 1;
   private static final String VALID_CHARACTERS_FOR_DIAL = "1234567890#";
   private Scanner scanner;

   public ConsoleTelephone(Scanner aScanner) {
      scanner = aScanner;
   }

   public void speak(String output) {
      System.out.println(output);
   } 
   
   public void run(Connection connection) {
      boolean activeConnection = true;
      while (activeConnection) {
         String input = scanner.nextLine();
         if (input.isEmpty()) {
        	 return;
         }
         if (isHangUp(input)) {
            connection.hangUp();
         } else {
        	 if (isQuittingOfConnection(input)) {
        		 activeConnection = false;
        	 } else {
        		 if (isDial(input)) {
        			 connection.dial(input);
        		 } else {
        			 connection.recordMessage(input);
        		 }
        	 }
         }
      }
   }

  
	@Override
	public void update(String message) {
		speak(message);
	}
	

	private boolean isQuittingOfConnection(String input) {
		return input.equalsIgnoreCase(QUIT_CONNECTION);
	}

	private boolean isDial(String input) {
		return input.length() == LENGTH_ONE && getCoincidences(input) >= ZERO_COINCIDENCES;
	}
	
	private int getCoincidences(String input) {
		return VALID_CHARACTERS_FOR_DIAL.indexOf(input);
	}
	
	private boolean isHangUp(String input) {
		return input.equalsIgnoreCase(HANG_UP);
	}

}
