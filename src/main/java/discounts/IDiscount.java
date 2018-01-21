package discounts;

import basket.Basket;
import basket.Item;

import java.util.ArrayList;

public interface IDiscount extends Comparable<IDiscount> {

    double applyDiscount(ArrayList<Item> items, double total);

    boolean equals(Object object);

    int hashCode();

}
