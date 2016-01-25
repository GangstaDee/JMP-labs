import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 23.01.2016.
 */
public class Runner {

    public static void main(String[] args) {

        //main part - uncomment
        //ExecutorService service = Executors.newFixedThreadPool(2);
        //service.submit(new RandomListThread());

        //bonus - enhanced code from previous task (memory management - OOM: Java heap space)
        try {
            ExecutorService execService = Executors.newFixedThreadPool(2000);

            int i = 0;
            while (true) {
                System.out.println("Iteration " + i++);

                String filepath = "c:\\#######\\book.mobi";
                Runnable r = new SampleThread(filepath, i);
                execService.submit(r);
                Thread.sleep(4500);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
