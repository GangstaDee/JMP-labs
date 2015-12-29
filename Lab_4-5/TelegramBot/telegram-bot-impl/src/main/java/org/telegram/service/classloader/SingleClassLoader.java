package org.telegram.service.classloader;

import java.io.ByteArrayOutputStream;
import java.util.*;


/**
 * Created on 27.12.2015.
 */
public class SingleClassLoader extends ClassLoader {

    private Map<String, Class> classes = new HashMap<>();
    private byte[] bytes;

    public SingleClassLoader(ClassLoader parent, ByteArrayOutputStream os) {

        super(parent);
        this.bytes = os.toByteArray();

    }

    @Override
    public Class findClass(String className) throws ClassNotFoundException {

        Class existing = (Class) classes.get(className);
        if (existing != null) {
            return existing;
        }

        try {
            Class clazz = defineClass(className,
                bytes, 0, bytes.length);

            classes.put(className, clazz);

            return clazz;
        }  catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}