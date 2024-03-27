/**
 * The class CheckoutSystemTest exemplifies the usage of the checkout system.
 * It has been modified to work with the refactored code of the CheckoutSystem, Receipt, Category, and Item classes.
 * It creates some sample items and receipts and prints them out, along with the selling statistics.
 * It also demonstrates the use of the Category and Item classes to calculate the final price of each item.
 * @author Anonymous Intern
 * @version 2.0
 */
public class CheckoutSystemTest {
    /**
     * A static method to test the checkoutSystem
     */
    public static void testCheckoutSystem() {
        CheckoutSystem checkoutSystem = new CheckoutSystem();

        // Create some sample items with their descriptions, categories, and prices
        // Categories do have different tax and discount rates
        Item pizza = new Item("Pizza", checkoutSystem.categories.get("Food"), 5);
        Item salami = new Item("Salami", checkoutSystem.categories.get("Food"), 2);
        Item tomatoes = new Item("Tomatoes", checkoutSystem.categories.get("Food"), 3.5);
        Item redWine = new Item("Red wine", checkoutSystem.categories.get("Alcohol"), 10);
        Item banana = new Item("Banana", checkoutSystem.categories.get("Food"), 5000); // Why does a banana cost this much?
        Item minionCloneMachine = new Item("Minion Clone Machine TM", checkoutSystem.categories.get("Gadgets"), 1000);

        // Add the items to the current receipt and print it
        checkoutSystem.addItemToReceipt(pizza.getDescription(), pizza.getCategory().getName(), pizza.getPrice());
        checkoutSystem.addItemToReceipt(salami.getDescription(), salami.getCategory().getName(), salami.getPrice());
        checkoutSystem.addItemToReceipt(tomatoes.getDescription(), tomatoes.getCategory().getName(), tomatoes.getPrice());
        checkoutSystem.printReceipt();

        // Add the items to the current receipt and print it
        checkoutSystem.addItemToReceipt(redWine.getDescription(), redWine.getCategory().getName(), redWine.getPrice());
        checkoutSystem.addItemToReceipt(salami.getDescription(), salami.getCategory().getName(), salami.getPrice());
        checkoutSystem.printReceipt();

        // Add the items to the current receipt and print it
        checkoutSystem.addItemToReceipt(banana.getDescription(), banana.getCategory().getName(), banana.getPrice());
        checkoutSystem.addItemToReceipt(minionCloneMachine.getDescription(), minionCloneMachine.getCategory().getName(), minionCloneMachine.getPrice());
        checkoutSystem.printReceipt();

        // Print the selling statistics
        checkoutSystem.printSellingStatistics();

        // Print the final price of each item after applying tax and discount
        System.out.println("\n\nFinal price of each item after applying tax and discount");
        System.out.println("Pizza: " + pizza.getFinalPrice() + " CHF");
        System.out.println("Salami: " + salami.getFinalPrice() + " CHF");
        System.out.println("Tomatoes: " + tomatoes.getFinalPrice() + " CHF");
        System.out.println("Red wine: " + redWine.getFinalPrice() + " CHF");
        System.out.println("Banana: " + banana.getFinalPrice() + " CHF");
        System.out.println("Minion Clone Machine TM: " + minionCloneMachine.getFinalPrice() + " CHF");
    }

    public static void main(String[] args) {
        CheckoutSystemTest.testCheckoutSystem();
    }
}
