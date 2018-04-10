import java.util.ArrayList; 

/**
   Connects a phone to the mail system. The purpose of this
   class is to keep track of the state of a connection, since
   the phone itself is just a source of individual key presses.
*/
public class Connection
{
   /**
      Construct a Connection object.
      @param s a MailSystem object
      @param observer a Telephone object
   */
   public Connection(MailSystem s) {
      this.system = s;  
      resetConnection();   
   } 
   
   public void attach(Observer o){
	   this.observers.add(o); 
	   updateNewObserver();
   }
   
   public void detach(Observer o){
	   this.observers.remove(o);
   }
   
   public void updateNewObserver(){
	    this.observers.get(this.observers.size()-1).update(INITIAL_PROMPT);
   }

   /**
      Respond to the user's pressing a key on the phone touchpad
      @param key the phone key pressed by the user
   */
   public void dial(String key)
   { 
      if (isConnected())
         connect(key); 
      else if (isRecording()) 
         login(key); 
      else if (isChangingPassCode())
         changePasscode(key);
      else if (isChangingGreeting())
         changeGreeting(key);
      else if (isEnteringOptionOfMailBoxMenu())
         mailboxMenu(key);
      else if (isEnteringOptionOfMessageMenu())
         messageMenu(key); 
       
   }

   /**
      Record voice.
      @param voice voice spoken by the user
   */
   public void record(String voice)
   {
      if (isRecording() || isChangingGreeting())
         currentRecording += voice;
      
   }

   /**
      The user hangs up the phone.
   */
   public void hangup()
   {
      if (isRecording())
         currentMailbox.addMessage(new Message(currentRecording));
      resetConnection();
   }
 
   /**
      Reset the connection to the initial state and prompt
      for mailbox number
   */
   private void resetConnection()
   {
      currentRecording = "";
      accumulatedKeys = "";
      state = CONNECTED; 
      notify(INITIAL_PROMPT);
   }

   /**
      Try to connect the user with the specified mailbox.
      @param key the phone key pressed by the user
   */
   private void connect(String key)
   {
      if (key.equals("#"))
      {
         currentMailbox = system.findMailbox(accumulatedKeys);
         if (currentMailbox != null)
         {
            state = RECORDING; 
            notify(currentMailbox.getGreeting());
         }
         else 
        	 notify("Incorrect mailbox number. Try again!");
         accumulatedKeys = ""; 
      }
      else
         accumulatedKeys += key;
       
   }

   /**
      Try to log in the user.
      @param key the phone key pressed by the user
   */
   private void login(String key)
   {
      if (key.equals("#"))
      {
         if (currentMailbox.checkPasscode(accumulatedKeys))
         {
            state = MAILBOX_MENU; 
            notify(MAILBOX_MENU_TEXT);
         }
         else 
        	 notify("Incorrect passcode. Try again!");
         accumulatedKeys = "";
      }
      else
         accumulatedKeys += key;
   
      
   }

   /**
      Change passcode.
      @param key the phone key pressed by the user
   */
   private void changePasscode(String key)
   {
      if (key.equals("#"))
      {
         currentMailbox.setPasscode(accumulatedKeys);
         state = MAILBOX_MENU; 
         notify(MAILBOX_MENU_TEXT);
         accumulatedKeys = "";
      }
      else
         accumulatedKeys += key; 
   }

   /**
      Change greeting.
      @param key the phone key pressed by the user
   */
   private void changeGreeting(String key)
   {
      if (key.equals("#"))
      {
         currentMailbox.setGreeting(currentRecording);
         currentRecording = "";
         state = MAILBOX_MENU; 
     	notify(MAILBOX_MENU_TEXT);
      }
        
   }

   /**
      Respond to the user's selection from mailbox menu.
      @param key the phone key pressed by the user
   */
   private void mailboxMenu(String key)
   {
      if (key.equals("1"))
      {
         state = MESSAGE_MENU; 
         notify(MESSAGE_MENU_TEXT);
      }
      else if (key.equals("2"))
      {
         state = CHANGE_PASSCODE; 
         notify("Enter new passcode followed by the # key");
      }
      else if (key.equals("3"))
      {
         state = CHANGE_GREETING; 
         notify("Record your greeting, then press the # key");
      } 
   }

   /**
      Respond to the user's selection from message menu.
      @param key the phone key pressed by the user
   */
   private void messageMenu(String key)
   {
      if (key.equals("1"))
      {
         String output = "";
         Message m = currentMailbox.getCurrentMessage();
         if (m == null) output += "No messages." + "\n";
         else output += m.getText() + "\n";
         output += MESSAGE_MENU_TEXT; 
         notify(output);
      }
      else if (key.equals("2"))
      {
         currentMailbox.saveCurrentMessage(); 
         notify(MESSAGE_MENU_TEXT);
      }
      else if (key.equals("3"))
      {
         currentMailbox.removeCurrentMessage(); 
         notify(MESSAGE_MENU_TEXT);
      }
      else if (key.equals("4"))
      {
         state = MAILBOX_MENU; 
         notify(MAILBOX_MENU_TEXT);
      }
     
   }
   
   public boolean isRecording() {
	   return state == RECORDING;
   }
   
   public boolean isConnected() {
		return state == CONNECTED;
	}
   
   public boolean isLogging(){
	   return state == MAILBOX_MENU;
   }

   public boolean isChangingPassCode() {
	   return state == CHANGE_PASSCODE;
   }
   
   public boolean isChangingGreeting() {
	   return state == CHANGE_GREETING;
   }
   
   public boolean isEnteringOptionOfMailBoxMenu() {
	   return state == MAILBOX_MENU;
   }
   
   public boolean isEnteringOptionOfMessageMenu() {
	   return state == MESSAGE_MENU;
   }
   
   public void notify(String message){
	   for(Observer observer : observers){
		   observer.update(message);
	   }
   }
    
     
   private MailSystem system;
   private Mailbox currentMailbox;
   private String currentRecording;
   private String accumulatedKeys; 
   private int state; 
   private ArrayList<Observer> observers= new ArrayList<>();

   private static final int DISCONNECTED = 0;
   private static final int CONNECTED = 1;
   private static final int RECORDING = 2;
   private static final int MAILBOX_MENU = 3;
   private static final int MESSAGE_MENU = 4;
   private static final int CHANGE_PASSCODE = 5;
   private static final int CHANGE_GREETING = 6;

   private static final String INITIAL_PROMPT = 
         "Enter mailbox number followed by #";      
   private static final String MAILBOX_MENU_TEXT = 
         "Enter 1 to listen to your messages\n"
         + "Enter 2 to change your passcode\n"
         + "Enter 3 to change your greeting";
   private static final String MESSAGE_MENU_TEXT = 
         "Enter 1 to listen to the current message\n"
         + "Enter 2 to save the current message\n"
         + "Enter 3 to delete the current message\n"
         + "Enter 4 to return to the main menu";

}











