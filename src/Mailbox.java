
public class Mailbox {
   
   private static final int INITIAL_MESSAGE_QUEUE_SIZE = 0;
   private MessageQueue newMessages;
   private MessageQueue keptMessages;
   private Message currentMessage;
   private String greeting;
   private String passcode;

   public Mailbox(String passcode, String greeting) {
      this.passcode = passcode;
      this.greeting = greeting;
      newMessages = new MessageQueue();
      keptMessages = new MessageQueue();
      currentMessage = null;
   }


   public boolean checkPasscodeOfMailBox(String introducedPasscode) {
      return introducedPasscode.equals(passcode);
   }


   public void addMessageInMailBox(Message newMessage) {
      newMessages.addMessage(newMessage);
   }

   public Message getCurrentMessage() {
      if (haveSomeMessage(newMessages)) {
         currentMessage = newMessages.peekMessageOfMessageQueue();
      } else {
    	  if (haveSomeMessage(keptMessages)) {
    		  currentMessage = keptMessages.peekMessageOfMessageQueue();
    	  } else {
    		  currentMessage = null;
    	  }
      }
      return currentMessage;
   }


   public Message removeCurrentMessage() {
      if (haveSomeMessage(newMessages)) {
    	  currentMessage = newMessages.removeMessage();
      } else {
    	  if (haveSomeMessage(keptMessages)) {
    		  currentMessage = keptMessages.removeMessage();
    	  } else {
    		  currentMessage = null;
    	  }
      }
      return currentMessage;
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
