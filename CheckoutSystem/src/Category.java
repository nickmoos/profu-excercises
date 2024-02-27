
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
