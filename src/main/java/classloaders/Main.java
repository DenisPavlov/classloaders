package classloaders;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        Person person = new Person("dsadsa");
        ClassLoader classLoader = person.getClassLoader();
        System.out.println(classLoader);

        //у classLoader еще нет класса Car

        Car car = new Car();

        // а тут уже есть

        ClassLoader parentClassLoader = classLoader.getParent();
        System.out.println(parentClassLoader);


//        URLClassLoader pluginClassLoader = new URLClassLoader(new URL[]{new URL("file:dsadsa")});
//        Class cl = pluginClassLoader.loadClass("myClass");
    }
}

class MyLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get("fileName"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Class<?> cl = defineClass(name, bytes, 0, bytes.length);
        return cl;
    }
}