import basket.Basket;
import basket.Item;
import discounts.Bogof;
import discounts.LoyaltyCard;
import discounts.PercentOff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BasketTest {
    Basket testBasket;
    Item testItemOne;
    Item testItemTwo;
    Bogof testBogof;
    LoyaltyCard testLoyaltyCard;
    PercentOff testPercentOff;

    @Before
    public void before() {
        testBasket = new Basket();
        testItemOne = new Item("Burger");
        testItemTwo = new Item("Cheese");
        testBogof = new Bogof();
        testLoyaltyCard = new LoyaltyCard();
        testPercentOff = new PercentOff();
    }

    @Test
    public void canAddItemToBasket() {
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        assertEquals(2, testBasket.numberOfItemsInBasket());
    }

    @Test
    public void canRemoveItemFromBasket() {
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        assertEquals(2, testBasket.numberOfItemsInBasket());
        testBasket.removeItemFromBasket(testItemTwo);
        assertEquals(1, testBasket.numberOfItemsInBasket());
    }

    @Test
    public void canEmptyBasket() {
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        assertEquals(2, testBasket.numberOfItemsInBasket());
        testBasket.emptyBasket();
        assertEquals(0, testBasket.numberOfItemsInBasket());
    }

    @Test
    public void canAddDiscount() {
        testBasket.addDiscount(testBogof);
        assertEquals(1, testBasket.numberOfDiscounts());
    }
}
