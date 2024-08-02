package deliverable3trinketshop;
import deliverable3trinketshop.Item;
import java.util.List;
//This is to save space in InventoryManager and make it more readable, making a print function elsewhere.
public class ItemPrinter {
    public static void printItems(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("No items found.");
        } else {
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }
    }
}