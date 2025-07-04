// Abstract Product class
abstract class Product {
    protected String name;
    private double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    // Determines if the product requires shipping
    public abstract boolean IsShippable();
}