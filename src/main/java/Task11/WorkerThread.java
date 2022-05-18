package Task11;

import java.util.concurrent.LinkedBlockingQueue;

class WorkerThread extends Thread {
    private final LinkedBlockingQueue<Runnable> queue;
    private boolean isActive=true;
    public WorkerThread(LinkedBlockingQueue<Runnable> queue) {
        this.queue=queue;
    }

    public boolean isActive() {
        return isActive;
    }

    public void isActive(boolean active) {
        isActive = active;
    }

    public void run() {
        Runnable task;

        while (isActive) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException ignored) {
                    }
                }
                task = queue.poll();
            }

            try {
                task.run();
            } catch (RuntimeException e) {
                System.out.println("Error in runnable in thread: "+Thread.currentThread().getId());
            }
        }

    }
}
