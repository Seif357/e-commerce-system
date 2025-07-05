public class Product {
    private final String name;
    private final double price;
    private int quantity;


    public String getName(){return name;}
    public double  getPrice(){return price;}
    public int getQuantity(){return quantity;}
    public Product(String name, double price, int quantity){
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public void restoreQuantity(int amount) {
        if (amount < 0) return;
        this.quantity += amount;
    }
    public boolean reduceQuantity(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            return true;
        } else {
            return false;
        }
    }
}
