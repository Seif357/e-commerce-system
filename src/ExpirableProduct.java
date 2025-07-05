import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expirable{
    private final LocalDate expiryDate;

    @Override
    public boolean isExpired() {
        return this.expiryDate.isBefore(LocalDate.now());
    }
    @Override
    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }
    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }
}
