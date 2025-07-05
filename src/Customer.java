public class Customer {
    private double balance;

    public Customer(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
    public boolean deductBalance(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }
}