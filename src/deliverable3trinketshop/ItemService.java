package deliverable3trinketshop;
import deliverable3trinketshop.StoreInventory;
import deliverable3trinketshop.StoreInventory;
import deliverable3trinketshop.Item;
import java.time.LocalDate;
import java.util.List;

public class ItemService {
    private StoreInventory storeInventory;

    public ItemService(StoreInventory storeInventory) {
        this.storeInventory = storeInventory;
    }

    public void addItem(Item item) {
        storeInventory.addItem(item);
    }

    public boolean deleteItem(String itemName) {
        return storeInventory.deleteItem(itemName);
    }

    public boolean modifyItem(String itemName, Item newItem) {
        return storeInventory.modifyItem(itemName, newItem);
    }

    public List<Item> searchByStatus(int status) {
        return storeInventory.getAllItems().stream()
                .filter(item -> item.getItemStatus() == status)
                .sorted((item1, item2) -> item2.getSoldDate().compareTo(item1.getSoldDate()))
                .toList();
    }

    public List<Item> searchByName(String name) {
        return storeInventory.getAllItems().stream()
                .filter(item -> item.getItemName().equalsIgnoreCase(name))
                .sorted((item1, item2) -> item2.getSoldDate().compareTo(item1.getSoldDate()))
                .toList();
    }

    public List<Item> searchBySoldDate(LocalDate date) {
        return storeInventory.getAllItems().stream()
                .filter(item -> item.getSoldDate().equals(date))
                .sorted((item1, item2) -> item2.getSoldDate().compareTo(item1.getSoldDate()))
                .toList();
    }

    public List<Item> searchBySeller(String seller) {
        return storeInventory.getAllItems().stream()
                .filter(item -> item.getSeller().equalsIgnoreCase(seller))
                .sorted((item1, item2) -> item2.getSoldDate().compareTo(item1.getSoldDate()))
                .toList();
    }

    public List<Item> getAllItems() {
        return storeInventory.getAllItems();
    }
}