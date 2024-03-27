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
