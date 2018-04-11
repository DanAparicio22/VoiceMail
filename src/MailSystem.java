import java.util.ArrayList;
 
public class MailSystem {
    
	private static final int REAL_VALUE_TO_MAILBOX = 1;
    private static final int ONE_POSITION_MAILBOXES = 1;
    private static final int INITIAL_MAILBOX_COUNT = 0;
    private static final int MINIMUM_NUMBER_MAILBOX = 1;
    private ArrayList<Mailbox> mailboxes;

    public MailSystem(int numberOfMailBoxes) {
	   mailboxes = new ArrayList<Mailbox>();
	   String passcode, greeting;
	   int numberOfMailBox;
	   for (int number = INITIAL_MAILBOX_COUNT; number < numberOfMailBoxes; number++) {
		   numberOfMailBox = getNumberForMailBox(number);
		   passcode = covertNumberForPasswordOfMailBox(numberOfMailBox);
		   greeting = getGreetingStringForMailBox(numberOfMailBox);
		   mailboxes.add(new Mailbox(passcode, greeting));
	   }
    }
    
    public Mailbox findMailbox(String stringNumberOfMailBox) {
    	Mailbox findedMailbox = null;
    	int numberOfMailBox = convertStringToNumberForMailBox(stringNumberOfMailBox);
    	if (isValidNumberOfMailBox(numberOfMailBox)) {
    		findedMailbox = getMailBox(numberOfMailBox);
    	}
    	return findedMailbox;
    }

    private boolean isValidNumberOfMailBox(int numberOfMailBox) {
    	return MINIMUM_NUMBER_MAILBOX <= numberOfMailBox && numberOfMailBox <= mailboxes.size();
    }

	private int getNumberForMailBox(int number) {
		return number + REAL_VALUE_TO_MAILBOX;
	}

	private String getGreetingStringForMailBox(int numberOfMailBox) {
		return "You have reached mailbox " + numberOfMailBox + ". \nPlease leave a message now.";
	}

	private String covertNumberForPasswordOfMailBox(int numberOfMailBox) {
		return Integer.toString(numberOfMailBox);
	}
	
	private Mailbox getMailBox(int numberOfMailBox) {
		return mailboxes.get(numberOfMailBox - ONE_POSITION_MAILBOXES);
	}

	private int convertStringToNumberForMailBox(String stringNumberOfMailBox) {
		return Integer.parseInt(stringNumberOfMailBox);
	}

}
