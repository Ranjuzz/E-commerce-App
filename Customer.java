

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
        for(Product p: cart) {
            p.displayCart();
            totalamount+=p.totalamount;
            totaProduct+=p.quantity;
        }
        if(totaProduct!=0){
            System.out.println("Total Amount in Rs: " + totalamount);
            System.out.println("    Total Products:" + totaProduct);
        }
        else {
            System.out.println(":(\nYour Cart is empty!\n Shop something!");
        }
    }

    public void buying(Customer customer) {
        for(Product p : Inventory.products)
            p.displayIventory();
        System.out.println("\n Select the Product");
        String name = sc.next();
        System.out.println("\n Quantity");
        int quantity = sc.nextInt();
        for(Product product : Inventory.products )
        {
            if(product.name.equalsIgnoreCase(name)) {
                if(product.stock-quantity<0)
                    System.out.println(" Soory!\n We ran out of Stock");
                else {
                    addcart(product, quantity);
                    product.stock -= quantity; 
                }
                break;
            }
            
        }
    }

    public static void addcart(Product p, int quantity) {
            cart.add(new Product(p.name, p.price,p.quantity*p.price, quantity));
            System.out.println("\n Items added Succefully!");
    }

    public void deleteCartItems(Product p) {
        if(cart.contains(p))
            cart.remove(p);
    }

    public void clearCart() {
        cart.clear();
    }

    public void checkOut() {
        display();
        System.out.println("\nTo proceed type Yes");
        String s = sc.next();
        if(s.equalsIgnoreCase("yes")) {
            System.out.println("Select payment Method:\n1.UPI \n2.NetBanking");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter UPI id\n Supported banks - [ HDFC / IOB / AXIS]");
                    String upi = sc.next();
                    if(upi.endsWith("@okhdfc") || upi.endsWith("@okaxis") || upi.endsWith("@okiob")) {
                        System.out.println("Payment Successfull");
                        cart.clear();
                        System.out.println("Thanks for ordering with us!\n Continue Shopping!");
                    }
                    else
                        System.out.println("Invalid UPI | Transaction Failed !");
                    break;
            
                default:
                    System.out.println("Invalid Transaction! Try Again");
                    break;
                }
            }
    }
}


