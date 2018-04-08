import java.util.ArrayList;

public class MessageQueue {
   
   private ArrayList<Message> messageQueue;

   public MessageQueue() {
      messageQueue = new ArrayList<Message>();
   }

   public Message removeMessage() {
	  Message message = null;
	  if (!messageQueue.isEmpty()) {
		  message = messageQueue.remove(0);
	  }
	  return message;
   }

   public void addMessage(Message newMessage) {
      messageQueue.add(newMessage);
   }

   public int getMessageQueueSize() {
      return messageQueue.size();
   }

   public Message peekLastMessage() {
	  Message message = null;
      if (!isMessageQueueEmpty()) {
    	  message = messageQueue.get(0);
      }
      return message;
   }

   private boolean isMessageQueueEmpty() {
	   return messageQueue.size() == 0;
   }
   
   public boolean isMessageQueueSizeGreaterThan(int size) {
	   return getMessageQueueSize() > size;
   }

}
