package discounts;

import basket.Item;

import java.util.ArrayList;

public class LoyaltyCard implements IDiscount {
    @Override
    public void applyDiscount(ArrayList<Item> items, double total) {

    }

    @Override
    public boolean equals(Object object) {
        return object instanceof LoyaltyCard;
    }

    @Override
    public int hashCode() {
        return LoyaltyCard.class.hashCode();
    }

    @Override
    public int compareTo(IDiscount object) {
        if (object instanceof Bogof) {
            return 1;
        }
        if (object instanceof PercentOff) {
            return 1;
        }
        return 0;
    }
}
