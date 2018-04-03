import java.util.ArrayList;
 
public class MailSystem
{
    
   private static final int REAL_VALUE_TO_MAILBOX = 1;
   private static final int ONE_POSITION_MAILBOXES = 1;
   private static final int INTITAL_MAILBOX_COUNT = 0;
   private static final int MINIMUM_NUMBER_MAILBOX = 1;
   private ArrayList<Mailbox> mailboxes;

   public MailSystem(int numberOfMailBoxes)
   {
      mailboxes = new ArrayList<Mailbox>();
 
      for (int number = INTITAL_MAILBOX_COUNT; number < numberOfMailBoxes; number++)
      {
    	 int newNumberMailBox = (number + REAL_VALUE_TO_MAILBOX);
         String passcode = "" + newNumberMailBox;
         String greeting = "You have reached mailbox " + newNumberMailBox
               + ". \nPlease leave a message now.";
         mailboxes.add(new Mailbox(passcode, greeting));
      }
   }

    
   public Mailbox findMailbox(String extensionNumberOfMailBox)
   {
      int numberOfMailBox = Integer.parseInt(extensionNumberOfMailBox);
      if (isNumberOfMailBoxBetween(MINIMUM_NUMBER_MAILBOX,mailboxes.size(),numberOfMailBox))
         return  mailboxes.get(numberOfMailBox - ONE_POSITION_MAILBOXES);
      else 
    	 return null;
   }

	private boolean isNumberOfMailBoxBetween(int number, int sizeMailBoxes,int numberOfMailBox) {
		return number <= numberOfMailBox && numberOfMailBox <= sizeMailBoxes;
	} 

}
