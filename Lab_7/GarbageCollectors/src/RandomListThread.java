import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created on 23.01.2016.
 */
public class RandomListThread implements Runnable {

    @Override
    public void run() {

        int listA = 10;
        int listB = 15;
        while(true) {

            int size = new Random().nextInt(listB-listA+1)+listA;

            //1
//            List list = new ArrayList<>(size);
//            for(int i = 0; i < size; i++) {
//                list.add(new byte[size*1024]);
//            }
//            list = null;

            //2
            List list = new ArrayList();
            for(int i = 0; i < 5; i++) {
                list.add(new byte[size*1024*1024]);
            }
            list = null;
         }
    }

}
