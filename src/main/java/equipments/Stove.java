package equipments;

import java.util.concurrent.Semaphore;

public class Stove {
    private Semaphore semaphore;

    public Stove(int capacity) {
        semaphore = new Semaphore(capacity);
    }

    public void acquireSlot() throws InterruptedException {
        semaphore.acquire();
    }

    public void releaseSlot() {
        semaphore.release();
    }
}