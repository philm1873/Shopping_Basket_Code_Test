package discounts;

import basket.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Bogof implements IDiscount {

    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {
        Set<Item> bogofItems = getItemsThatAreBogof(items);
        for (Item item : bogofItems) {
            int occurrenceBogofItem = Collections.frequency(items, item);
            total -= (occurrenceBogofItem/2) * item.getPrice();
        }
        return total;
    }

    private Set<Item> getItemsThatAreBogof(ArrayList<Item> items) {
        Set<Item> bogofItems = new HashSet<>();
        for (Item item : items) {
            if (item.isBogof()) {
                bogofItems.add(item);
            }
        }
        return bogofItems;
    }


    @Override
    public boolean equals(Object object) {
        return object instanceof Bogof;
    }

    @Override
    public int hashCode() {
        return Bogof.class.hashCode();
    }

    @Override
    public int compareTo(IDiscount object) {
        if (object instanceof LoyaltyCard) {
            return -1;
        }
        if (object instanceof PercentOff) {
            return -1;
        }
        return 0;
    }
}
