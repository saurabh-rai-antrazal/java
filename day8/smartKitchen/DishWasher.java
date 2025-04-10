package day8.smartKitchen;

public class DishWasher {
    private boolean hasWorkToDo;
    
    public void loadDishwasher(){
        hasWorkToDo = true;
    }

    public void doDishes(){
        if(hasWorkToDo){
            System.out.println("");
            hasWorkToDo = false;
        }
    }
}
