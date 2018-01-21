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
}
