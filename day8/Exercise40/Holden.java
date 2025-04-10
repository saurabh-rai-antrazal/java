public class Holden extends Car{
    // write code here
    public Holden(int cylinders, String name){
        super(cylinders , name);
    }
    
    public String startEngine(){
        return "Holden engine is starting";
    }
    
    public String accelerate () {
        return "Holden is accelerating";
    }
    
    public String brake () {
        return "Holden is breaking";
    }
}