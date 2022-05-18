package Task11;

public class MainApp {

    private static Runnable createTask(){
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("I am:" + Thread.currentThread().getId());
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) {

        ThreadPool threadPool = new FixedThreadPool(2);
        threadPool.execute(createTask());
        threadPool.execute(createTask());
        threadPool.execute(createTask());
        threadPool.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ScaledThreadPool");
        ThreadPool scalableThreadPool = new ScalableThreadPool(1,3);
        for(int i=0;i<50;i++){
            scalableThreadPool.execute(createTask());
        }
        scalableThreadPool.start();

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0;i<10;i++){
            scalableThreadPool.execute(createTask());
        }
    }
}
