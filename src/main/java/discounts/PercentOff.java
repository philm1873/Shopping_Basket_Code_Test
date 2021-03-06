package discounts;

import basket.Item;

import java.util.ArrayList;

public class PercentOff implements IDiscount {

    @Override
    public double applyDiscount(ArrayList<Item> items, double total) {
        if (total > 20.0) {
            return total * 0.9;
        }
        return total;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof PercentOff;
    }

    @Override
    public int hashCode() {
        return PercentOff.class.hashCode();
    }

    @Override
    public int compareTo(IDiscount object) {
        if (object instanceof Bogof) {
            return 1;
        }
        if (object instanceof LoyaltyCard) {
            return -1;
        }
        return 0;
    }
}
