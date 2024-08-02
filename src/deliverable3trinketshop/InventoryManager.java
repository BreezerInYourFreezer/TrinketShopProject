package deliverable3trinketshop;

import deliverable3trinketshop.Item;
import deliverable3trinketshop.ItemPrinter;
import deliverable3trinketshop.ItemService;
import deliverable3trinketshop.StoreInventory;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {
    private ItemService itemService;
    private Scanner scanner;

    public InventoryManager() {
        this.itemService = new ItemService(new StoreInventory());
        this.scanner = new Scanner(System.in);
    }
//Options menu below.
    public void run() {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Search by Item Status");
            System.out.println("2. Search by Item Name");
            System.out.println("3. Search by Sold Date");
            System.out.println("4. Search by Seller");
            System.out.println("5. Add an Item");
            System.out.println("6. Delete an Item");
            System.out.println("7. Modify an Item");
            System.out.println("8. Print All Items");
            System.out.println("9. Exit");

            int choice = getIntInput();

            List<Item> results = null;

            switch (choice) {
                //Searching by item status.
                case 1:
                    System.out.println(
                            "Enter Item Status (1 for Available For Sale, 2 for Stolen Goods, 3 for Illegal To Own):");
                    int status = getValidStatus();
                    results = itemService.searchByStatus(status);
                    break;
                //Searching by item name.
                case 2:
                    System.out.println("Enter Item Name:");
                    String name = scanner.nextLine().trim();
                    results = itemService.searchByName(name);
                    break;
                //Searching by sold date.
                case 3:
                    System.out.println("Enter Sold Date (YYYY-MM-DD):");
                    LocalDate date = getDateInput();
                    if (date != null) {
                        results = itemService.searchBySoldDate(date);
                    }
                    break;
                //Searching by seller.
                case 4:
                    System.out.println("Enter Seller Name:");
                    String seller = scanner.nextLine().trim();
                    results = itemService.searchBySeller(seller);
                    break;
                //Adding a new item.
                case 5:
                    System.out.println("Enter Item Details:");
                    try {
                        System.out.println("Item Status:");
                        System.out.println("Enter 1 for Available For Sale");
                        System.out.println("Enter 2 for Stolen Goods");
                        System.out.println("Enter 3 for Illegal To Own");
                        int newItemStatus = getValidStatus();

                        System.out.println("Item Name:");
                        System.out.println("Enter the name of the item:");
                        String newItemName = scanner.nextLine().trim();

                        System.out.println("Item Quantity:");
                        System.out.println("Enter the quantity of the item (integer):");
                        int newItemQuantity = getIntInput();

                        System.out.println("Sold Price:");
                        System.out.println("Enter the sold price of the item (number, e.g., 99.99):");
                        double newSoldPrice = getDoubleInput();

                        System.out.println("Store Price:");
                        System.out.println("Enter the store price of the item (number, e.g., 199.99):");
                        double newStorePrice = getDoubleInput();

                        System.out.println("Sold Date:");
                        System.out.println("Enter the sold date of the item (YYYY-MM-DD):");
                        LocalDate newSoldDate = getDateInput();

                        System.out.println("Seller:");
                        System.out.println("Enter the name of the seller:");
                        String newItemSeller = scanner.nextLine().trim();

                        Item newItem = new Item(newItemStatus, newItemName, newItemQuantity, newSoldPrice,
                                newStorePrice, newSoldDate, newItemSeller);
                        itemService.addItem(newItem);
                        System.out.println("Item added successfully.");
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again.");
                    }
                    break;
                //Deleting an item.
                case 6:
                    itemService.getAllItems().forEach(System.out::println);
                    System.out.println("Enter the name of the item to delete:");
                    String deleteItemName = scanner.nextLine().trim();
                    if (itemService.deleteItem(deleteItemName)) {
                        System.out.println("Item deleted successfully.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                //Editing an item: this code always repeats if you got the item name wrong, as is intended.
                case 7:
                    itemService.getAllItems().forEach(System.out::println);
                    String modifyItemName;
                    boolean itemFound = false;

                    while (true) {
                        System.out.println(
                                "Enter the name of the item to modify:");
                        modifyItemName = scanner.nextLine().trim();
                        if (!itemService.searchByName(modifyItemName).isEmpty()) {
                            itemFound = true;
                            break;
                        } else {
                            System.out.println("Invalid Item. Please try again.");
                        }
                    }

                    try {
                        System.out.println("Enter new Item Details:");
                        System.out.println("Item Status:");
                        System.out.println("Enter 1 for Available For Sale");
                        System.out.println("Enter 2 for Stolen Goods");
                        System.out.println("Enter 3 for Illegal To Own");
                        int modItemStatus = getValidStatus();

                        System.out.println("Item Name:");
                        System.out.println("Enter the new name of the item:");
                        String modItemName = scanner.nextLine().trim();

                        System.out.println("Item Quantity:");
                        System.out.println("Enter the new quantity of the item (integer):");
                        int modItemQuantity = getIntInput();

                        System.out.println("Sold Price:");
                        System.out.println("Enter the new sold price of the item (number, e.g., 99.99):");
                        double modSoldPrice = getDoubleInput();

                        System.out.println("Store Price:");
                        System.out.println("Enter the new store price of the item (number, e.g., 199.99):");
                        double modStorePrice = getDoubleInput();

                        System.out.println("Sold Date:");
                        System.out.println("Enter the new sold date of the item (YYYY-MM-DD):");
                        LocalDate modSoldDate = getDateInput();

                        System.out.println("Seller:");
                        System.out.println("Enter the new seller name:");
                        String modItemSeller = scanner.nextLine().trim();

                        Item modifiedItem = new Item(modItemStatus, modItemName, modItemQuantity, modSoldPrice,
                                modStorePrice, modSoldDate, modItemSeller);
                        if (itemService.modifyItem(modifyItemName, modifiedItem)) {
                            System.out.println("Item modified successfully.");
                        } else {
                            System.out.println("Item not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again.");
                    }
                    break;
                //Print all items.
                case 8:
                    ItemPrinter.printItems(itemService.getAllItems());
                    break;
                //Exit the program without shutting it down.
                case 9:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (results != null && !results.isEmpty()) {
                ItemPrinter.printItems(results);
            }
        }
    }
//Security/input safety precautions, to allow for error handling.
    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    private LocalDate getDateInput() {
        while (true) {
            try {
                String dateString = scanner.nextLine().trim();
                return LocalDate.parse(dateString);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            }
        }
    }

    private int getValidStatus() {
        int status = getIntInput();
        while (status < 1 || status > 3) {
            System.out.println(
                    "Invalid status. Enter 1 for Available For Sale, 2 for Stolen Goods, or 3 for Illegal To Own:");
            status = getIntInput();
        }
        return status;
    }

    public ItemService getItemService() {
        return itemService;
    }
}