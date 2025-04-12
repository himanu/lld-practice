package llds.pub_sub_queue;


import llds.pub_sub_queue.entities.Consumer;
import llds.pub_sub_queue.entities.Message;
import llds.pub_sub_queue.entities.PubSubQueueSystem;

public class PubSubQueue {
    public static void start() {
        PubSubQueueSystem pubSubQueueSystem = new PubSubQueueSystem();

//        Add topics
        pubSubQueueSystem.addTopic("1", "A");
        pubSubQueueSystem.addTopic("2", "B");
        pubSubQueueSystem.addTopic("3", "C");

        // create consumers
        Consumer consumer1 = new Consumer("1", "C1");
        Consumer consumer2 = new Consumer("2", "C2");

        // connect consumer with queue
        consumer1.setQueueSystem(pubSubQueueSystem);
        consumer2.setQueueSystem(pubSubQueueSystem);

        // subscribe to a topic
        consumer1.subscribeToATopic("1");
        consumer2.subscribeToATopic("1");


        // publish message to a topic
        Message m1 = new Message("m1");
        Message m2 = new Message("m2");
        Message m3 = new Message("m3");

        pubSubQueueSystem.publishMessageToATopic("1", m1);
        pubSubQueueSystem.publishMessageToATopic("1", m2);
        pubSubQueueSystem.publishMessageToATopic("2", m3);


        // poll messages
        consumer1.pollMessage();
        consumer1.pollMessage();
        consumer1.pollMessage();


    }
}