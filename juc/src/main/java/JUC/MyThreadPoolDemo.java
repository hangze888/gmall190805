package JUC;

import java.util.concurrent.*;

public class MyThreadPoolDemo {

    public static void main(String[] args) {
        /*ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        ExecutorService threadPool3 = Executors.newCachedThreadPool();*/

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
                );
        try {
            for (int i = 1; i <=10; i++)
            {
                final int tempI = i;
                threadPool.execute(() -> {System.out.println(Thread.currentThread().getName()+"\t 受理业务"+"\t 客户号："+tempI);});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
