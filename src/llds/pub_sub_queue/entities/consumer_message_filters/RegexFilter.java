package llds.pub_sub_queue.entities.consumer_message_filters;

public class RegexFilter implements MessageFilter{
    String regExPattern;

    public RegexFilter(String regExPattern) {
        this.regExPattern = regExPattern;
    }

    @Override
    public boolean isMessageAllowed(String message) {

        return false;
    }
}
