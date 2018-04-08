import java.util.ArrayList;

public class MessageQueue {
   
   private ArrayList<Message> messageQueue;

   public MessageQueue() {
      messageQueue = new ArrayList<Message>();
   }

   public Message removeMessage() {
	  if (!messageQueue.isEmpty()) {
		  return messageQueue.remove(0);
	  }
	  return null;
   }

   public void addMessage(Message newMessage) {
      messageQueue.add(newMessage);
   }

   public int getMessageQueueSize() {
      return messageQueue.size();
   }

   public Message peekMessageOfMessageQueue() {
      if (isMessageQueueEmpty()) {
    	  return null;  
      } else {
    	  return messageQueue.get(0);
      }
   }

	private boolean isMessageQueueEmpty() {
		return messageQueue.size() == 0;
	}
   
   public boolean isMessageQueueSizeGreaterThan(int size) {
	   return getMessageQueueSize() > size;
   }

}
