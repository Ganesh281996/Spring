package basic;

import java.util.Map;
public class Bank {      
       private String name;      
       private Map<String,Account> accounts;      
       
       public String getName() {
              return name;
       }
       public void setName(String name) {
              this.name = name;
       }
       public Map<String, Account> getAccounts() {
              return accounts;
       }
       public void setAccounts(Map<String, Account> accounts) {
              this.accounts = accounts;
       }  
}