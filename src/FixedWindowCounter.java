import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowCounter {
    ConcurrentHashMap<Object, Map<String, Long>> userLevelRLInfo;
    Long maxLimit;
    Long frequency;

    public FixedWindowCounter(Long maxLimit, Long frequency) {
        this.maxLimit = maxLimit;
        this.frequency = frequency;
        userLevelRLInfo = new ConcurrentHashMap<Object, Map<String, Long>>();
    }

    public void rateLimitRequest(String userId) {
        if (!userLevelRLInfo.containsKey(userId)) {
            userLevelRLInfo.put(userId, new HashMap<String, Long>() {{
                put("counter", 0L);
                put("credit", 0L);
                put("windowStartTime", 0L);
            }});
        }
        Map<String, Long> userRL = userLevelRLInfo.get(userId);
        Long counter = userRL.get("counter");
        Long windowStartTime = userRL.get("windowStartTime");
        Long currentTimeSec = System.currentTimeMillis() / 1000;
        if (windowStartTime > 0 && (currentTimeSec - frequency < windowStartTime)) {
            if (counter < maxLimit) {
                userRL.put("counter", counter + 1);
                System.out.println("Request pass " + counter);
            } else {
                System.out.println("Request RL");
            }
        } else {
            userRL.put("counter", 1L);
            userRL.put("windowStartTime", currentTimeSec);
            System.out.println("Request Pass");
        }
    }
}
