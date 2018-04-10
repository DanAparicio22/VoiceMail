import java.util.ArrayList; 

public class Connection {
	
	private static final String RECORD_YOUR_GREETING_MESSAGE = "Record your greeting, then press the # key";
	private static final String ENTER_NEW_PASSCODE_MESSAGE = "Enter new passcode followed by the # key";
	private static final String INCORRECT_PASSCODE_MESSAGE = "Incorrect passcode. Try again!";
	private static final String INCORRECT_MAILBOX_NUMBER_MESSAGE = "Incorrect mailbox number. Try again!";
	private static final String NO_MESSAGES_STRING = "No messages.";
	private static final String LINE_BREAK = "\n";
	private static final String HASH_VALUE_STRING = "#";
	private static final String OPTION_FOUR = "4";
	private static final String OPTION_THREE = "3";
	private static final String OPTION_TWO = "2";
	private static final String OPTION_ONE = "1";
	private static final int CONNECTED = 1;
	private static final int RECORDING = 2;
	private static final int MAILBOX_MENU = 3;
	private static final int MESSAGE_MENU = 4;
	private static final int CHANGE_PASSCODE = 5;
	private static final int CHANGE_GREETING = 6;
	private static final String INITIAL_PROMPT = "Enter mailbox number followed by #";      
	private static final String MAILBOX_MENU_TEXT = "Enter 1 to listen to your messages\nEnter 2 to change your passcode\nEnter 3 to change your greeting";
	private static final String MESSAGE_MENU_TEXT = "Enter 1 to listen to the current message\nEnter 2 to save the current message\n"
         + "Enter 3 to delete the current message\nEnter 4 to return to the main menu";
	private MailSystem system;
	private Mailbox currentMailbox;
	private String currentRecording;
	private String accumulatedKeys; 
	private int state;
	private ArrayList<Observer> observers= new ArrayList<>();
	
   public Connection(MailSystem s) {
      this.system = s;  
      resetConnection();   
   } 
   
   public void attach(Observer o){
	   this.observers.add(o); 
	   updateNewObserver();
   } 
   
   public void updateNewObserver(){
	    this.observers.get(this.observers.size()-1).update(INITIAL_PROMPT);
   }
   
   public void notify(String message){
	   for(Observer observer : observers){
		   observer.update(message);
	   }
   }

   public void dial(String key) { 
	  switch(state) {
		  case CONNECTED: 
			  connect(key);
			  break;
		  case RECORDING: 
			  login(key);
			  break;
		  case CHANGE_PASSCODE: 
			  changePasscode(key);
			  break;
		  case CHANGE_GREETING: 
			  changeGreeting(key);
			  break;
		  case MAILBOX_MENU: 
			  getMailboxMenu(key);
			  break;
		  case MESSAGE_MENU: 
			  getMessageMenu(key);
			  break;
	  }
   }

   public void recordMessage(String voice) {
      if (isRecording() || isChangeGreeting()) {
         currentRecording += voice;
      }
   }

   public void hangUp() {
      if (isRecording()) {
         currentMailbox.addMessageInMailBox(new Message(currentRecording));
      }
      resetConnection();
   }
 
   private void resetConnection() {
      currentRecording = "";
      accumulatedKeys = "";
      state = CONNECTED; 
      notify(INITIAL_PROMPT);
   }

   private void connect(String key) {
      if (key.equals(HASH_VALUE_STRING)) { 
    	  	currentMailbox = system.findMailbox(accumulatedKeys);
         if (isCurrentMailBoxNotEmpty()) {
            state = RECORDING; 
            notify(currentMailbox.getGreeting());
         }
         else {
        	 notify(INCORRECT_MAILBOX_NUMBER_MESSAGE);
         } 
         accumulatedKeys = ""; 
      }else {   
    	  accumulatedKeys += key;  
      }
   }

   private void login(String key) {
      if (key.equals(HASH_VALUE_STRING)) { 
         if (currentMailbox.checkPasscodeOfMailBox(accumulatedKeys)) {
            state = MAILBOX_MENU; 
            notify(MAILBOX_MENU_TEXT);
         }
         else {
        	 notify(INCORRECT_PASSCODE_MESSAGE);
         }
         accumulatedKeys = "";
      }
      else {
         accumulatedKeys += key; 
      }
   }

   private void changePasscode(String key) {
      if (key.equals(HASH_VALUE_STRING)) {
         currentMailbox.changePasscode(accumulatedKeys);
         state = MAILBOX_MENU; 
         notify(MAILBOX_MENU_TEXT);
         accumulatedKeys = "";
      }
      else {
         accumulatedKeys += key; 
      }
   }

   private void changeGreeting(String key) {
      if (key.equals(HASH_VALUE_STRING)) {
         currentMailbox.changeGreeting(currentRecording);
         currentRecording = "";
         state = MAILBOX_MENU; 
     	notify(MAILBOX_MENU_TEXT);
      }
        
   }

   private void getMailboxMenu(String key) { 
	  switch(key) {
		  case OPTION_ONE:
			  state = MESSAGE_MENU;
			  notify(MESSAGE_MENU_TEXT);
			  break;
		  case OPTION_TWO:
			  state = CHANGE_PASSCODE;
			  notify(ENTER_NEW_PASSCODE_MESSAGE);
			  break;
		  case OPTION_THREE:
			  state = CHANGE_GREETING;
			  notify(RECORD_YOUR_GREETING_MESSAGE);
			  break;
		  /*default:
			  state = MAILBOX_MENU;
			  notify(MAILBOX_MENU_TEXT);
			  break;*/
	  }  
   }

   private void getMessageMenu(String key) {
	  String output = "";
	  switch(key) {
		  case OPTION_ONE:  
			  Message message = getCurrentMessageOfCurrentMailBox(); 
			  output = getMessageStringOfGotMessage(output, message);
 			  break;
		  case OPTION_TWO:
			  currentMailbox.saveCurrentMessage(); 
 			  break;
		  case OPTION_THREE:
			  currentMailbox.removeCurrentMessage(); 
 			  break;
		  case OPTION_FOUR:
			  state = MAILBOX_MENU;
			  output+=MAILBOX_MENU_TEXT;
			  break;
		  default:
			  state = MESSAGE_MENU;
			  break;
	  }
	  if (isInMessageMenu()) {
		  output += MESSAGE_MENU_TEXT;
	  }
	  notify(output);
   }
   
   public boolean isRecording() {
	   return state == RECORDING;
   }
   
   public boolean isConnected() {
	   return state == CONNECTED;
   }
    
   public boolean isInMessageMenu() {
	   return state == MESSAGE_MENU;
   }  
    
   public boolean isChangePasscode() {
	   return state == CHANGE_PASSCODE;
   }
   
   public boolean isChangeGreeting() {
	   return state == CHANGE_GREETING;
   }
   
   public boolean isInMailboxMenu() {
	   return state == MAILBOX_MENU;
   }
   
   public boolean isCurrentMailBoxNotEmpty() {
	   return currentMailbox != null;
   }
   
   public String showMessageText(Message message) {
		return message.getMessageText() + LINE_BREAK;
	}
	
	public String getStringOfNoMessages() {
		return NO_MESSAGES_STRING + LINE_BREAK;
	}
	
	public boolean haveAMessage(Message message) {
		return message == null;
	}
	
	public Message getCurrentMessageOfCurrentMailBox() {
		return currentMailbox.getCurrentMessage();
	}
	
	public String getMessageStringOfGotMessage(String output, Message message) {
		if (haveAMessage(message)) {
			output += getStringOfNoMessages(); 
		} else {
			output += showMessageText(message);
		}
		return output;
	}

}
