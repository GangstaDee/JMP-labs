import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created on 17.01.2016.
 */
public class SampleHugeObject {

    byte[] content;

    public SampleHugeObject(String filepath) {
        readFile(filepath);
    }


    private void readFile(String filepath) {

        try {
            Path path = Paths.get(filepath);
            content = Files.readAllBytes(path);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close it
        }
    }


}
