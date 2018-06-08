package basic;

public class Account 
{
    private String name ;
    private String balance ;
    
    public String getName() {
           return name;
    }
    public void setName(String holderName) {
           this.name = holderName;
    }
    public String getBalance() {
           return balance;
    }
    public void setBalance(String balance) {
           this.balance = balance;
    }
    @Override
    public String toString() {
    return "Account [Name=" + name + ", balance=" + balance + "]";
    }
}