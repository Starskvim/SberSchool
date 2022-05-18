package Task11;

import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final WorkerThread[] workers;
    private final LinkedBlockingQueue<Runnable> queue;
    private int size;

    public FixedThreadPool(int size) {
        queue = new LinkedBlockingQueue<Runnable>();
        workers = new WorkerThread[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            workers[i] = new WorkerThread(queue);
        }

    }

    public int getSize() {
        return size;
    }

    @Override
    public void start() {
        for (WorkerThread worker : workers) {
            worker.start();
        }
    }

    @Override
    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }
}
