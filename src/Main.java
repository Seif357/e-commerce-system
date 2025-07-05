import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product Mobile=new Product("Mobile",20.532,100_000_0000);
        ExpirableShippableProduct cheese=new ExpirableShippableProduct("cheese",3,3, LocalDate.parse("2025-11-01"),60.32321);
        ExpirableProduct Biscuits=new ExpirableProduct("Biscuits",231,883,LocalDate.parse("2026-11-01"));
        ShippableProduct TV = new ShippableProduct("TV",33.423121,413,493.42424);
        Cart cart = new Cart();
        cart.add(Mobile, 2);
        cart.add(Biscuits, 7);
        cart.add(Biscuits, 7);
        cart.add(Biscuits, 7);
        cart.add(TV, 95);
        cart.add(cheese, 1);
        Customer customer = new Customer(999999999);
        checkout(customer,cart);
    }
    static void checkout(Customer customer, Cart cart)
    {
        if(cart.getCartItems().isEmpty()){
            throw new RuntimeException("cart is empty");
        }
        double Subtotal=0;
        List<CartItem> successfullyReduced = new ArrayList<>();
        List<CartItem> shippableItems = new ArrayList<>();
        System.out.println("** Checkout receipt **");
        for(CartItem Item: cart.getCartItems())
        {
            Product product = Item.getProduct();
            System.out.println(Item.getQuantity() + "x " + product.getName() + "\t" + product.getPrice());
            if (product instanceof Expirable && ((Expirable) product).isExpired())
            {
                throw new RuntimeException("Product is expired: " + product.getName());
            }
            if(!product.reduceQuantity(Item.getQuantity()))
            {
                throw new RuntimeException("Invalid quantity or out of stock for product: " + product.getName());
            }
            successfullyReduced.add(Item);
            if (product instanceof Shippable) {
                shippableItems.add(Item);
            }
            Subtotal+=product.getPrice()*Item.getQuantity();
        }
        double Shipping= ShippingService(shippableItems);
        double Amount=Subtotal+Shipping;
        System.out.println("----------------------");
        System.out.println("Subtotal: "+Subtotal);
        System.out.println("Shipping: "+Shipping);
        System.out.println("Amount: "+Amount);
        if (!customer.deductBalance(Amount)) {
            for (CartItem item : successfullyReduced) {
                item.getProduct().restoreQuantity(item.getQuantity()); // You’ll need to add this method
            }
            throw new RuntimeException("Insufficient balance " + customer.getBalance() + " to pay Amount " + Amount);
        }
        System.out.println("Your balance after payment: "+customer.getBalance());
    }
    static double ShippingService(List<CartItem> shippableItems)
    {
        double TotalWeight=0;
        System.out.println("** Shipment notice **");
        for(CartItem Item: shippableItems)
        {
            if (Item.getProduct() instanceof Shippable) {
                System.out.print(Item.getQuantity()+"x "+Item.getProduct().getName()+"\t"+((Shippable) Item.getProduct()).getWeight()* Item.getQuantity()+"g\n");
                TotalWeight += ((Shippable) Item.getProduct()).getWeight()* Item.getQuantity();
            }
        }
        System.out.println("Total package weight "+TotalWeight/1000+"kg");
        return (TotalWeight/1000)*27.27;
    }
}
