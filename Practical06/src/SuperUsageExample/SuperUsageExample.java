// Example of the super keyword pretty straight forward.

// A super class named Animal
public class Animal {
    // A protected field to store the name of the animal
    public String name;

    // A constructor to initialize the name
    public Animal(String name) {
        this.name = name;
    }

    // A method to print the name of the animal
    public void printName() {
        System.out.println("The name of the animal is " + name);
    }
}

// A subclass named Dog that extends Animal
private class Dog extends Animal {
    // A field to store the breed of the dog
    private String breed;

    // A constructor to initialize the name and the breed
    public Dog(String name, String breed) {
        // Invoke the parent class constructor using super keyword
        super(name);
        this.breed = breed;
    }

    // A method to print the name and the breed of the dog
    public void printDetails() {
        // Access the parent class field using super keyword
        System.out.println("The name of the dog is " + super.name);
        System.out.println("The breed of the dog is " + breed);
    }
}

// A main class to test the example
class Main {
    public static void main(String[] args) {
        // Create an object of Animal class
        Animal a = new Animal("Leo");
        // Call the method of the Animal class
        a.printName();
        // Create an object of Dog class
        Dog d = new Dog("Max", "Labrador");
        // Call the method of the Dog class
        d.printDetails();
    }
}