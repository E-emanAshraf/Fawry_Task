import java.time.LocalDate;

// Product that can expire and may require shipping
class ExpiringProduct extends Product implements ShippableItem {
    private LocalDate expiryDate;
    private double weight;

    public ExpiringProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public ExpiringProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    // Checks if the product is expired
    public boolean IsExpired() {
        return LocalDate.now().isAfter(expiryDate);
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