package deliverable3trinketshop;


import deliverable3trinketshop.Item;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StoreInventory {
    private List<Item> items;

    public StoreInventory() {
        this.items = new ArrayList<>();
        initializeDefaultItems();
    }
//Default items here, more can be added or removed.
    private void initializeDefaultItems() {
        items.add(new Item(1, "Monkey Skull", 1, 1000.00, 2000.00, LocalDate.of(2023, 5, 10), "Alice"));
        items.add(new Item(2, "Handgun", 5, 300.00, 600.00, LocalDate.of(2023, 5, 20), "Bob"));
        items.add(new Item(3, "Baby Alligator", 2, 150.00, 300.00, LocalDate.of(2023, 6, 1), "Charlie"));
        items.add(new Item(1, "Ancient Artifact", 1, 5000.00, 10000.00, LocalDate.of(2023, 4, 15), "David"));
        items.add(new Item(1, "Rare Painting", 3, 2000.00, 4000.00, LocalDate.of(2023, 5, 25), "Eve"));
        items.add(new Item(2, "Stolen Jewelry", 10, 1000.00, 2500.00, LocalDate.of(2023, 4, 10), "Frank"));
    }
//Basic item functions, called upon by ItemService at times.
    public void addItem(Item item) {
        items.add(item);
    }

    public boolean deleteItem(String itemName) {
        return items.removeIf(item -> item.getItemName().equalsIgnoreCase(itemName));
    }

    public boolean modifyItem(String itemName, Item newItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemName().equalsIgnoreCase(itemName)) {
                items.set(i, newItem);
                return true;
            }
        }
        return false;
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(items);
    }

}