import basket.Basket;
import basket.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BasketTest {
    Basket testBasket;
    Item testItemOne;
    Item testItemTwo;

    @Before
    public void before() {
        testBasket = new Basket();
        testItemOne = new Item("Burger");
        testItemTwo = new Item("Cheese");
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
}
