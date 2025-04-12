import llds.pub_sub_queue.PubSubQueue;
import llds.pub_sub_queue.entities.PubSubQueueSystem;
import llds.snake_ladder.SnakeLadderGame;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//        Future<Integer> future = executorService.submit(() -> {
//            return 1;
//        });
//        List<Future<Integer>> futures = executorService.invokeAll(List.of(
//                () -> {return 1;},
//                () -> {return 2;}
//        ));
//        FixedWindowCounter rateLimiter = new FixedWindowCounter(5L, 5L);
//        for(int i = 0; i<3; i++) {
//            for(int j = 0; j<6; j++) {
//                rateLimiter.rateLimitRequest("1");
//            }
//            System.out.println("======================");
//            Thread.sleep(5000);
//        }

//        Router router = new Router();
//        router.addRoute("/", Router::homeHandler);
//        router.addRoute("/user/*", Router::userHandler);
//
//        String s = router.route("/");
//        System.out.println(s);
//
//        s = router.route("/user/123/himanshu");
//        System.out.println(s);

//        Snake  ladder game
//        SnakeLadderGame.startGame();

//        pubSub queue using poll mechanism
        PubSubQueue.start();

    }
}