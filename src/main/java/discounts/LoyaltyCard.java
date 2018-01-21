package discounts;

import basket.Basket;

public class LoyaltyCard implements IDiscount {
    @Override
    public void applyDiscount(Basket basket) {

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
