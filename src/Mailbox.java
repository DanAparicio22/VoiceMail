
public class Mailbox
{
   
   private static final int INITIAL_MESSAGE_QUEUE_SIZE = 0;
   private MessageQueue newMessages;
   private MessageQueue keptMessages;
   private String greeting;
   private String passcode;

   public Mailbox(String aPasscode, String aGreeting)
   {
      passcode = aPasscode;
      greeting = aGreeting;
      newMessages = new MessageQueue();
      keptMessages = new MessageQueue();
   }


   public boolean checkPasscode(String aPasscode)
   {
      return aPasscode.equals(passcode);
   }


   public void addMessage(Message aMessage)
   {
      newMessages.add(aMessage);
   }

   public Message getCurrentMessage()
   {
      if (newMessages.isMessageQueueGreaterThan(INITIAL_MESSAGE_QUEUE_SIZE))
         return newMessages.peek();
      else if (keptMessages.isMessageQueueGreaterThan(INITIAL_MESSAGE_QUEUE_SIZE))
         return keptMessages.peek();
      else
         return null;
   }


   public Message removeCurrentMessage()
   {
      if (newMessages.isMessageQueueGreaterThan(INITIAL_MESSAGE_QUEUE_SIZE))
         return newMessages.remove();
      else if (keptMessages.isMessageQueueGreaterThan(INITIAL_MESSAGE_QUEUE_SIZE))
         return keptMessages.remove();
      else
         return null;
   }

   public void saveCurrentMessage()
   {
      Message message = removeCurrentMessage();
      if (isMessage(message))
         keptMessages.add(message);
   }


	private boolean isMessage(Message message) {
		return message != null;
	}

   public void setGreeting(String newGreeting)
   {
      greeting = newGreeting;
   }

   public void setPasscode(String newPasscode)
   {
      passcode = newPasscode;
   }

   public String getGreeting()
   {
	   return greeting;
   }

}
