import java.util.ArrayList;
 
public class MailSystem {
    
	private static final int REAL_VALUE_TO_MAILBOX = 1;
    private static final int ONE_POSITION_MAILBOXES = 1;
    private static final int INITIAL_MAILBOX_COUNT = 0;
    private static final int MINIMUM_NUMBER_MAILBOX = 1;
    private ArrayList<Mailbox> mailboxes;

    public MailSystem(int numberOfMailBoxes) {
	   mailboxes = new ArrayList<Mailbox>();
	   for (int number = INITIAL_MAILBOX_COUNT; number < numberOfMailBoxes; number++) {
		   int numberOfMailBox = getNumberForMailBox(number);
		   String passcode = getPasswordStringForMailBox(numberOfMailBox);
		   String greeting = getGreetingStringForMailBox(numberOfMailBox);
		   mailboxes.add(new Mailbox(passcode, greeting));
	   }
    }
    
    public Mailbox findMailbox(String stringNumberOfMailBox) {
    	Mailbox findedMailbox = null;
    	int numberOfMailBox = Integer.parseInt(stringNumberOfMailBox);
    	if (isValidNumberOfMailBox(numberOfMailBox)) {
    		findedMailbox = mailboxes.get(numberOfMailBox - ONE_POSITION_MAILBOXES);
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

	private String getPasswordStringForMailBox(int numberOfMailBox) {
		return Integer.toString(numberOfMailBox);
	}

}
