public class BankAccount {
    /*
     * private fields constructor methods getter/setter if needed
     */

    // private fields--> AccountHolder, AccountNumebr, Password, Balance
    private String accountHolder;
    private String accountNumber;
    private String password;
    private int balance;

    public BankAccount(String holder, String number, String password) {
        // int,double,boolean => primitive data type
        accountHolder = holder;
        accountNumber = number;
        this.password = password;
        balance = 0;

        /*
         * accountHolder = new AccountHolder(); accountNumber = new AccountNumber();
         * password = new Password(); balance = new Balance();
         */
    }

    public void deposit(int amt) {
        balance += amt;
    }
    public void withdraw(int amt) {
        balance -= amt;
    }

    public void show() {
        System.out.println("This is the summary of your Bank Account");
        System.out.println("________________________________________");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("password: " + password);
        System.out.println("balance: " + balance);
        System.out.println("----------------------------------------");
    }

    public String getHolder() {
        return accountHolder;
    }
    public String getPassword() {
        return password;
    }
    public String getNumber() {
        return accountNumber;
    }
    public int getBalance() {
        return balance;
    }

}
