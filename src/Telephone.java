import java.util.Scanner;

public class Telephone implements Observer {

   private static final int ZERO_COINCIDENCES = 0;
   private static final int ONE_VALUE = 1;
   private static final String VALID_CHARACTERS_FOR_DIAL = "1234567890#";
   private Scanner scanner;

   public Telephone(Scanner aScanner) {
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

	private boolean isDial(String input) {
		return input.length() == ONE_VALUE && getCoincidences(input) >= ZERO_COINCIDENCES;
	}
  
	@Override
	public void update(String message) {
		speak(message);
	}
	
	private int getCoincidences(String input) {
		return VALID_CHARACTERS_FOR_DIAL.indexOf(input);
	}

	private boolean isQuittingOfConnection(String input) {
		return input.equalsIgnoreCase("Q");
	}

	private boolean isHangUp(String input) {
		return input.equalsIgnoreCase("H");
	}

}
