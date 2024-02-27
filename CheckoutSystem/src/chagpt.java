import java.util.ArrayList;
import java.util.HashMap;

/**
 * The receipt class respresents the printout of checkout details on a piece of paper.
 * The sold articles are collected and printed out nicely formatted.
 *
 *
 * @author Anonymous Intern
 * @version 1.0
 */
public class Receipt {
    // A list of items in the receipt
    public ArrayList<Item> itemList;
    // The maximum width of the item description for formatting
    public static final int MAX_WIDTH = 32;

    /**
     * The constructor initializes the receipt with an empty item list
     */
    public Receipt() {
        this.itemList = new ArrayList<>();
    }

    /**
     * Print of company name and all sold articles. The length of item description will be analyzed
     * to print the price at the same position (in x direction). The sum of all items is calculated
     * and printed.
     */
    public void printReceipt() {
        double sum = 0;
        System.out.println("Shopping Paradise");
        System.out.println("Receipt");

        for (Item item : this.itemList) {
            String row = item.getDescription();
            int numSpaces = MAX_WIDTH - item.getDescription().length();
            for (int j = 0; j < numSpaces; j++) {
                row += " ";
            }
            row += item.getPrice();
            System.out.println(row);
            sum += item.getPrice();
        }
        String row = "TOTAL:";
        int numSpaces = MAX_WIDTH - "TOTAL:".length();
        for (int j = 0; j < numSpaces; j++) {
            row += " ";
        }
        row += sum;
        System.out.println(row);
        System.out.println("Thank you for shopping with us\n\n\n");
    }

    public static void main(String[] args) {
        Receipt receipt1 = new Receipt();
        receipt1.printReceipt();
    }
}

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
    private HashMap<String, Category> categories;

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

/**
 * The category class represents the type of an item that can be sold in the checkout system.
 * It has attributes such as name, tax rate, and discount rate.
 * It also has methods to calculate the tax and discount for a given price.
 */
class Category {
    // The name of the category
    private String name;
    // The tax rate of the category as a percentage
    private double taxRate;
    // The discount rate of the category as a percentage
    private double discountRate;

    /**
     * The constructor initializes the category with a name, a tax rate, and a discount rate.
     * @param name - the name of the category
     * @param taxRate - the tax rate of the category as a percentage
     * @param discountRate - the discount rate of the category as a percentage
     */
    public Category(String name, double taxRate, double discountRate) {
        this.name = name;
        this.taxRate = taxRate;
        this.discountRate = discountRate;
    }

    /**
     * This method returns the name of the category.
     * @return the name of the category
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method returns the tax rate of the category as a percentage.
     * @return the tax rate of the category as a percentage
     */
    public double getTaxRate() {
        return this.taxRate;
    }

    /**
     * This method returns the discount rate of the category as a percentage.
     * @return the discount rate of the category as a percentage
     */
    public double getDiscountRate() {
        return this.discountRate;
    }

    /**
     * This method calculates the tax amount for a given price based on the tax rate of the category.
     * @param price - the price of the item
     * @return the tax amount for the price
     */
    public double getTaxAmount(double price) {
        return price * this.taxRate / 100;
    }

    /**
     * This method calculates the discount amount for a given price based on the discount rate of the category.
     * @param price - the price of the item
     * @return the discount amount for the price
     */
    public double getDiscountAmount(double price) {
        return price * this.discountRate / 100;
    }
}

/**
 * The item class represents an item that can be sold in the checkout system.
 * It has attributes such as description, category, and price.
 * It also has methods to calculate the final price after applying tax and discount.
 */
class Item {
    // The description of the item
    private String description;
    // The category of the item
    private Category category;
    // The price of the item
    private double price;

    /**
     * The constructor initializes the item with a description, a category, and a price.
     * @param description - the description of the item
     * @param category - the category of the item
     * @param price - the price of the item
     */
    public Item(String description, Category category, double price) {
        this.description = description;
        this.category = category;
        this.price = price;
    }

    /**
     * The item class represents an item that can be sold in the checkout system.
     * It has attributes such as description, category, and price.
     * It also has methods to calculate the final price after applying tax and discount.
     */
    class Item {
        // The description of the item
        private String description;
        // The category of the item
        private Category category;
        // The price of the item
        private double price;

        /**
         * The constructor initializes the item with a description, a category, and a price.
         * @param description - the description of the item
         * @param category - the category of the item
         * @param price - the price of the item
         */
        public Item(String description, Category category, double price) {
            this.description = description;
            this.category = category;
            this.price = price;
        }

        /**
         * This method returns the description of the item.
         * @return the description of the item
         */
        public String getDescription() {
            return this.description;
        }

        /**
         * This method returns the category of the item.
         * @return the category of the item
         */
        public Category getCategory() {
            return this.category;
        }

        /**
         * This method returns the price of the item.
         * @return the price of the item
         */
        public double getPrice() {
            return this.price;
        }

        /**
         * This method calculates the final price of the item after applying tax and discount.
         * @return the final price of the item
         */
        public double getFinalPrice() {
            // Get the tax amount and the discount amount from the category
            double taxAmount = this.category.getTaxAmount(this.price);
            double discountAmount = this.category.getDiscountAmount(this.price);
            // Subtract the discount amount from the price and add the tax amount
            return this.price - discountAmount + taxAmount;
        }
    }

