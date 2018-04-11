
public class Mailbox {
   
   private static final int INITIAL_MESSAGE_QUEUE_SIZE = 0;
   private MessageQueue newMessages;
   private MessageQueue keptMessages;
   private String greeting;
   private String passcode;

   public Mailbox(String passcode, String greeting) {
      this.passcode = passcode;
      this.greeting = greeting;
      newMessages = new MessageQueue();
      keptMessages = new MessageQueue();
   }


   public boolean checkPasscodeOfMailBox(String introducedPasscode) {
      return introducedPasscode.equals(passcode);
   }


   public void addMessageInMailBox(Message newMessage) {
      newMessages.addMessage(newMessage);
   }

   public Message getCurrentMessage() {
	  Message currentMessage = null;
      if (haveSomeMessage(newMessages)) {
         currentMessage = peekMessageOf(newMessages);
      } else {
    	  if (haveSomeMessage(keptMessages)) {
    		  currentMessage = peekMessageOf(keptMessages);
    	  }
      }
      return currentMessage;
   }

   public Message removeCurrentMessage() {
	  Message currentMessage = null;
      if (haveSomeMessage(newMessages)) {
    	  currentMessage = removeMessageOf(newMessages);
      } else {
    	  if (haveSomeMessage(keptMessages)) {
    		  currentMessage = removeMessageOf(keptMessages);
    	  }
      }
      return currentMessage;
   }
   
   private Message removeMessageOf(MessageQueue messageQueue) {
	   return messageQueue.removeMessage();
   }
   
   private Message peekMessageOf(MessageQueue messageQueue) {
		return messageQueue.peekLastMessage();
   }
	
	private boolean haveSomeMessage(MessageQueue messageQueue) {
		return messageQueue.isMessageQueueSizeGreaterThan(INITIAL_MESSAGE_QUEUE_SIZE);
	}

   public void saveCurrentMessage() {
      Message message = removeCurrentMessage();
      if (isValidMessage(message)) {
         keptMessages.addMessage(message);
      }
   }


	private boolean isValidMessage(Message message) {
		return message != null;
	}

   public void changeGreeting(String newGreeting) {
      greeting = newGreeting;
   }

   public void changePasscode(String newPasscode) {
      passcode = newPasscode;
   }

   public String getGreeting() {
	   return greeting;
   }

}
