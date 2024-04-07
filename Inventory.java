

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    public static List<Product> products = new ArrayList<>();
    public static List<Product> listproducts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static final Inventory inventory = new Inventory();

    public static Inventory get() {
        return inventory;
    }



    public static void addProduct(String seller) {
        System.out.println("Please provide the following details of the product!");
        System.out.println("Name : ");
        String name = sc.next();
        System.out.println("Type : ");
        String type = sc.next();
        System.out.println("Is the product certified to sell on e-commerce?");
        String s = sc.next();
        System.out.println("Price: ");
        int price = sc.nextInt();
        System.out.println("Stock: ");
        int stock = sc.nextInt();
        if(s.indexOf('y')!=-1)
            listproducts.add(new Product(seller,s,name, type, price, stock));
        else    
            System.out.println("We're Sorry!\nYour Product is not eligible to be on Site!");
    }

    public void modifyProduct(){
        System.out.println("Enter the product name:");
        String name = sc.next();
        boolean flag = true;
        for(Product p : products) {
            if(p.name.equals(name)) {
                    System.out.println("Updated Stock:");
                    int stock = sc.nextInt();
                    p.stock += stock;
                    System.out.println("Product updated! :)\nThe updated stock of the product : " + p.name + " is " + p.stock );
                    System.out.println("Updated Price:");   
                    int price = sc.nextInt();
                    p.price = price;   
                    System.out.println("Product updated! :)\nThe updated price of the product : " + p.name + " is " + p.price ); 
                    flag = false;
                    break;
            }
        }
        if(flag)
            System.out.println("No products found!");
    }

    public void SellerLogin() {
        System.out.println(" Enter the name of your company: ");
        String name = sc.next();
        int condition;
        System.out.println("Welcome " + name + "!\n");
        do {
            System.out.println("\tSeller - Menu");
            System.out.println("1.Add Items");
            System.out.println("2.List Items");
            System.out.println("3.Modify Items");
            System.out.println("4.Go back");
            condition = sc.nextInt();
            switch (condition) {
                case 1:
                    addProduct(name);
                    break;
                case 2:
                    boolean fg = true;
                    for(Product p : products) {
                        if(p.seller.equals(name)){
                            p.Seller_display();
                            fg = false;
                        }
                    }
                    if(fg)
                        System.out.println("There are no Products to display!\nPlease add products to display");
                    break;
                case 3:
                    modifyProduct();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid option! Please try again :(");
                    break;
            }
        } while (condition !=4);  
    }


    public void display() {
        int i =1;
        for(Product product: products) {
            System.out.println("Product :" + i++);
            product.displayIventory();
        }
    }

}

