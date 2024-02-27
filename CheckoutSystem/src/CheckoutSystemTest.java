
/**
 * The class CheckoutSystemTest exemplifies the usage of the checkout system.
 *
 * @author Anonymous Intern
 * @version 1.0
 */
public class CheckoutSystemTest
{
    /**
     * A static method to test the checkoutSystem
     */
    public static void testCheckoutSystem() {
        CheckoutSystem checkoutSystem = new CheckoutSystem();

        checkoutSystem.addItemToReceipt("Pizza", Receipt.CATEGORY_FOOD, 5);
        checkoutSystem.addItemToReceipt("Salami", Receipt.CATEGORY_FOOD, 2);
        checkoutSystem.addItemToReceipt("Tomatoes", Receipt.CATEGORY_FOOD, 3.5);
        checkoutSystem.printReceipt();

        checkoutSystem.addItemToReceipt("Red wine", Receipt.CATEGORY_ALCOHOL, 10);
        checkoutSystem.addItemToReceipt("Salami", Receipt.CATEGORY_FOOD, 2);
        checkoutSystem.printReceipt();

        checkoutSystem.addItemToReceipt("Banana", Receipt.CATEGORY_FOOD, 5000);
        checkoutSystem.addItemToReceipt("Minion Clone Machine TM", Receipt.CATEGORY_NON_FOOD, 1000);
        checkoutSystem.printReceipt();

        checkoutSystem.printSellingStatistics();
    }



}
