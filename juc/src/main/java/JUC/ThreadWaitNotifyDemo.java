package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirConditoner{

    private int number = 0 ;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //判断(使用while最好)
            while(number != 0){
                condition.await();
            }
            //干活
            ++number;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //通知
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception{
        lock.lock();
        try {
            //判断(使用while最好)
            while(number == 0){
                condition.await();
            }
            //干活
            --number;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //通知
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    /*public synchronized void increment() throws Exception {
        //判断(使用while最好)
        while(number != 0){
            this.wait();
        }
        //干活
        ++number;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }
    public synchronized void decrement() throws Exception{
        //判断
        while(number == 0){
            this.wait();
        }
        //干活
        --number;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }*/
}

//多线程编程原理：如下
// 1.高内聚低耦合的前提下，线程操作资源类
// 2.判断(使用while判断)/干活/通知
// 3.防止多线程通信时，虚假唤醒的bug，在wait里面请用while(代表判断加循环)
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditoner airConditoner = new AirConditoner();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    airConditoner.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();


        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    airConditoner.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    airConditoner.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();


        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    airConditoner.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
