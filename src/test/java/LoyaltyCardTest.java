import basket.Basket;
import basket.Item;
import discounts.LoyaltyCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoyaltyCardTest {
    private Basket testBasket;
    private Item testItemOne;
    private Item testItemTwo;
    private LoyaltyCard testLoyaltyCardOne;

    @Before
    public void before() {
        testBasket = new Basket();
        testItemOne = new Item("Burger", 0.50, true);
        testItemTwo = new Item("Cheese", 0.50, false);
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        testLoyaltyCardOne = new LoyaltyCard();
        testBasket.addDiscount(testLoyaltyCardOne);
    }

    @Test
    public void canApplyDiscount() {
        assertEquals(0.98, testLoyaltyCardOne.applyDiscount(testBasket.getItems(), testBasket.getTotal()), 0.01);
    }
}
