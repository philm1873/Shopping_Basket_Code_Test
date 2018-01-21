package discounts;

import basket.Basket;

public class PercentOff implements IDiscount {

    @Override
    public void applyDiscount(Basket basket) {

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
