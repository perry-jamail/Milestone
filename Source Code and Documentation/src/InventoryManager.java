import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class that is used to initialize and manage the inventory of the store
 */
public class InventoryManager {
    Scanner scan = new Scanner(System.in);
    ArrayList<Product> productsList;

    /**
     * Method that reads a JSON file and adds the data to an ArrayList
     * @param filename input value for the JSON file
     * @return ArrayList of Product objects read from the JSON file
     */
    public ArrayList<Product> readFromFile(String filename) {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            File file = new File(filename);
            Scanner s = new Scanner(file);

            while (s.hasNext()) {
                String json = s.nextLine();
                ObjectMapper objectMapper = new ObjectMapper();
                Product product = objectMapper.readValue(json, Product.class);
                products.add(product);
            }

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    /**
     * Constructor that initializes the productsList variable to the data from the JSON file by calling readFromFile()
     */
    public InventoryManager() {
        productsList = readFromFile("in.json");
    }

    /**
     * Method that adds each item in the productsList ArrayList to the products ArrayList in the Store object
     * @param store input value for the specified Store object
     */
    public void populateStore(Store store) {
        for (int i = 0; i < productsList.size(); i++) {
            store.products.add(productsList.get(i));
        }
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
            purchaseOptions(store);
        } else {
            System.out.println("Goodbye!");
        }
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
                    store.cart.addToCart(productsList.get(0), b);
                    break;

                    case 2:
                    store.cart.addToCart(productsList.get(1), b);
                    break;

                    case 3:
                    store.cart.addToCart(productsList.get(2), b);
                    break;

                    case 4:
                    store.cart.addToCart(productsList.get(3), b);
                    break;

                    case 5:
                    store.cart.addToCart(productsList.get(4), b);
                    break;

                    case 6:
                    store.cart.addToCart(productsList.get(5), b);
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

    /**
     * Method that uses the .sort() method to order the input ArrayList by names in alphabetical order ascending
     * @param p the input of an ArrayList<Product>
     * @return an ArrayList<Product>
     */
    public ArrayList<Product> sortByNameAscending(ArrayList<Product> p) {
        Collections.sort(p);
        return p;
    }

    /**
     * Method that uses the .sort() method to order the input ArrayList by names in alphabetical order descending
     * @param p the input of an ArrayList<Product>
     * @return an ArrayList<Product>
     */
    public ArrayList<Product> sortByNameDescending(ArrayList<Product> p) {
        ArrayList<Product> arr = new ArrayList<Product>();
        for (int i = 0; i < p.size(); i++) {
            arr.add(p.get(i));
        }

        Collections.sort(arr);
        p.clear();

        for (int x = arr.size() - 1; x >= 0; x--) {
            p.add(arr.get(x));
        }

        return p;
    }

    /**
     * Method that uses the .sort() method to order the input ArrayList by price in ascending order
     * @param p the input of an ArrayList<Product>
     * @return an ArrayList<Product>
     */
    public ArrayList<Product> sortByPriceAscending(ArrayList<Product> p) {
        ArrayList<Product> ref = new ArrayList<Product>();
        for (int i = 0; i < p.size(); i++) {
            ref.add(p.get(i));
        }

        ArrayList<Double> arr = new ArrayList<Double>();
        for (int i = 0; i < p.size(); i++) {
            arr.add(p.get(i).getPrice());
        }

        Collections.sort(arr);
        p.clear();

        for (int i = 0; i < ref.size(); i++) {
            for (int x = 0; x < ref.size(); x++) {
                if (arr.get(i) == ref.get(x).getPrice()) {
                    p.add(ref.get(x));
                }
            }
        }

        return p;
    }

    /**
     * Method that uses the .sort() method to order the input ArrayList by price in descending order
     * @param p the input of an ArrayList<Product>
     * @return an ArrayList<Product>
     */
    public ArrayList<Product> sortByPriceDescending(ArrayList<Product> p) {
        sortByPriceAscending(p);

        ArrayList<Product> arr = new ArrayList<Product>();
        for (int i = 0; i < p.size(); i++) {
            arr.add(p.get(i));
        }

        p.clear();

        for (int x = arr.size() - 1; x >= 0; x--) {
            p.add(arr.get(x));
        }

        return p;
    }
}