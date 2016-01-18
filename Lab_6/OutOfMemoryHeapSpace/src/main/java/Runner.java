import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 17.01.2016.
 */
public class Runner {

    public static void main(String[] args) {

        try {
            ExecutorService execService = Executors.newFixedThreadPool(2000);

            int i = 0;
            while (true) {
                System.out.println("Iteration " + i++);

                String filepath = "#############";
                Runnable r = new SampleThread(filepath);
                execService.submit(r);
                Thread.sleep(4500);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
