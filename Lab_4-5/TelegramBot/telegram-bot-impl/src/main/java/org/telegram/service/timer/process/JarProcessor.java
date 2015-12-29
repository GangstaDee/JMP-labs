package org.telegram.service.timer.process;

import command.Command;
import command.CommandFactory;
import org.telegram.service.classloader.SingleClassLoader;
import org.telegram.util.JarUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

/**
 * Created on 30.12.2015.
 */
public class JarProcessor implements IChangesProcessor {

    public void onUpdate(File directory, File modifiedFile) {

        Map<String, ByteArrayOutputStream> classData = JarUtils.loadJar(directory,modifiedFile);

        ClassLoader parent = SingleClassLoader.class.getClassLoader();
        for(String className : classData.keySet()) {
            SingleClassLoader classLoader = new SingleClassLoader(parent, classData.get(className));

            try {
                Class loaded = classLoader.loadClass(className);
                if(loaded == null) {
                    System.err.println("Failed to load class " + className);
                    continue;
                }

                System.out.println("loaded class " + loaded.getName());
                if(!loaded.getSuperclass().equals(Command.class))
                    continue;

                Command c = (Command)loaded.newInstance();
                CommandFactory.addCommand(c.getAction(), c);
                System.out.println("command added/updated: " + loaded.getName());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }
}
