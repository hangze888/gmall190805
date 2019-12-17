package JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class myThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("........call");
        return 123;
    }
}


public class CallableDemo {

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new myThread());

        new Thread(futureTask,"A").start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
