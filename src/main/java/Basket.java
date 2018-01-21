import java.util.ArrayList;

public class Basket {
    ArrayList<Item> items;


    public Basket() {
        items = new ArrayList<>();
    }

    public int numberOfItemsInBasket() {
        return this.items.size();
    }

    public void AddItemToBasket(Item item) {
        this.items.add(item);
    }
}
