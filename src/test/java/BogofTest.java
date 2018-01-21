import basket.Basket;
import basket.Item;
import discounts.Bogof;
import discounts.LoyaltyCard;
import discounts.PercentOff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BogofTest {
    private Basket testBasket;
    private Item testItemOne;
    private Item testItemTwo;
    private Bogof testBogofOne;
    private LoyaltyCard testLoyaltyCardOne;
    private PercentOff testPercentOffOne;

    @Before
    public void before() {
        testBasket = new Basket();
        testItemOne = new Item("Burger", 2.75, true);
        testItemTwo = new Item("Cheese", 1.50, false);
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        testBasket.AddItemToBasket(testItemOne);
        testBogofOne = new Bogof();
        testLoyaltyCardOne = new LoyaltyCard();
        testPercentOffOne = new PercentOff();
        testBasket.addDiscount(testBogofOne);
        testBasket.addDiscount(testLoyaltyCardOne);
        testBasket.addDiscount(testPercentOffOne);
    }

    @Test
    public void canApplyDiscountTwoBurgers() {
        assertEquals(4.25, testBogofOne.applyDiscount(testBasket.getItems(), testBasket.getTotal()), 0.01);
    }

    @Test
    public void canApplyDiscountThreeBurgers() {
        testBasket.AddItemToBasket(testItemOne);
        assertEquals(7.0, testBogofOne.applyDiscount(testBasket.getItems(), testBasket.getTotal()), 0.01);
    }

    @Test
    public void noDiscountApplied() {
        testBasket.removeItemFromBasket(testItemOne);
        assertEquals(4.25, testBogofOne.applyDiscount(testBasket.getItems(), testBasket.getTotal()), 0.01);
    }
}
