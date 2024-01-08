import java.util.ArrayList;

public class AdministrationInit {

    public static ArrayList<Person> createTestPersonList(){
        ArrayList<Person> personList = new ArrayList<>();

        // Create Lecturer objects and add them to the ArrayList
        personList.add(new Lecturer("Brown", "John", "john.brown@university.edu", 100000, 2010));
        personList.add(new Lecturer("Smith", "Jane", "jane.smith@university.edu", 80000, 2015));

        // Create Student objects and add them to the ArrayList
        personList.add(new Student("Johnson", "David", "david.johnson@university.edu", 123456, 2022));
        personList.add(new Student("Williams", "Mary", "mary.williams@university.edu", 678901, 2023));

        return personList;
    }

}
