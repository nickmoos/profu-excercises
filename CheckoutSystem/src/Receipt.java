import java.util.ArrayList;
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