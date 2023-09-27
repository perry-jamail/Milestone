/**
 * Product class which initializes the different variables stored in the Product object such as name, description, 
 * and price. Implements the Comparable interface to override the .compareTo() method
 */
public class Product implements Comparable<Product> {
    String name;
    private String description;
    private double price;
    private int quantity;
    private int numInCart;
    boolean inCart;

    /**
     * Constructor method which sets the values of the initialized variables
     * @param n is the input value set to the name variable
     * @param d is the input value set to the description variable
     * @param p is the input value set to the price variable
     * @param q is the input value set to the quantity variable
     */
    public Product(String n, String d, double p, int q) {
        this.name = n;
        this.description = d;
        this.price = p;
        this.quantity = q;
        this.numInCart = 0;
        this.inCart = false;
    }

    /**
     * Default constructor for the Product class
     */
    public Product() {
        this.name = "";
        this.description = "";
        this.price = 0;
        this.quantity = 0;
        this.numInCart = 0;
        this.inCart = false;
    }

    /**
     * Getter method for the name variable
     * @return the value of the name variable
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter method for the name variable
     * @param newName is the input value set to the name variable
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Getter method for the description variable
     * @return the value of the description variable
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter method for the description variable
     * @param newDescription is the input value set to the description variable
     */
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    /**
     * Getter method for the price variable
     * @return the value of the price variable
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Setter method for the price variable
     * @param newPrice is the input value set to the price variable
     */
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    /**
     * Getter method for the quantity variable
     * @return the value of the quantity variable
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter method for the quantity variable
     * @param newQuantity is the input value set to the quantity variable
     */
    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    /**
     * Method that adds the input value to the quantity variable
     * @param addedNum is the input value which is added
     */
    public void addQuantity(int addedNum) {
        this.quantity += addedNum;
    }

    /**
     * Method that subtracts the input value from the quantity variable
     * @param removeNum is the input value which is subtracted
     */
    public void removeQuantity(int removeNum) {
        this.quantity -= removeNum;
    }

    /**
     * Getter method for the numInCart variable
     * @return the value of the numInCart variable
     */
    public int getNumInCart() {
        return this.numInCart;
    }

    /**
     * Method that adds the input value to the numInCart variable and sets inCart to true
     * @param toAdd is the input value which is added
     */
    public void addNumInCart(int toAdd) {
        this.numInCart += toAdd;
        if (this.numInCart > 0) {
            this.inCart = true;
        } else {
            this.inCart = false;
        }
    }

    /**
     * Method that subtracts the input value to the numInCart variable and sets inCart to false if numInCart == 0
     * @param toSub is the input value which is subtracted
     */
    public void subNumInCart(int toSub) {
        if (this.numInCart >= toSub) {
            this.numInCart -= toSub;
        } else {
            this.numInCart = 0;
        }

        if (this.numInCart > 0) {
            this.inCart = true;
        } else {
            this.inCart = false;
        }
    }

    /**
     * Method that displays all relevant product information about the Product object
     */
    public void getProductInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Description: " + this.description);
        System.out.println("Price: $" + this.price);
        System.out.println("Quantity: " + this.quantity);
    }

    /**
     * Overridden method from the Comparable interface that compares the name values of two Product objects
     * @param p input of the Product object to compare name values against
     * @return the value of the result of the comparison
     */
    @Override
    public int compareTo(Product p) {
        int value = this.name.compareTo(p.name);
        return value;
    }
}