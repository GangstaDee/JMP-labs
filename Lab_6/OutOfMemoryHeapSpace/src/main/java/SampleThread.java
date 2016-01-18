/**
 * Created on 17.01.2016.
 */
public class SampleThread implements Runnable {

    private SampleHugeObject obj;

    public SampleThread(String filepath) {

        this.obj = new SampleHugeObject(filepath);
    }

    @Override
    public void run() {
        while (true){

        }
    }

}

