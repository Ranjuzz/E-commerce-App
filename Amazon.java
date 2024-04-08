
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Amazon {

    static Scanner sc = new Scanner(System.in);
    private static Inventory inventory = Inventory.get();
    public static List<Customer> customers = new ArrayList<>();
    private static Admin admin = Admin.getObject();

    // @SuppressWarnings("static-access")

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        inventory.products.add(new Product("Router", "Yes", "Titan Eyeplus", "Spectacles", 5799, 76));
        inventory.products.add(new Product("Router", "Yes", "Titan Watch", "Watch", 4700, 354));
        inventory.products.add(new Product("Looptech", "Yes", "Phone", "Gadgets", 69000, 34));
        inventory.products.add(new Product("Router", "Yes", "Service", "nothing", 5567, 765));
        // for(Product pr : inventory.products) {
        // System.out.println(pr.name);
        // }
        int condition;
        do {
            System.out.println("\tLogin - Menu");
            System.out.println("1.Admin");
            System.out.println("2.Seller");
            System.out.println("3.Customer");
            System.out.println("4.Exit");
            condition = sc.nextInt();

            switch (condition) {
                case 1:
                    admin.adminLogin();
                    break;

                case 2:
                    inventory.SellerLogin();
                    break;

                case 3:
                    customerLogin();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid Login! :(\n Please try again!");
                    break;
            }

        } while (condition != 4);

    }

    public static void customerLogin() {
        int inp;
        System.out.println("Enter your Name:");
        String name = sc.nextLine();
        Customer customer = new Customer(name, 1234);
        customers.add(customer);
        // Customer customer = new Customer(name, 1234);
        System.out.println("Welcome " + name + "!");
        System.out.println("--------- M E N U ---------");
        do {
            System.out.println("1. List Items");
            System.out.println("2. View Cart ");
            System.out.println("3. Check Out");
            System.out.println("4. Empty Cart");
            System.out.println("5. Exit");
            inp = sc.nextInt();
            switch (inp) {
                case 1:
                    customer.buying(customer);
                    break;
                case 2:
                    customer.display();
                    break;
                case 3:
                    customer.checkOut();
                    break;
                case 4:
                    customer.clearCart();
                    break;
                case 5:
                    System.out.println("Thanks for shopping with us!\nCome again\nHave a great day :)");
                    break;
                default:
                    System.out.println("Invalid Option. Try again");
                    break;
            }
        } while (inp != 5);

    }

}