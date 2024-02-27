import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 * The class checkout system can collect bought items on a receipt, print the current receipt. Furthermore, the system can analyze all sold items based on category.
 *
 * @author Anonymous Intern
 * @version 1.0
 */
public class CheckoutSystem
{
    private ArrayList<Receipt> allReceipts;

    private Receipt currentReceipt;

    /**
     * Constructor initializing the checkout system
     */
    public CheckoutSystem() {
        this.allReceipts = new ArrayList<>();
        this.currentReceipt = new Receipt();
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
        this.currentReceipt.itemList.add(item);
        this.currentReceipt.categoryList.add(category);
        this.currentReceipt.priceList.add(price);
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
        HashSet<String> soldArticles = new HashSet<>();
        for (Receipt r : allReceipts) {
            soldArticles.addAll(r.itemList);
        }
        System.out.println("Sold Items");
        for (String s : soldArticles) {
            System.out.println(s);
        }

        System.out.println("\n\nNumber of sold items per category and income per category");

        int countItemsFood = 0;
        int countItemsAlcohol = 0;
        int countItemsNonFood = 0;
        int countItemsJournals = 0;

        double incomeFood = 0.0;
        double incomeAlcohol = 0.0;
        double incomeNonFood = 0.0;
        double incomeJournals = 0.0;


        for (Receipt r : allReceipts) {
            for (int i = 0; i < r.itemList.size(); i++) {
                if (r.categoryList.get(i).equals(Receipt.CATEGORY_FOOD)) {
                    countItemsFood += 1;
                    incomeFood += r.priceList.get(i);
                }
                if (r.categoryList.get(i).equals(Receipt.CATEGORY_ALCOHOL)) {
                    countItemsNonFood += 1;
                    incomeAlcohol += r.priceList.get(i);
                }
                if (r.categoryList.get(i).equals(Receipt.CATEGORY_NON_FOOD)) {
                    countItemsNonFood += 1;
                    incomeNonFood += r.priceList.get(i);
                }
                if (r.categoryList.get(i).equals(Receipt.CATEGORY_JOURNALS)) {
                    countItemsJournals += 1;
                    incomeJournals += r.priceList.get(i);
                }
            }
        }

        System.out.println("Items of category food were sold "
                + countItemsFood + " times for "
                + incomeFood + " CHF");
        System.out.println("Items of category alcohol were sold "
                + countItemsNonFood + " times for "
                + incomeAlcohol + " CHF");
        System.out.println("Items of category non-food were sold "
                + countItemsNonFood + " times for "
                + incomeNonFood + " CHF");
        System.out.println("Items of category journal were sold "
                + countItemsJournals + " times for "
                + incomeJournals + " CHF");
    }

}
