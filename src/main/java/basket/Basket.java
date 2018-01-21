package basket;

import discounts.*;

import java.util.ArrayList;
import java.util.HashSet;

public class Basket {
    private ArrayList<Item> items;
    private HashSet<IDiscount> discounts;
    private double total;


    public Basket() {
        items = new ArrayList<>();
        discounts = new HashSet<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public void addDiscount(IDiscount discount) {
        this.discounts.add(discount);
    }

    public int numberOfDiscounts() {
        return this.discounts.size();
    }
}
