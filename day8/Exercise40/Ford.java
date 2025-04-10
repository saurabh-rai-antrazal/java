public class Ford extends Car{
    // write code here
    public Ford(int cylinders, String name){
        super(cylinders , name);
    }
    
    public String startEngine(){
        return "Ford engine is starting";
    }
    
    public String accelerate () {
        return "Ford is accelerating";
    }
    
    public String brake () {
        return "Ford is breaking";
    }
}