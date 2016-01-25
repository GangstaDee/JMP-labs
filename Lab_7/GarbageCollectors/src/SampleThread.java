import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created on 17.01.2016.
 */
public class SampleThread implements Runnable {

    private int number;
    private WeakReference<SampleHugeObject> obj;

    public SampleThread(String filepath, int n) {

        SampleHugeObject inner = new SampleHugeObject(filepath);
        this.obj = new WeakReference<SampleHugeObject>(inner);
        this.number = n;
    }

    @Override
    public void run() {
        while (true){
            if(obj.get() == null) {
                System.out.println("Thread " + number + " : collected");
                break;
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

