/**
 * Class to contain a main method which initializes a Store object and runs the different game commands
 */
public class Driver {
    /**
     * Main method which runs the game commands and initializes Store objects
     */
    public static void main(String[] args) {
        Store store = new Store();
        //store.manager.showOptions(store);
        //store.displayStoreItems();
        store.manager.sortByNameAscending(store.products);
        store.manager.sortByNameDescending(store.products);
        store.manager.sortByPriceAscending(store.products);
        store.manager.sortByPriceDescending(store.products);
        store.displayStoreItems();
        
    }
}
