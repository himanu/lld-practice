package llds.pub_sub_queue.entities;


import java.util.HashMap;
import java.util.Map;

public class PubSubQueueSystem {
    Map<String, Topic> topics = new HashMap<>();

    public void addTopic(String topicId, String name) {
//        ToDo: Add logic to handle duplicate id or name
        topics.put(topicId, new Topic(topicId, name));
    }

    public void publishMessageToATopic(String topicId, Message message) {
        if (!topics.containsKey(topicId)) {
            System.out.println("Topic is invalid");
            System.out.println("==========");
            return;
        }

        Topic topic = topics.get(topicId);
        topic.publishMessage(message);
        System.out.println("Message is published");
        System.out.println("===========");
    }

    public String getMessageFromATopic(String topicId, String consumerId) {
        if (!topics.containsKey(topicId)) {
            System.out.println("Topic is invalid");
            System.out.println("==========");
            return null;
        }
        Topic topic = topics.get(topicId);

        return topic.pollMessage(consumerId);
    }

    // commitNewOffset


}
