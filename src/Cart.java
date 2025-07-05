import java.util.ArrayList;
import java.util.List;

public class Cart {
   private List<CartItem> CartItems = new ArrayList<>();
    public List<CartItem> getProducts() {
        return CartItems;
    }

    public void add(Product product, int quantity){
        if (product.getQuantity() >= quantity){ // This logic is incorrect
            CartItems.add(new CartItem(product, quantity));
        }
        else {
            System.out.println("Invalid quantity requested for product: " + product.getName());
        }

}
}