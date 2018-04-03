import java.util.ArrayList;

/**
   A first-in, first-out collection of messages. This
   implementation is not very efficient. We will consider
   a more efficient implementation in chapter 3.
*/
public class MessageQueue
{
   /**
      Constructs an empty message queue.
   */
   public MessageQueue()
   {
      messageQueue = new ArrayList<Message>();
   }

   /**
      Remove message at head.
      @return message that has been removed from the queue
   */
   public Message remove()
   {
      return messageQueue.remove(0);
   }

   /**
      Append message at tail.
      @param newMessage the message to be appended
   */
   public void add(Message newMessage)
   {
      messageQueue.add(newMessage);
   }

   /**
      Get the total number of messages in the queue.
      @return the total number of messages in the queue
   */
   public int getMessageQueueSize()
   {
      return messageQueue.size();
   }

   /**
      Get message at head.
      @return message that is at the head of the queue, or null
      if the queue is empty
   */
   public Message peek()
   {
      if (messageQueue.size() == 0) return null;
      else return messageQueue.get(0);
   }
   
   public boolean isMessageQueueGreaterThan(int size){
	   return getMessageQueueSize() > size;
   }

   private ArrayList<Message> messageQueue;
}
