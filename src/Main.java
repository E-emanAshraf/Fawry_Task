import java.time.LocalDate;

// Main class to run the system
public class Main {
    public static void main(String[] args) {
        // no errors expected
        System.out.println("=========no errors expected=========");
        Customer customer1 = new Customer("Eman", 3000);

        Product cheese = new ExpiringProduct("Cheese", 100, 10, LocalDate.of(2025, 7, 20));
        Product biscuits = new ExpiringProduct("Biscuits", 150, 15, LocalDate.of(2025, 7, 27), 900);
        Product tv = new NonExpiringProduct("TV", 200, 12);
        Product mobile = new NonExpiringProduct("Mobile", 400, 20, 200);

        Cart cart1 = new Cart();
        cart1.AddProduct(cheese, 2);
        cart1.AddProduct(biscuits, 1);
        cart1.AddProduct(mobile, 1);
        cart1.AddProduct(tv, 1);

        Clerk clerk1 = new Clerk();
        clerk1.CheckOut(customer1, cart1);


        // out of stock
        System.out.println("\n==========Out Of Stock=========");
        Customer customer2 = new Customer("mahmoud", 2000);

        Product camera = new ExpiringProduct("Camera", 100, 0, LocalDate.of(2025, 7, 20));

        Cart cart2 = new Cart();
        cart2.AddProduct(camera, 2);
        cart2.AddProduct(biscuits, 1);
        cart2.AddProduct(mobile, 1);
        cart2.AddProduct(tv, 1);

        Clerk clerk2 = new Clerk();
        clerk2.CheckOut(customer2, cart2);

        //customer balance is not enough
        System.out.println("\n==========customer balance is not enough=========");
        Customer customer3 = new Customer("salma", 800);

        Cart cart3 = new Cart();
        cart3.AddProduct(cheese, 2);
        cart3.AddProduct(biscuits, 1);
        cart3.AddProduct(mobile, 1);
        cart3.AddProduct(tv, 1);

        Clerk clerk3 = new Clerk();
        clerk3.CheckOut(customer3, cart3);

        //product is expired
        System.out.println("\n==========product is expired=========");
        Customer customer4 = new Customer("ahmed", 2000);
        Product milk = new ExpiringProduct("Milk", 100, 10, LocalDate.of(2025, 7, 1));
        Cart cart4 = new Cart();
        cart4.AddProduct(milk, 2);
        cart4.AddProduct(biscuits, 1);
        cart4.AddProduct(mobile, 1);
        cart4.AddProduct(tv, 1);

        Clerk clerk4 = new Clerk();
        clerk4.CheckOut(customer4, cart4);

        //cart is empty
        System.out.println("\n==========cart is empty=========");
        Cart cart5 = new Cart();
        clerk4.CheckOut(customer4, cart5);
    }
}
