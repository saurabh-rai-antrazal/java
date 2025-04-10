package day8.smartKitchen;

public class CoffeeMaker {
    private boolean hasWorkToDo;

    public void pourMilk(){
        hasWorkToDo = true;
    }
    public void brewCoffee(){
        if(hasWorkToDo){
            System.out.println("Brewing Coffee ....");
            hasWorkToDo = false;
        }
    }
}
