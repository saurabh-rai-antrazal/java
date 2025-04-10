package date_25_3_25;

import javax.print.DocFlavor.STRING;

public class Customer {
    private String name;
    private double creditLimit;
    private String email;

    public Customer() {
        this("no name", "noemail@gmail.com", 1000D);
        System.err.println("Empty constructor called");
    }

    public Customer(String name, String email, double creditLimit){
        this.name = name;
        this.email = email;
        this.creditLimit = creditLimit;
    }

    public Customer(String name, String email){
        this(name, email, 1000D);
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

}
