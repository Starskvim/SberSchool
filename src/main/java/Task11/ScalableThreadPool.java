package Task11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ScalableThreadPool implements ThreadPool {
    private final int minNumOfThreadsInPool;
    private final int getMaxNumOfThreadsInPool;
    private final LinkedBlockingQueue<Runnable> queue;
    private final List<WorkerThread> workers;
    private Object lock = new Object();

    public ScalableThreadPool(int minNumOfThreadsInPool, int getMaxNumOfThreadsInPool) {
        this.minNumOfThreadsInPool = minNumOfThreadsInPool;
        this.getMaxNumOfThreadsInPool = getMaxNumOfThreadsInPool;
        queue = new LinkedBlockingQueue<Runnable>();
        workers = new ArrayList<>();
        for (int i = 0; i < minNumOfThreadsInPool; i++) {
            workers.add(new WorkerThread(queue));
        }
    }

    public int getCurrentSize() {
        return workers.size();
    }

    public int getMinNumOfThreadsInPool() {
        return minNumOfThreadsInPool;
    }

    public int getMaxNumOfThreadsInPool() {
        return getMaxNumOfThreadsInPool;
    }

    @Override
    public void start() {
        Thread superVisor = new Thread(this::control);
        superVisor.setDaemon(true);
        superVisor.start();

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

    private void control() {
        while (true) {
            synchronized (lock) {
                if (queue.size() >= 1) {
                    if (workers.size() < getMaxNumOfThreadsInPool()) {
                        System.out.println("Creating new thread...");
                        WorkerThread workerThread = new WorkerThread(queue);
                        workers.add(workerThread);
                        workerThread.start();
                    }
                } else {
                    for (int i = minNumOfThreadsInPool;i<workers.size();i++) {
                        if (workers.get(i).getState() == Thread.State.WAITING) {
                            if (workers.size() > minNumOfThreadsInPool) {
                                System.out.println("Removing thread...");
                                workers.get(i).interrupt();
                                workers.remove(i--);
                            }
                        }
                    }
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
