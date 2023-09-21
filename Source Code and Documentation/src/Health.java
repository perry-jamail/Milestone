/**
 * Class that extends from the Product class and uses the super keyword to set the appropriate description
 */
public class Health extends Product {
    /**
     * Constructor method that uses the super keyword to initialize values
     * @param name input value for the name variable
     * @param price input value for the price variable
     * @param quantity input value for the quantity variable
     */
    public Health(String name, double price, int quantity) {
        super(name, "Health", price, quantity);
    }
}
