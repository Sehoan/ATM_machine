public class Atm {
    /*
     * private fields constructor methods getter/setter if needed
     */
    // declaration, initalization what's the difference?

    private BankAccount[] bankAccounts;
    private BankAccount loggedAccount;
    private int emptySlot;

    /*
     * -- private fields --> bank accounts ---------------> related to Login Process
     * (if logged into my account, i can see my bank account)
     */
    public Atm() {
        // private BankAccount[] account1 = new BankAccounts();
        bankAccounts = new BankAccount[100];
        loggedAccount = new BankAccount("", "", "");
        emptySlot = 0;
        // bankAccounts => [BankAccount1,BankAccount2,BankAccount3,BankAccount4 ]
        // bankAccounts => [BankAccount1,BankAccount2]
    }
    // deposit() withdraw() transfer() createAccount()
    // write the method headers

    // Method Header => (Access Modifer) (Return Type) (method name) (parameters)
    public void createAccount(String holder, String password) {
        BankAccount newAccount = new BankAccount(holder, createAccountNumber(), password);
        bankAccounts[emptySlot] = newAccount;
        emptySlot++;
    }

    // return true if successful, false if failed
    public boolean loginToAccount(String holder, String password) {
        for (int i = 0; i < emptySlot; i++) {
            BankAccount b = bankAccounts[i];
            if (b.getHolder().equals(holder) && b.getPassword().equals(password)) {
                loggedAccount = b;
                return true;
            }
        }
        return false;
    }

    public void deposit(String amount) {
        int amt = Integer.parseInt(amount);
        loggedAccount.deposit(amt);
    }

    // what if the account has insufficient balance?
    public boolean withdraw(String amount) {
        int amt = Integer.parseInt(amount);
        if (loggedAccount.getBalance() >= amt) {
            loggedAccount.withdraw(amt);
            return true;
        } else {
            return false;
        }
    }

    // what if the account has insufficient balance?
    // what if the number input is not found?
    public String transfer(String amount, String number) {
        int amt = Integer.parseInt(amount);

        if (loggedAccount.getBalance() >= amt) {
            for (int i = 0; i < emptySlot; i++) {
                BankAccount destination = bankAccounts[i];
                if (destination.getNumber().equals(number)) {
                    destination = bankAccounts[i];
                    destination.deposit(amt);
                    loggedAccount.withdraw(amt);
                    return "Transfer Completed!";
                }
            }
        } else {
            return "Transfer Failed => Insufficient Balance";
        }

        return "Destination Account Not Found";
    }

    public BankAccount getLoggedAccount() {
        return loggedAccount;
    }

    private String createAccountNumber() {
        String ret = "";
        for (int i = 0; i < 11; i++) {
            int digit = (int) (Math.random() * 10);
            if (i == 3 || i == 7) {
                ret += "-" + digit;
            } else {
                ret += digit;
            }
        }

        return ret;
    }

}
