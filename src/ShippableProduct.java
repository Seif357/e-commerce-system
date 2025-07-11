public class ShippableProduct extends Product implements Shippable {
    private final double weight;

    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public String getName() {
        return super.getName();
    }
    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }
}
