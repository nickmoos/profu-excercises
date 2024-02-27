import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * The class checkout system can collect bought items on a receipt, print the current receipt. Furthermore, the system can analyze all sold items based on category.
 *
 * @author Anonymous Intern
 * @version 1.0
 */
public class CheckoutSystem {
    // A list of all receipts in the system
    private ArrayList<Receipt> allReceipts;
    // The current receipt being processed
    private Receipt currentReceipt;
    // A map of categories and their corresponding tax and discount rates
    public HashMap<String, Category> categories;

    /**
     * Constructor initializing the checkout system and the categories
     */
    public CheckoutSystem() {
        this.allReceipts = new ArrayList<>();
        this.currentReceipt = new Receipt();
        this.categories = new HashMap<>();

        // Initialize the categories with their names and rates
        this.categories.put("Food", new Category("Food", 5, 10));
        this.categories.put("Alcohol", new Category("Alcohol", 10, 0));
        this.categories.put("Non-Food", new Category("Non-Food", 8, 5));
        this.categories.put("Journals", new Category("Journals", 2, 15));
        this.categories.put("Gadgets", new Category("Gadgets", 12, 0));

    }

    /**
     * This method enables adding a new entry to the recept consisting of item description,
     * category and price.
     *
     * @param item - item description
     * @param category - category of added item
     * @param price - price of item
     */
    public void addItemToReceipt(String item, String category, double price) {
        // Get the category object from the map
        Category cat = this.categories.get(category);
        if (cat == null) {
            // If the category is not found, print an error message
            System.out.println("Invalid category: " + category);
            return;
        }
        // Create a new item object with the given description, category, and price
        Item newItem = new Item(item, cat, price);
        // Add the item to the current receipt
        this.currentReceipt.itemList.add(newItem);
    }

    /**
     * This method is to be called when all items are collected and the receipt shell be
     * printed.
     */
    public void printReceipt() {
        this.currentReceipt.printReceipt();
        allReceipts.add(this.currentReceipt);
        this.currentReceipt = new Receipt();
    }

    /**
     * This method provides an analysis of all sales with respect to:
     * <ul>
     *    <li>Sold items</li>
     *    <li>Number of sold items per category</li>
     *    <li>Income per category</li>
     * </ul>
     */
    public void printSellingStatistics() {
        // A set of sold items
        HashSet<String> soldItems = new HashSet<>();
        // A map of categories and their corresponding number of sold items
        HashMap<String, Integer> soldItemsPerCategory = new HashMap<>();
        // A map of categories and their corresponding income
        HashMap<String, Double> incomePerCategory = new HashMap<>();

        // Loop through all the receipts
        for (Receipt receipt : allReceipts) {
            // Loop through all the items in the receipt
            for (Item item : receipt.itemList) {
                // Add the item description to the set of sold items
                soldItems.add(item.getDescription());
                // Get the category name of the item
                String categoryName = item.getCategory().getName();
                // Update the number of sold items for the category
                soldItemsPerCategory.put(categoryName, soldItemsPerCategory.getOrDefault(categoryName, 0) + 1);
                // Update the income for the category
                incomePerCategory.put(categoryName, incomePerCategory.getOrDefault(categoryName, 0.0) + item.getPrice());
            }
        }

        // Print the sold items
        System.out.println("Sold Items");
        for (String item : soldItems) {
            System.out.println(item);
        }

        // Print the number of sold items per category and income per category
        System.out.println("\n\nNumber of sold items per category and income per category");
        for (String category : this.categories.keySet()) {
            System.out.println("Items of category " + category + " were sold "
                    + soldItemsPerCategory.getOrDefault(category, 0) + " times for "
                    + incomePerCategory.getOrDefault(category, 0.0) + " CHF");
        }
    }
}
