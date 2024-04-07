

public class Product {
    // public int items;
    public String seller;
    public String name;
    public String type;
    public String cert;
    public int price;
    public int stock;
    public int quantity;
    public int totalamount;

    public Product (String seller,String s, String name, String type, int price, int stock) {
        this.name   = name;
        this.cert   = s;
        this.type   = type;
        this.price  = price;
        this.stock  = stock;
        this.seller = seller;
        System.out.println("Product Added Succefully!");
    }

    public Product (String name, int price,int totalamount, int qauntity) {
        this.name        = name;
        this.price       = price;
        this.quantity    = qauntity;
        this.totalamount = price*qauntity;
    }

    public void Seller_display() {
        System.out.println();
        System.out.println("\tProduct details");
        System.out.println("Product Name : " + name);
        System.out.println("Product Type : " + type);
        System.out.println("Product Price: " + price);
        System.out.println("Product Stock: " + stock);
    }

    public void displayIventory() {
        System.out.println();
        System.out.println("Name : " + name);
        System.out.println("Type : " + type);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stock);
    }

    public void displayCart() {
        System.out.println();
        System.out.println("Name : " + name);
        System.out.println("Type : " + type);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + quantity);
        System.out.println("Total: " + totalamount);
    }

    public void displayAdmin() {
        System.out.println();
        System.out.println("Seller   : " + seller);
        System.out.println("Name     : " + name);
        System.out.println("Type     : " + type);
        System.out.println("Certified:" + cert);
        System.out.println("Price    : " + price);
        System.out.println("Stock    : " + stock);
    }

}
