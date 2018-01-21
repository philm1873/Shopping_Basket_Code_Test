import basket.Basket;
import basket.Item;
import discounts.PercentOff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PercentOffTest {
    private Basket testBasket;
    private Item testItemOne;
    private Item testItemTwo;
    private PercentOff testPercentOff;

    @Before
    public void before() {
        testBasket = new Basket();
        testItemOne = new Item("Burger", 20.00, true);
        testItemTwo = new Item("Cheese", 20.00, false);
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        testPercentOff = new PercentOff();
        testBasket.addDiscount(testPercentOff);
    }

    @Test
    public void canApplyDiscount() {
        assertEquals(36.0, testPercentOff.applyDiscount(testBasket.getItems(), testBasket.getTotal()), 0.01);
    }

    @Test
    public void noDiscountApplied() {
        Item testItem = new Item("Food", -22, false);
        testBasket.AddItemToBasket(testItem);
        assertEquals(18, testPercentOff.applyDiscount(testBasket.getItems(), testBasket.getTotal()), 0.01);
    }

}
