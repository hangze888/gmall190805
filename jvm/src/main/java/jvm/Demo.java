package jvm;


public class Demo {
    public static void main(String[] args) {
        /*Object o = new Object();
        System.out.println(o.getClass().getClassLoader());

        System.out.println("////////");
        Demo demo = new Demo();
        System.out.println(demo.getClass().getClassLoader().getParent().getParent());//启动类加载器
        System.out.println(demo.getClass().getClassLoader().getParent());//扩展类加载器
        System.out.println(demo.getClass().getClassLoader());//应用程序类加载*/

        /*URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());
        }*/

        Thread t1 = new Thread();
        t1.start();
        //t1.start();
    }
}
