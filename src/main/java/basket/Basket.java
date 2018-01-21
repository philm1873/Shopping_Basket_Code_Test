package basket;

import discounts.*;

import java.util.ArrayList;

public class Basket {
    ArrayList<Item> items;
    ArrayList<Discount> discounts;
    double total;


    public Basket() {
        items = new ArrayList<>();
        discounts = new ArrayList<>();
    }

    public int numberOfItemsInBasket() {
        return this.items.size();
    }

    public void AddItemToBasket(Item item) {
        this.items.add(item);
    }

    public void removeItemFromBasket(Item item) {
        this.items.remove(item);
    }

    public void emptyBasket() {
        this.items.clear();
    }

    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }

    public int numberOfDiscounts() {
        return this.discounts.size();
    }
}
