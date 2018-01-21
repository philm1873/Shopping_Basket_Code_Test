import basket.Basket;
import basket.Item;
import discounts.Bogof;
import discounts.LoyaltyCard;
import discounts.PercentOff;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BasketTest {
    private Basket testBasket;
    private Item testItemOne;
    private Item testItemTwo;
    private Item testItemThree;
    private Bogof testBogofOne;
    private Bogof testBogofTwo;
    private LoyaltyCard testLoyaltyCardOne;
    private LoyaltyCard testLoyaltyCardTwo;
    private PercentOff testPercentOffOne;
    private PercentOff testPercentOffTwo;

    @Before
    public void before() {
        testBasket = new Basket();
        testItemOne = new Item("Burger", 2.75, true);
        testItemTwo = new Item("Cheese", 1.50, false);
        testItemThree = new Item("Steak", 20.50, false);
        testBogofOne = new Bogof();
        testBogofTwo = new Bogof();
        testLoyaltyCardOne = new LoyaltyCard();
        testLoyaltyCardTwo = new LoyaltyCard();
        testPercentOffOne = new PercentOff();
        testPercentOffTwo = new PercentOff();
    }

    @Test
    public void canAddItemToBasket() {
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        assertEquals(2, testBasket.numberOfItemsInBasket());
        assertEquals(4.25, testBasket.getTotal(), 0.01);
    }

    @Test
    public void canRemoveItemFromBasket() {
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        assertEquals(2, testBasket.numberOfItemsInBasket());
        testBasket.removeItemFromBasket(testItemTwo);
        assertEquals(1, testBasket.numberOfItemsInBasket());
        assertEquals(2.75, testBasket.getTotal(), 0.01);
    }

    @Test
    public void canEmptyBasket() {
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        assertEquals(2, testBasket.numberOfItemsInBasket());
        testBasket.emptyBasket();
        assertEquals(0, testBasket.numberOfItemsInBasket());
        assertEquals(0, testBasket.getTotal(), 0.01);
    }

    @Test
    public void canAddDiscount() {
        testBasket.addDiscount(testBogofOne);
        assertEquals(1, testBasket.numberOfDiscounts());
    }

    @Test
    public void canAddMoreThanOneDiscount() {
        testBasket.addDiscount(testBogofOne);
        testBasket.addDiscount(testLoyaltyCardOne);
        testBasket.addDiscount(testPercentOffOne);
        assertEquals(3, testBasket.numberOfDiscounts());
    }

    @Test
    public void canOnlyAddOneBogof() {
        testBasket.addDiscount(testBogofOne);
        testBasket.addDiscount(testBogofTwo);
        assertEquals(1, testBasket.numberOfDiscounts());
    }

    @Test
    public void canOnlyAddOneLoyaltyCard() {
        testBasket.addDiscount(testLoyaltyCardOne);
        testBasket.addDiscount(testLoyaltyCardTwo);
        assertEquals(1, testBasket.numberOfDiscounts());
    }

    @Test
    public void canOnlyAddOnePercentOff() {
        testBasket.addDiscount(testPercentOffOne);
        testBasket.addDiscount(testPercentOffTwo);
        assertEquals(1, testBasket.numberOfDiscounts());
    }

    @Test
    public void discountsOrdered() {
        testBasket.addDiscount(testPercentOffOne);
        testBasket.addDiscount(testBogofOne);
        testBasket.addDiscount(testLoyaltyCardOne);
        assertEquals(testBogofOne, testBasket.getDiscounts().first());
        assertEquals(testLoyaltyCardOne, testBasket.getDiscounts().last());
    }

    @Test
    public void applyDiscountsBogofAndLoyalty() {
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        testBasket.AddItemToBasket(testItemOne);
        testBasket.addDiscount(testBogofOne);
        testBasket.addDiscount(testLoyaltyCardOne);
        testBasket.applyDiscounts();
        assertEquals(4.165, testBasket.getTotal(), 0.01);
    }

    @Test
    public void applyDiscountsBogofAndPercentOff() {
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemThree);
        testBasket.addDiscount(testBogofOne);
        testBasket.addDiscount(testPercentOffOne);
        testBasket.applyDiscounts();
        assertEquals(22.275, testBasket.getTotal(), 0.01);
    }

    @Test
    public void applyDiscountsPercentOffAndLoyalty() {
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        testBasket.AddItemToBasket(testItemThree);
        testBasket.addDiscount(testLoyaltyCardOne);
        testBasket.addDiscount(testPercentOffOne);
        testBasket.applyDiscounts();
        assertEquals(21.83, testBasket.getTotal(), 0.01);
    }

    @Test
    public void applyDiscountsAll() {
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        testBasket.AddItemToBasket(testItemThree);
        testBasket.addDiscount(testLoyaltyCardOne);
        testBasket.addDiscount(testPercentOffOne);
        testBasket.addDiscount(testBogofOne);
        testBasket.applyDiscounts();
        assertEquals(21.83, testBasket.getTotal(), 0.01);
    }
}
