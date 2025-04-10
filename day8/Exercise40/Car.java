public class Car {
    // write code here
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;
    
    public Car(int cylinders, String name){
        this.engine = true;
        this.wheels = 4;
        this.cylinders = cylinders;
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCylinders(){
        return cylinders;
    }
    
    public String startEngine(){
        return "Car engine is starting";
    }
    
    public String accelerate () {
        return "car is accelerating";
    }
    
    public String brake () {
        return "car is breaking";
    }
}