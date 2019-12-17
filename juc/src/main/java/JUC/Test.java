package JUC;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i <30 ; i++) {
                final int tempI = i;
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 卖出票" + "\t票号" +tempI);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
