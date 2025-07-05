import java.time.LocalDate;

public class ExpirableShippableProduct extends Product implements Expirable,Shippable{
    private final double weight;
    private final LocalDate expiryDate;
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public boolean isExpired() {
        return this.expiryDate.isBefore(LocalDate.now());
    }
    @Override
    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }
    public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        if (expiryDate == null) {
            throw new IllegalArgumentException("Expiry date cannot be null");
        }
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

}
