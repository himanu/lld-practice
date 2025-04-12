package llds.pub_sub_queue.entities;


import llds.pub_sub_queue.entities.consumer_message_filters.MessageFilter;

public class Consumer {
    String id;
    String name;
    String topicId;

    PubSubQueueSystem queueSystem;
    MessageFilter filter;

    public Consumer(String id, String name) {
        this.id = id;
        this.name = name;
    }


    private void processMessage() {

        // if it faild

        // if it pass then invoke commitOffset otherwise not

        // QLP -> queue -> push failed messages -> to debug or process them separtly
        // again process message after a delay

    }

    public void pollMessage() {
        if(queueSystem == null) {
            System.out.println("Set queue connection first");
            return;
        }
        if(topicId == null) {
            System.out.println("Consumer is not subscribed to any topic");
            return;
        }

        String message = queueSystem.getMessageFromATopic(topicId, this.id);
        if (message != null) {
            System.out.println("Message recieved from queue " + message);
            if (filter != null && !filter.isMessageAllowed(message)) {
                pollMessage();
                return;
            }
            System.out.println("Final Message polled is " + message);
            System.out.println("================");
            return;
        }
        System.out.println("No Message Found");
        System.out.println("================");
    }

    public void subscribeToATopic(String topicId) {
        if(queueSystem == null) {
            System.out.println("Set queue connection first");
            return;
        }
        this.topicId = topicId;
        System.out.println("Subscribed to a topic ");
        System.out.println("==================");
    }

    public void unSubscribeToATopic() {
        this.topicId = null;
        queueSystem = null;
        System.out.println("UnSubscribed from the topic ");
        System.out.println("==================");
    }

    public void setQueueSystem(PubSubQueueSystem queueSystem) {
        this.queueSystem = queueSystem;
    }

    public void setFilter(MessageFilter filter) {
        this.filter = filter;
    }

}
