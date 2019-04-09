package classloaders;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ClassLoader getClassLoader(){
        return getClass().getClassLoader();
    }
}
