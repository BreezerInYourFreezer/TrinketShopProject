package deliverable3trinketshop;


import java.time.LocalDate;
//Getters for the item as well as how they are composed are here. This is the class to be modified if you are to add new fields.
public class Item {
    private int itemStatus;
    private String itemName;
    private int itemQuantity;
    private double soldPrice;
    private double storePrice;
    private LocalDate soldDate;
    private String seller;

    public Item(int itemStatus, String itemName, int itemQuantity, double soldPrice, double storePrice,
            LocalDate soldDate, String seller) {
        this.itemStatus = itemStatus;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.soldPrice = soldPrice;
        this.storePrice = storePrice;
        this.soldDate = soldDate;
        this.seller = seller;
    }
//Getters down here.
    public int getItemStatus() {
        return itemStatus;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public double getStorePrice() {
        return storePrice;
    }

    public LocalDate getSoldDate() {
        return soldDate;
    }

    public String getSeller() {
        return seller;
    }

    @Override
    public String toString() {
        return "ItemStatus: " + itemStatus +
                ", ItemName: " + itemName +
                ", ItemQuantity: " + itemQuantity +
                ", SoldPrice: " + soldPrice +
                ", StorePrice: " + storePrice +
                ", SoldDate: " + soldDate +
                ", Seller: " + seller;
    }
}