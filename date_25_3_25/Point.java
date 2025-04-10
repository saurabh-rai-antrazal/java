// Exercise 33

public class Point {
    // write code here
    private int x;
    private int y;
    
    
    public Point(){}
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public double distance(){
        return this.distance(0, 0);
    }
    
    public double distance(Point b){
        return this.distance(b.getX(), b.getY());
    }
    
    public double distance(int x, int y){
        double a = (double) (x - this.x);
        double b = (double) (y - this.y);
        return Math.sqrt((a * a) + (b * b));
    }
}