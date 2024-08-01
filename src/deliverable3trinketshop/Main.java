package deliverable3trinketshop;


import deliverable3trinketshop.InventoryManager;


public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        System.out.println("Trinket Shop Inventory Manager\nCurrent Inventory:");
        ItemPrinter.printItems(inventoryManager.getItemService().getAllItems());
        inventoryManager.run();
    }
}