import java.util.AbstractMap;
import java.util.ArrayList;

// Shopping cart to hold products and their quantities
class Cart {
    private ArrayList<AbstractMap.SimpleEntry<Product, Integer>> products;
    private boolean out_of_stock=false;
    public Cart() {
        products = new ArrayList<>();
    }

    // Add product to cart with a specific quantity
    public void AddProduct(Product item, int quantity) {
        if (item.quantity >= quantity) {
            products.add(new AbstractMap.SimpleEntry<>(item, quantity));
        }
        if(item.quantity==0){
            out_of_stock=true;
        }
    }

    public boolean IsOut(){
        return out_of_stock;
    }
    public ArrayList<AbstractMap.SimpleEntry<Product, Integer>> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<AbstractMap.SimpleEntry<Product, Integer>> products) {
        this.products = products;
    }

    // Check if the cart is empty
    public boolean IsEmpty() {
        return products.isEmpty();
    }
}