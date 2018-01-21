package basket;

public class Item {
    private final String name;
    private double price;
    private boolean bogof;

    public Item(String name, double price, boolean bogof) {
        this.name = name;
        this.price = price;
        this.bogof = bogof;
    }

    public String getName() {
        return name;
    }

    public boolean isBogof() {
        return bogof;
    }
}
