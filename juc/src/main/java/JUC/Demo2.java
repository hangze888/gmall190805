package JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo2{
    public static void main(String[] args) {
        MyThread thread = new MyThread();

        /*new Thread(()->{ for (int i = 0; i < 35; i++) thread.sale(); },"A").start();
        new Thread(()->{ for (int i = 0; i < 35; i++) thread.sale(); },"B").start();
        new Thread(()->{ for (int i = 0; i < 35; i++) thread.sale(); },"C").start();

        ArrayList arrayList = new ArrayList();*/

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            for (int i = 0; i <30 ; i++) {
                final int tempI = i;
                executorService.execute(()->{
                    thread.sale();
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 35; i++) {
                    thread.sale();
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 35; i++) {
                    thread.sale();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 35; i++) {
                    thread.sale();
                }
            }
        },"C").start();*/
    }
}
