import java.util.ArrayList;

/**
 * ShoppingCart class that initializes an ArrayList of Product objects
 */
public class ShoppingCart {
    ArrayList<Product> cart;

    /**
     * Constructor method with no parameters. Sets the cart variable to a new ArrayList of Product objects
     */
    public ShoppingCart() {
        cart = new ArrayList<Product>();
    }

    /**
     * Method that adds Product object to the cart ArrayList and removes the quantity specified from the object's quantity variable
     * @param item is the specific Product object to add to the cart and change its quantity
     * @param num is the quantity of the product to be moved from the quantity variable to the numInCart variable
     */
    public void addToCart(Product item, int num) {
        cart.add(item);
        item.addNumInCart(num);
        item.removeQuantity(num);
        System.out.println("Added to your cart - " + num + " " + item.getName() + ".");
    }

    /**
     * Method that checks to make sure the specified Product object is in the cart with the inCart variable and then removes
     * the specified amount of items from the cart and adds it back to the object's quantity variable.
     * @param item is the specified Product object
     * @param num is the specified quantity to remove from the cart
     */
    public void removeFromCart(Product item, int num) {
        if (item.inCart) {
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getName() == item.getName()) {
                    cart.remove(i);
                    item.subNumInCart(num);
                    item.addQuantity(num);
                    System.out.println(num + " " + item.getName() + " have been removed from your cart. You now have " + item.getNumInCart() + " " + item.getName() + " in your cart.");
                }
            }
        } else {
            System.out.println("This item is not in your cart.");
        }
    }

    /**
     * Method that sets the cart variable to a new empty ArrayList of Product objects, effectively clearing the cart
     */
    public void clearCart() {
        cart = new ArrayList<Product>();
    }

    /**
     * Method that displays the information of each Product object in the cart ArrayList
     */
    public void displayCart() {
        System.out.print("Your Cart:");
        for (int i = 0; i < cart.size(); i++) {
            if (i == cart.size() - 1) {
                System.out.println(" [" + cart.get(i).getNumInCart() + " " + cart.get(i).getName() + "]");
            } else {
                System.out.print(" [" + cart.get(i).getNumInCart() + " " + cart.get(i).getName() + "],");
            }
        }
        System.out.println();
    }
}
