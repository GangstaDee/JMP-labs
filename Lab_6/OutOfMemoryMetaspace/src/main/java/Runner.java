import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 18.01.2016.
 */
public class Runner {

    public static void main(String[] args) {

        String filepath = "############/LoadedClass.class";

        Path path = Paths.get(filepath);
        try {
            byte[] classData = Files.readAllBytes(path);

            List<Class> classes = new ArrayList<>();

            ClassLoader parent = CustomClassLoader.class.getClassLoader();

            while(true) {
                CustomClassLoader classLoader = new CustomClassLoader(parent, classData);

            try {
                Class loaded = classLoader.findClass("LoadedClass");
                if(loaded == null) {
                    System.err.println("Failed to load class");
                    continue;
                }
                System.out.println("Loaded " + loaded.hashCode());
                classes.add( loaded);
                System.out.println(classes.size());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
                Thread.sleep(5);

        }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
