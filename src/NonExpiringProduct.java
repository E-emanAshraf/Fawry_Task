// Product that does not expire but may require shipping
class NonExpiringProduct extends Product implements ShippableItem {
    private double weight;

    public NonExpiringProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public NonExpiringProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public boolean IsShippable() {
        return weight != 0;
    }

    @Override
    public double getWeight() { return weight; }
    @Override
    public String getName() { return name; }
}
