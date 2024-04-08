import java.util.Random;

public class Product {
    // public int items;
    public String seller;
    public String name;
    public int id;
    public String type;
    public String cert;
    public int price;
    public int stock;
    public int quantity;
    public int totalamount;
    private static Random random = new Random();

    public Product(String seller, String s, String name, String type, int price, int stock) {
        this.name = name;
        this.cert = s;
        this.type = type;
        this.price = price;
        this.stock = stock;
        this.seller = seller;
        this.id = random.nextInt(100);
        // System.out.println("Product Added Succefully!");
    }

    public Product(String name, int price, int totalamount, int qauntity) {
        this.name = name;
        this.price = price;
        this.quantity = qauntity;
        this.totalamount = price * qauntity;
    }

    public void Seller_display() {
        System.out.println("---------------------------");
        System.out.println("\tProduct details");
        System.out.println("Name  : " + name);
        System.out.println("Type  : " + type);
        System.out.println("Price : " + price);
        System.out.println("Stock : " + stock);
        // System.out.println("---------------------------");
    }

    public void displayIventory() {
        System.out.println("--------------------------");
        System.out.println("Id    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Type  : " + type);
        System.out.println("Price : " + price);
        System.out.println("Stock : " + stock);
        // System.out.println("--------------------------");
    }

    public void displayCart() {
        System.out.println("---------------------------");
        System.out.println("Id    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Type  : " + type);
        System.out.println("Price : " + price);
        System.out.println("Stock : " + quantity);
        System.out.println("Total : " + totalamount);
        // System.out.println("---------------------------");
    }

    public void displayAdmin() {
        // System.out.println("---------------------------");
        System.out.println("Seller    : " + seller);
        System.out.println("Name      : " + name);
        System.out.println("Type      : " + type);
        System.out.println("Certified : " + cert);
        System.out.println("Price     : " + price);
        System.out.println("Stock     : " + stock);
        // System.out.println("---------------------------");
    }

    public void displaysold() {
        // System.out.println("---------------------------");
        System.out.println("Seller    : " + seller);
        System.out.println("Name      : " + name);
        System.out.println("Type      : " + type);
        System.out.println("Sold      : " + cert);
        System.out.println("Price     : " + price);
        System.out.println("StockLeft : " + stock);
        // System.out.println("---------------------------");
    }

}
