package JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class review {

    public static void main(String[] args) throws InterruptedException {

        /*CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i <6 ; i++) {
            final int tempI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t"+tempI);
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println("最后走");*/

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });

        for (int i = 0; i <7 ; i++) {
            final int tempI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 龙珠第" + tempI);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
