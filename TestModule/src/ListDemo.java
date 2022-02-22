import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        List<Integer> listTe = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,3,4,5,2,4,2,42,2,4));

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                List<Integer> list = new ArrayList<>(listTe);
                Iterator<Integer> iterator = list.iterator();
               while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                super.run();
                List<Integer> list = new ArrayList<>(listTe);
                list.removeIf(integer -> integer % 2 == 0);
            }
        };

        thread1.start();
        thread2.start();
    }
}
