package discounts;

import basket.Basket;

public interface IDiscount {

    void applyDiscount(Basket basket);

    boolean equals(Object object);

    int hashCode();

}
