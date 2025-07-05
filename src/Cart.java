import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> productName=new ArrayList<>();
int prouductQuantinty;
void add(Product productName, int prouductQuantinty){
    if (prouductQuantinty<this.prouductQuantinty){
        this.prouductQuantinty = prouductQuantinty;
    }
    else{
        System.out.println("there is only {this.prouductQuantinty} items from this product avalabile");
    }
}
}