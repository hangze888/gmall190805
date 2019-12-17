package JUC;

import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class NotsafeDemo {

    public static void main(String[] args) {

        Map<String,String> map = new ConcurrentHashMap<>();//new HashMap<>();
        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,6));
                System.out.println(map);
            },String.valueOf(i)).start();
        }


        /*Set set = new CopyOnWriteArraySet();//Collections.synchronizedSet(new HashSet<>());//new HashSet();
        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,6));
                System.out.println(set);
            },String.valueOf(i)).start();
        }*/

        new HashSet<>();

        /*List<String> list = new CopyOnWriteArrayList<>();//new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList());//new Vector<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,6));
                System.out.println(list);
            },String.valueOf(i)).start();
        }*/
    }
}
