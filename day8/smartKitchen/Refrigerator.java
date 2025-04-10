package day8.smartKitchen;

public class Refrigerator {
    private boolean hasWorkToDo;

    public void addWater(){
        hasWorkToDo = true;
    }
    public void orderFood(){
        if(hasWorkToDo){
            System.out.println("Ordering food ....");
            hasWorkToDo = false;
        }
    }
}
