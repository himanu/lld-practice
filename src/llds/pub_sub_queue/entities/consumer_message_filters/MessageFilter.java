package llds.pub_sub_queue.entities.consumer_message_filters;

public interface MessageFilter {
    boolean isMessageAllowed(String message);
}
