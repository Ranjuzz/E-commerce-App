
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {

    private static Scanner sc = new Scanner(System.in);
    @SuppressWarnings("unused")
    private static Inventory inventory = Inventory.get();
    public String name;
    // public int id;
    public int pass;
    public int number;
    public static List<Product> cart = new ArrayList<>();
    public Customer customer;

    public Customer(String name, int pass) {
        this.name = name;
        this.pass = pass;
    }

    public void display() {
        int totaProduct = 0, totalamount = 0;
        for (Product p : cart) {
            p.displayCart();
            totalamount += p.totalamount;
            totaProduct += p.quantity;
        }
        if (totaProduct != 0) {
            System.out.println("Total Amount in Rs: " + totalamount);
            System.out.println("    Total Products: " + totaProduct);
        } else {
            System.out.println(":(\nYour Cart is empty!\n Shop something!");
        }
    }

    public void buying(Customer customer) {
        for (Product p : Inventory.products)
            p.displayIventory();
        System.out.println("\nSelect the Product by name:");
        String name = sc.nextLine();
        System.out.println("\nQuantity:");
        int quantity = sc.nextInt();
        for (Product product : Inventory.products) {
            if (product.name.equalsIgnoreCase(name)) {
                if (product.stock - quantity < 0)
                    System.out.println("Soory!\nWe ran out of Stock");
                else {
                    addcart(product, quantity);
                    product.stock -= quantity;
                }
                break;
            }

        }
    }

    public static void addcart(Product p, int quantity) {
        cart.add(new Product(p.name, p.price, p.quantity * p.price, quantity));
        System.out.println("\nItems added Succefully!");
    }

    public void deleteCartItems(Product p) {
        if (cart.contains(p))
            cart.remove(p);
    }

    public void clearCart() {
        cart.clear();
    }

    public void checkOut() {
        if (cart.isEmpty()) {
            System.out.println(":(\nYour Cart is empty!\n Shop something!");
            return;
        }
        display();
        System.out.println("\nTo proceed type Yes");
        String s = sc.nextLine();
        if (s.equalsIgnoreCase("yes")) {
            System.out.println("Select payment Method:\n1.UPI \n2.NetBanking");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter UPI id\n Supported banks - [ HDFC / IOB / AXIS]");
                    String upi = sc.nextLine();
                    if (upi.endsWith("@okhdfc") || upi.endsWith("@okaxis") || upi.endsWith("@okiob")) {
                        System.out.println("Payment Successfull");
                        for (Product p : cart)
                            Inventory.soldproducts.add(p);
                        cart.clear();
                        System.out.println("Thanks for ordering with us!\n Continue Shopping!");
                    } else
                        System.out.println("Invalid UPI | Transaction Failed !");
                    break;
                case 2:
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid Transaction! Try Again");
                    break;
            }
        }
    }
}
