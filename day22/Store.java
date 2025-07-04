package day22;

import javax.print.DocFlavor.STRING;

abstract class ProductForSale{
    String type;
    int price;
    String discription;

    ProductForSale(String type, int price, String discription){
        this.type = type;
        this.price = price;
        this.discription = discription;
    }

    public int getPrice(){
        return this.getPrice(1);
    }

    public int getPrice(int cnt){
        return cnt * this.price;
    }

}

record OrderItem(int qty, ProductForSale product){}

public class Store {
    
}
