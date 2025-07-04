import java.util.AbstractMap;
import java.util.ArrayList;

// Clerk handles checkout process
class Clerk {
    public final int SHIPPING_PER_UNIT = 10;

    // Perform checkout for the customer with the given cart
    public void CheckOut(Customer customer, Cart cart) {
        double subtotal = 0.0f;
        double shipping_fees = 0.0f;
        double total;
        double remaining;
        boolean exp_or_out = false;
        ArrayList<AbstractMap.SimpleEntry<ShippableItem, Integer>> shippable = new ArrayList<>();

        if(cart.IsOut()){
            exp_or_out = true;
        }
        for (AbstractMap.SimpleEntry<Product, Integer> p : cart.getProducts()) {
            if (p.getKey() instanceof ExpiringProduct) {
                if (((ExpiringProduct) p.getKey()).IsExpired()) {
                    exp_or_out = true;
                    continue;
                }
            }
            Product product = p.getKey();
            p.getKey().quantity-=p.getValue();
            if (product.IsShippable()) {
                ShippableItem temp = (ShippableItem) product;
                shipping_fees += p.getValue() * SHIPPING_PER_UNIT;
                shippable.add(new AbstractMap.SimpleEntry<>(temp, p.getValue()));
            }
            subtotal += p.getKey().getPrice() * p.getValue();
        }

        total = shipping_fees + subtotal;
        remaining = customer.getBalance() - total;
        double total_weight = 0.0f;

        if (!shippable.isEmpty()) {
            System.out.println("***Shipment notice***");
            for (AbstractMap.SimpleEntry<ShippableItem, Integer> p : shippable) {
                System.out.println(p.getValue() + "x " + p.getKey().getName() + "         " + p.getKey().getWeight()*p.getValue());
                total_weight += p.getKey().getWeight()*p.getValue();
            }
            System.out.println("Total package weight =:" + (total_weight / 1000) + " kg\n");
        }

        System.out.println("***Checkout receipt***");
        for (AbstractMap.SimpleEntry<Product, Integer> p : cart.getProducts()) {
            System.out.println(p.getValue() + "x " + p.getKey().name + "         " + p.getKey().getPrice()*p.getValue());
        }

        if (cart.IsEmpty() || customer.getBalance() < total || exp_or_out) {
            System.out.println("\nERROR:Cannot proceed to checkout: cart is empty, insufficient balance, or product expired/out of stock.\n");
        } else {
            customer.setBalance(remaining);
            System.out.println("\n--------------------------");
            System.out.println("SubTotal: " + subtotal);
            System.out.println("Shipping_Fees: " + shipping_fees);
            System.out.println("Total: " + total);
            System.out.println("Customer Balance After Check Out: " + remaining+"\n");
        }
    }
}