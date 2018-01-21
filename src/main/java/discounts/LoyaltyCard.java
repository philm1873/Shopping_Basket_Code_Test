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
}
