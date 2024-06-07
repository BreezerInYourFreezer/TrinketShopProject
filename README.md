# TrinketShopProject
As the title states. Assignment repository.

The database being created here is for a trinket shop, though a highly unusual one recently under legal investigation after some items were stolen from their stock but it was discovered other items were stolen before being sold to them, illegally imported, or not legal to sell in Canada at all. The disorganization of the store's current system allowed for all these problems to come up, and a database showing in detail what is there, what quantity it is in, who sold it to them, the price it was bought for and price being sold for, when it was acquired, and the status of the item as in whether it must be disposed of or is safe to sell may fix them now and for the future too.


I will create code and an associated database to help with the recent inventory problems the store in question is having. 

The columns it will include are:

-ItemStatus, a number between 1 and 3. 1 for Available For Sale, 2 for Stolen Goods (Unavailable, must be turned over to the police and the seller who sold it to them must be contacted), and 3 for Illegal To Own (Unavailable, must be turned over to the police and the situation will be worked out).
-ItemName, stating what the item is.
-ItemQuantity, stating how much of the item there is.
-SoldPrice, stating how much it was sold to the shop for.
-StorePrice, stating how much the item is.
-SoldDate, stating when it was sold to the shop.
-SellerName, stating who sold it.


The plan is to make a fully functional code to be easily run by this hypothetical store owner or myself or anyone, which explains itself and its own functions as it goes along in the form of printing text. It will have UML diagrams featuring the Item objects, the ItemStatus object which may be separated if need be to state the story behind why the item isn't allowed and what actions must be taken, and the StoreInventory object which will store them all and allow functions to be performed on them. NetBeans, VP, and possibly more tools will be used for this.


