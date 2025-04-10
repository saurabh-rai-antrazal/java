package day5.inheritance;
class SavingAccount extends Account{
    private fixedDeposite;
    void deposite (double ammount){
        setBalance(getBalance() + ammount);
    }
}

class LoanAccount extends Account{
    void getLoan(double ammount){
        setBalance(getBalance() - ammount);

    }
}

public class Account {
    private double balance;
    private String name;
    private String dateOfBirth;
    private String mobileNumber;
    
    Account () {
        balance = 0.0D;
    }

    public void setter(String name, String dateOfBirth, String mobileNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }

}
