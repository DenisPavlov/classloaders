package classloaders;

public class ExampleA {
    public static void main(String[] args) {
        Person person = new Person("Anton");
        System.out.println(person.getName());
    }
}
