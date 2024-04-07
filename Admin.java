

import java.util.HashSet;
import java.util.Scanner;

public class Admin {
    
    private static final Admin admin = new Admin();
    private static HashSet<String> company = new HashSet<>();
    static Scanner sc = new Scanner(System.in);
    private static String name = "admin";
    private static int pin = 1234;


    public static void companies() {
        System.out.println();
        if(Inventory.products.isEmpty())
            System.out.println("There are no companies yet!");
        else{
            int i = 1;
            for(Product product: Inventory.products) {
                if(company.add(product.seller))
                System.out.println(i++ + "." + product.seller);
            }
        }
    }

    public static void customers() {
        if(Amazon.customers.isEmpty())
            System.out.println("There are no customers yet!");
        else{
        int i = 1;
        System.out.println();
        for(Customer customer: Amazon.customers) {
            System.out.println(i++ + "" + customer.name);
        }
    }
    }

    public static void products() {
        System.out.println();
        // int i = 1;
        for (Product product : Inventory.products) {
            product.displayIventory();
        }
    }

    public static void approvals() {
        if (Inventory.listproducts.isEmpty()) {
            System.out.println("No Requests");
            return;
        }
        int re =0,ap=0,tot=0;
        System.out.println("\tProducts List");
        for(Product p: Inventory.listproducts) {
            p.displayAdmin();
            System.out.println("1.Approve\t2.Delete");
            int in = sc.nextInt();
            if(in == 1) {
                Inventory.addProduct(p.seller);
                ap++; 
            }
            else {
                System.out.println("Rejected Succesfully!");
                re++;
            }
            tot++;
        }
        System.out.println("Total Items:" + tot);
        System.out.println("   Accpeted:" + ap);
        System.out.println("   Rejected:" + re);

    }


    public static Admin getObject() {
        return admin;
    }

    public boolean adminLogin() {
        System.out.println("User name:");
        String iname = sc.next();
        System.out.println(" Password:");
        int ipin = sc.nextInt();
        if(name.equals(iname) && ipin ==pin) {
            adminMenu();
            return true;
        }
        else {
            System.out.println("Invalid Usernme/Password!");
            return false;
        }
    }

    public void adminMenu() {
        int inp;
        do {
            System.out.println("--------- Admin Console ---------");
            System.out.println("1. Companies");
            System.out.println("2. Customers");
            System.out.println("3. Products ");
            System.out.println("4. Approvals");
            System.out.println("5. Exit");
            inp = sc.nextInt();
            switch (inp) {
                case 1:
                    companies();
                    break;
                case 2:
                    customers();
                    break;
                case 3:
                    products();
                    break;
                case 4:
                    approvals();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }while(inp!=5);
    }
}

