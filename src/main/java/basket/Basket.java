package basket;

import discounts.*;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> items;
    private ArrayList<Discount> discounts;
    private double total;


    public Basket() {
        items = new ArrayList<>();
        discounts = new ArrayList<>();
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

    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }

    public int numberOfDiscounts() {
        return this.discounts.size();
    }
}
