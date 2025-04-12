package llds.pub_sub_queue.entities;

import java.util.HashMap;
import java.util.Map;

public class Topic {
    String id;
    String name;
    Integer messageCounter;

    Map<Integer, Message> messages;
    Map<String, Integer> consumerOffsets; // key -> consumerId and value is messageId

//    {
//        1: m1,
//        2: m2,
//        3: m3
//    }
//
//    {
//        C1: 2
//    }

    public Topic(String id, String name) {
        this.id = id;
        this.name = name;
        messages = new HashMap<>();
        consumerOffsets = new HashMap<>();
        messageCounter = 0;
    }


    public void publishMessage(Message message) {
        messageCounter += 1;
        messages.put(messageCounter, message);
    }

    public String pollMessage(String consumerId) {
        // check for consume offset and read correct message and update offset
        if (!consumerOffsets.containsKey(consumerId)) {
            consumerOffsets.put(consumerId, 1);
        }
        Integer offset = consumerOffsets.get(consumerId);

        if (!messages.containsKey(offset)) {
            System.out.println("All messages are read");
            return null;
        }

        String message = messages.get(offset).text;
        consumerOffsets.put(consumerId, offset + 1);

        return message;
    }

}
