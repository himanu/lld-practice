import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {
    int capacity;
    int frequency;
    Map<String, List<Long>> userRequestsTimestamps;

    public RateLimiter(int capacity, int frequency) {
        this.capacity = capacity;
        this.frequency = frequency;
        this.userRequestsTimestamps = new ConcurrentHashMap<>();
    }

    public void rateLimitRequest(String user_id) {
        if (!userRequestsTimestamps.containsKey(user_id)) {
            userRequestsTimestamps.put(user_id, new LinkedList<>());
        }

        // current timestamp
        Long currentSeconds = System.currentTimeMillis()/1000;

        // adjust the sliding window according to current time
        List<Long> slidingWindow = userRequestsTimestamps.get(user_id);
        while(slidingWindow.size() > 0 && (slidingWindow.get(0) <= currentSeconds - this.frequency)) {
            slidingWindow.removeFirst();
        }

        // apply rate limiting on the current window
        if (slidingWindow.size() >= this.capacity) {
            System.out.println("Rate Limited");
            return;
        }
        System.out.println("Req processed");
        slidingWindow.add(currentSeconds);

    }


}
