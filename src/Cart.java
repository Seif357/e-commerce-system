import java.util.ArrayList;
import java.util.List;

public class Cart {
   private List<CartItem> CartItems = new ArrayList<>();
    public List<CartItem> getCartItems() {
        return CartItems;
    }

    public void add(Product product, int quantity){
        int alreadyInCart = 0;
        for (CartItem item : CartItems) {
            if (item.getProduct().equals(product)) {
                alreadyInCart += item.getQuantity();
            }
        }
        if (product.getQuantity() >= alreadyInCart + quantity){
            CartItems.add(new CartItem(product, quantity));
        }
        else {
            System.out.println("Invalid quantity requested for product: " + product.getName());
        }

}
}