import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product Mobile=new Product("Mobile",20.532,1000000000);
        Product Scratch_cards=new Product("Scratch Cards",20.532,1000000000);
        ExpirableShippableProduct cheese=new ExpirableShippableProduct("cheese",3,3, LocalDate.parse("2018-11-01"),60.32321);
        ExpirableProduct Biscuits=new ExpirableProduct("Biscuits",231,883,LocalDate.parse("2026-11-01"));
        ShippableProduct TV = new ShippableProduct("TV",33.423121,413,493.42424);
        Cart cart = new Cart();
        Cart cart2 = new Cart();
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
        if(cart.getProducts().isEmpty()){
            throw new RuntimeException("cart is empty");
        }
        double Subtotal=0;
        double Shipping;
        double Amount;
        double TotalWeight=0;
        System.out.println("** Shipment notice **");
        for(CartItem Item: cart.getProducts())
        {
            if (Item.getProduct() instanceof Shippable) {
                System.out.print(Item.getQuantity()+"x "+Item.getProduct().getName()+"\t"+((Shippable) Item.getProduct()).getWeight()+"g\n");
                TotalWeight += ((Shippable) Item.getProduct()).getWeight();
            }
        }
        System.out.println("Total package weight "+TotalWeight/1000+"kg");
        Shipping=(TotalWeight/1000)*27.27;
        System.out.println("** Checkout receipt **");
        for(CartItem Item: cart.getProducts())
        {
            System.out.print(Item.getQuantity()+"x "+Item.getProduct().getName()+"\t"+Item.getProduct().getPrice()+"\n");
            Subtotal+=Item.getProduct().getPrice()*Item.getQuantity();
        }
        Amount=Subtotal+Shipping;
        System.out.println("----------------------");
        System.out.println("Subtotal: "+Subtotal);
        System.out.println("Shipping: "+Shipping);
        System.out.println("Amount: "+Amount);

        if (!customer.deductBalance(Amount)) {
            throw new RuntimeException("Insufficient balance " + customer.getBalance() + " to pay Amount " + Amount);
        }
    }
}
