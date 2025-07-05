public class Product {
    private final String name;
    private final double price;
    private int quantity;


    public String getName(){return name;}
    public double  getPrice(){return price;}
    public int getQuantity(){return quantity;}
    public Product(String name, double price, int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    //I initially explored immutability for Product,
    // but since the system expects quantity to be updated during checkout,
    // I made it mutable and encapsulated quantity control via a domain method (reduceQuantity)."
    public boolean reduceQuantity(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            return true;
        } else {
            return false;
        }
    }
}
