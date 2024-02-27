import java.util.ArrayList;
import java.util.HashMap;


public class AdministrationInit {

    public static ArrayList<Person> createTestPersonList(){
        ArrayList<Person> personList = new ArrayList<>();
        HashMap<String, Person> personHashMap = new HashMap<String, Person>();

        // Create Lecturer objects and add them to the ArrayList
        personList.add(new Lecturer("Brown", "John", "john.brown@university.edu", 100000, 2010));
        personList.add(new Lecturer("Smith", "Jane", "jane.smith@university.edu", 80000, 2015));

        personHashMap.put("", new Lecturer("Brown", "John", "john.brown@university.edu", 100000, 2010));

        // Create Student objects and add them to the ArrayList
        personList.add(new Student("Johnson", "David", "david.johnson@university.edu", 123456, 2022));
        personList.add(new Student("Williams", "Mary", "mary.williams@university.edu", 678901, 2023));

        return personList;
    }

//Only nested classes can be static
//Abstract classes can be on the toplevel and can contain both abstract methods
//which are implemented elsewhere aswell as normal methods:
//public abstract class Animal {
//    // An abstract method
//    public abstract void makeSound();
//    // A concrete method
//    public void eat() {
//        System.out.println("Eating...");
//    }
//}

}
