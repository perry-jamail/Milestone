import java.util.ArrayList;

/**
 * Store class which initializes an ArrayList of Product objects, an InventoryManager object, and a ShoppingCart object
 */
public class Store {
    ArrayList<Product> products;
    InventoryManager manager;
    ShoppingCart cart;

    /**
     * Constructor method which assignes the value of the products variable to a new ArrayList of Product objects, 
     * prints a welcome statement, initializes the InventoryManager and ShoppingCart, and populates the store ArrayList 
     * with Product objects
     */
    public Store() {
        this.products = new ArrayList<Product>();
        System.out.println("Hello and welcome to the Medieval Store! Your one stop shop for everything an adventurer could need!");
        manager = new InventoryManager();
        cart = new ShoppingCart();

        manager.populateStore(this);
    }
    
    /**
     * Method used to purchase the items that are in the shopping cart. 
     * The item quantities and prices are totaled and displayed, and then the cart is cleared.
     * @param buylist input ShoppingCart object to pull the Product objects and their quantities from
     */
    public void purchase(ShoppingCart buylist) {
        double total = 0.00;
        for (int i = 0; i < buylist.cart.size(); i++) {
            double itemTotal = buylist.cart.get(i).getPrice() * buylist.cart.get(i).getNumInCart();
            total += itemTotal;
        }

        buylist.clearCart();
        System.out.printf("Your total is $%.2f", total);
        System.out.println(". Thank you for shopping with us.");
    }   

    /**
     * Method to return Product objects to the store. The returned item's quantity is added to the Product object's quantity
     * variable and then quantity and item price is used to calculate the price of the refund.
     * @param returnedProduct is the input Product object that is used to determine which Product needs to increase its quantity variable
     * @param num is the input variable for how many of the Product object is being returned
     */
    public void returnItems(Product returnedProduct, int num) {
        returnedProduct.addQuantity(num);
        double refund = returnedProduct.getPrice() * num;
        System.out.printf("You have returned " + num + " " + returnedProduct.getName() + " and have been refunded $%.2f", refund);
        System.out.println(".");
    }

    /**
     * Method used to display all Product object's information that are in the store
     */
    public void displayStoreItems() {
        System.out.println("The store contains:");
        System.out.println();
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + 1 + ")");
            products.get(i).getProductInfo();
            System.out.println();
        }
    }
}
