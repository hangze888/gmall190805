package JUC;


import java.util.concurrent.TimeUnit;

class Phone{

    public static synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(3);
        System.out.println(".....sendEmail");
    }

    public synchronized void sendMsM() throws Exception{
        System.out.println(".....sendMsM");
    }

    public void hello(){
        System.out.println("...hello");
    }
}


public class Lock8 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(()->{
            try {
                //phone.sendMsM();
                //phone.hello();
                phone2.sendMsM();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
