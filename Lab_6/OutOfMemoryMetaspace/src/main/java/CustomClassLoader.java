

/**
 * Created on 18.01.2016.
 */
public class CustomClassLoader extends ClassLoader {

    private byte[] bytes;

    public CustomClassLoader(ClassLoader parent, byte[] b) {

        super(parent);
        this.bytes = b;

    }

    @Override
    public Class findClass(String className) throws ClassNotFoundException {

        try {
            Class clazz = defineClass(className,
                    bytes, 0, bytes.length);

            return clazz;
        }  catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
