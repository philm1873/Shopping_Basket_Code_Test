package discounts;

import basket.Basket;
import basket.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Bogof implements IDiscount {

    @Override
    public void applyDiscount(ArrayList<Item> items, double total) {
        ArrayList<Item> bogofItems = getItemsThatAreBogof(items);
    }

    private ArrayList<Item> getItemsThatAreBogof(ArrayList<Item> items) {
        ArrayList<Item> bogofItems = new ArrayList<>();
        for (Item item : items) {
            if (item.isBogof()) {
                bogofItems.add(item);
            }
        }
        return bogofItems;
    }

    private Set<String> getUniqueBogofItems(ArrayList<Item> items) {
        Set<String> uniqueBogofItems = new HashSet<>();
        for (Item item : items) {
            uniqueBogofItems.add(item.getName());
        }
        return uniqueBogofItems;
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
