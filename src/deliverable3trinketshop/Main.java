package deliverable3trinketshop;


import deliverable3trinketshop.InventoryManager;
//Main class, run this to run the program itself.

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        System.out.println("Trinket Shop Inventory Manager\nCurrent Inventory:");
        ItemPrinter.printItems(inventoryManager.getItemService().getAllItems());
        inventoryManager.run();
    }
}