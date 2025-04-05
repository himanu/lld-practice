import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    AtomicInteger count = new AtomicInteger();
    public void increment() {
        count.incrementAndGet();
    }

    public void decrement() {
        count.decrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

    public void setCount(int count) {
        this.count.set(count);
    }
}
