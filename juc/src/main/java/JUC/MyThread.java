package JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread {
    private int number = 30;

    private Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if(number > 0){
                System.out.println(Thread.currentThread().getName()+"\t 卖出第"+(number--)+"\t 还剩下"+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
     /*public synchronized void sale(){
        if(number > 0){
            System.out.println(Thread.currentThread().getName()+"\t 卖出第"+(number--)+"\t 还剩下"+number);
        }*/
    }
}
