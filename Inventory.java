
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    public static List<Product> products = new ArrayList<>();
    public static List<Product> soldproducts = new ArrayList<>();
    public static List<Product> listproducts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static final Inventory inventory = new Inventory();

    public static Inventory get() {
        return inventory;
    }

    // public static void listProducts() {

    // }

    public static void addProduct_admin(Product p) {
        products.add(p);
    }

    public static void addProduct(String seller) {
        System.out.println("Please provide the following details of the product!");
        System.out.println("Name : ");
        String name = sc.nextLine();
        name = sc.nextLine();
        System.out.println("Type : ");
        String type = sc.nextLine();
        sc.nextLine();
        System.out.println("Is the product certified to sell on e-commerce?");
        String s = sc.next();
        // sc.nextLine();
        System.out.println("Price: ");
        int price = sc.nextInt();
        System.out.println("Stock: ");
        int stock = sc.nextInt();
        listproducts.add(new Product(seller, s, name, type, price, stock));
        System.out.println("\nYour product in under review\nWe will review your product before adding!\n");
    }

    public void listProducts() {
        if (listproducts.isEmpty()) {
            System.out.println("There are no products for review");
            return;
        }
        for (Product p : listproducts) {
            p.displayIventory();
        }
    }

    public void modifyProduct() {
        System.out.println("Enter the product id:");
        int name = sc.nextInt();
        boolean flag = true;
        for (Product p : products) {
            if (p.id == name) {
                System.out.println("Updated Stock:");
                int stock = sc.nextInt();
                p.stock = stock;
                System.out.println(
                        "Product updated! :)\nThe updated stock of the product : " + p.name + " is " + p.stock);
                System.out.println("Updated Price:");
                int price = sc.nextInt();
                p.price = price;
                System.out.println(
                        "Product updated! :)\nThe updated price of the product : " + p.name + " is " + p.price);
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println("No products found!");
    }

    public void SellerLogin() {
        System.out.println(" Enter the name of your company: ");
        String name = sc.nextLine();
        int condition;
        System.out.println("\nWelcome " + name + "!\n");
        do {
            System.out.println("What do you wanna do?");
            System.out.println("1.Add Product");
            System.out.println("2.List Products");
            System.out.println("3.Products Under Review");
            System.out.println("4.Modify Items");
            System.out.println("5.Go back");
            condition = sc.nextInt();
            switch (condition) {
                case 1:
                    addProduct(name);
                    break;
                case 2:
                    boolean fg = true;
                    for (Product p : products) {
                        if (p.seller.equals(name)) {
                            p.Seller_display();
                            fg = false;
                        }
                    }
                    if (fg)
                        System.out.println("There are no Products to display!\nPlease add your products");
                    break;
                case 3:
                    listProducts();
                    break;
                case 4:
                    modifyProduct();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid option! Please try again :(");
                    break;
            }
        } while (condition != 5);
    }

    public void display() {
        int i = 1;
        for (Product product : products) {
            System.out.println("Product : " + i++);
            product.displayIventory();
        }
    }

}
