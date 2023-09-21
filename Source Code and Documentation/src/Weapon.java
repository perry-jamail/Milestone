/**
 * Class that extends from the Product class and uses the super keyword to set the appropriate description. Also 
 * implements the Comparable<Weapon> interface
 */
public class Weapon extends Product implements Comparable<Weapon> {
    /**
     * Constructor method that uses the super keyword to initialize values
     * @param name input value for the name variable
     * @param price input value for the price variable
     * @param quantity input value for the quantity variable
     */
    public Weapon(String name, double price, int quantity) {
        super(name, "Weapon", price, quantity);
    }

    /**
     * Overridden method that is used to compare two Weapon objects by their names
     * @param w input for the Weapon object to compare against
     * @return the value of the difference between the two compared Weapon object's names
     */
    @Override
    public int compareTo(Weapon w) {
        int value = this.name.compareTo(w.name);
        return value;
    }
}