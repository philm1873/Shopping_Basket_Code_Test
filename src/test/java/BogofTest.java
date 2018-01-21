import basket.Basket;
import basket.Item;
import discounts.Bogof;
import discounts.LoyaltyCard;
import discounts.PercentOff;
import org.junit.Before;
import org.junit.Test;

public class BogofTest {
    private Basket testBasket;
    private Item testItemOne;
    private Item testItemTwo;
    private Item testItemThree;
    private Bogof testBogofOne;
    private LoyaltyCard testLoyaltyCardOne;
    private PercentOff testPercentOffOne;

    @Before
    public void before() {
        testBasket = new Basket();
        testItemOne = new Item("Burger", 2.75, true);
        testItemTwo = new Item("Cheese", 1.50, false);
        testItemThree = new Item("Burger", 2.75, true);
        testBasket.AddItemToBasket(testItemOne);
        testBasket.AddItemToBasket(testItemTwo);
        testBasket.AddItemToBasket(testItemThree);
        testBogofOne = new Bogof();
        testLoyaltyCardOne = new LoyaltyCard();
        testPercentOffOne = new PercentOff();
        testBasket.addDiscount(testBogofOne);
        testBasket.addDiscount(testLoyaltyCardOne);
        testBasket.addDiscount(testPercentOffOne);
    }

    @Test
    public void canApplyDiscount() {

    }
}
