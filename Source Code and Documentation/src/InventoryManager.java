import java.util.Scanner;

/**
 * Class that is used to initialize and manage the inventory of the store
 */
public class InventoryManager {
    Scanner scan = new Scanner(System.in);
    Product sword;
    Product bow;
    Product chestplate;
    Product boots;
    Product healingPotion;
    Product crackers;

    /**
     * Constructor to initialize all the Product object variables defined at the top of the class
     */
    public InventoryManager() {
        this.sword = new Weapon("Sword", 199.99, 5);
        this.bow = new Weapon("Bow", 65.25, 10);
        this.chestplate = new Armor("Chestplate", 60.50, 8);
        this.boots = new Armor("Pair of Boots", 100, 3);
        this.healingPotion = new Health("Healing Potion", 99.99, 2);
        this.crackers = new Health("Crackers", 4.99, 30);
    }

    /**
     * Method that uses the addProduct() method on the Store object to add the different inventory items to the store list
     * @param store input value for the specified Store object
     */
    public void populateStore(Store store) {
        store.products.add(sword);
        store.products.add(bow);
        store.products.add(chestplate);
        store.products.add(boots);
        store.products.add(healingPotion);
        store.products.add(crackers);
    }

    /**
     * Method that uses the .remove() method on the Store object's ArrayList to remove the specified Product object
     * @param store input value for the specified Store object
     * @param item input value for the specified Product object
     */
    public void removeFromStore(Store store, Product item) {
        store.products.remove(item);
    }

    /**
     * Method that uses the .add() method on the Store object's ArrayList to add the specified Product object
     * @param store input value for the specified Store object
     * @param item input value for the specified Product object
     */
    public void addToStore(Store store, Product item) {
        store.products.add(item);
    }

    /**
     * Method that shows the initial options the user has when in the store. Directs the user to the correct method/output 
     * based on user input
     * @param store input value for the specified Store object
     */
    public void showOptions(Store store) {
        System.out.println("1) Look through store inventory");
        System.out.println("2) Leave store");
        System.out.print("> ");
        int choice = scan.nextInt();
        if (choice == 1) {
            store.displayStoreItems();
        } else {
            System.out.println("Goodbye!");
        }
        purchaseOptions(store);
    }

    /**
     * Method to print and register user input for selecting products to put into the cart
     * @param store input value for the specified Store object
     */
    public void purchaseOptions(Store store) {
        int a = 20;
        while (a > 0) {
            System.out.println("If you would like to add any items to your cart, type the list number for that item followed by the amount you would like to add to your cart. Type -1 to leave the store and 0 to purchase the items in your cart.");
            System.out.print("> ");
            a = scan.nextInt();
            if (a > 0) {
                int b = scan.nextInt();
                switch (a) {
                    case 1:
                    store.cart.addToCart(sword, b);
                    break;

                    case 2:
                    store.cart.addToCart(bow, b);
                    break;

                    case 3:
                    store.cart.addToCart(chestplate, b);
                    break;

                    case 4:
                    store.cart.addToCart(boots, b);
                    break;

                    case 5:
                    store.cart.addToCart(healingPotion, b);
                    break;

                    case 6:
                    store.cart.addToCart(crackers, b);
                    break;
                }
            } else {
                switch (a) {
                    case 0:
                    store.purchase(store.cart);
                    break;

                    case -1:
                    System.out.println("Goodbye!");
                    break;
                }
            }
        }
    }
}