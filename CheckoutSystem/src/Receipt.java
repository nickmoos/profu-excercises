import java.util.ArrayList;
/**
 * The receipt class respresents the printout of checkout details on a piece of paper.
 * The sold articles are collected and printed out nicely formatted.
 *
 *
 * @author Anonymous Intern
 * @version 1.0
 */
public class Receipt
{
    public ArrayList<String> itemList;
    public ArrayList<String> categoryList;
    public ArrayList<Double> priceList;

    // Create class Category
    public static String CATEGORY_FOOD = "Food";
    public static String CATEGORY_ALCOHOL = "Alcohol";
    public static String CATEGORY_NON_FOOD = "Non-Food";
    public static String CATEGORY_JOURNALS = "Journals";

    /**
     * The constructor initialized the receipt with an empty item list
     */
    public Receipt() {
        this.itemList = new ArrayList<>();
        this.categoryList = new ArrayList<>();
        this.priceList = new ArrayList<>();
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
        int maxWidthOfItemDescription = 32;

        for (int i = 0; i < this.itemList.size(); i++) {
            String row = this.itemList.get(i);
            int numSpaces = maxWidthOfItemDescription - this.itemList.get(i).length();
            for (int j = 0; j < numSpaces; j++) {
                row += " ";
            }
            row += this.priceList.get(i);
            System.out.println(row);
            sum += this.priceList.get(i);
        }
        String row = "TOTAL:";
        int numSpaces = maxWidthOfItemDescription - "TOTAL:".length();
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