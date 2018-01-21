package basket;

import discounts.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Basket {
    private ArrayList<Item> items;
    private TreeSet<IDiscount> discounts;
    private double total;


    public Basket() {
        items = new ArrayList<>();
        discounts = new TreeSet<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public TreeSet<IDiscount> getDiscounts() {
        return discounts;
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
